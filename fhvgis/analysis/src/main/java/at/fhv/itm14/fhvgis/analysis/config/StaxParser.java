package at.fhv.itm14.fhvgis.analysis.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import at.fhv.itm14.fhvgis.analysis.config.model.ClassifierConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.FeatureConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.ModeConfig;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVectorDefinition;

public class StaxParser {

	static final String FEATURES = "features";
	static final String FEATURE = "feature";
	static final String NAME = "name";
	static final String INDEX = "index";
	static final String ENABLED = "enabled";
	static final String MODES = "modes";
	static final String MODE = "mode";
	static final String ID = "id";
	static final String CLASSIFIERS = "classifiers";
	static final String CLASSIFIER = "classifier";

	public Config readConfig(String configFile) throws Exception {
		Config config = Config.getInstance();

		List<FeatureConfig> features = new ArrayList<>();
		List<ModeConfig> modes = new ArrayList<>();
		List<ClassifierConfig> classifiers = new ArrayList<>();

		config.setClassifierConfigs(classifiers);
		config.setFeatureConfigs(features);
		config.setModeConfigs(modes);

		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			FeatureConfig featureConfig = null;
			ModeConfig modeConfig = null;
			ClassifierConfig classifierConfig = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (FEATURES)) {
						while (eventReader.hasNext()) {
							event = eventReader.nextEvent();
							if (event.isStartElement()) {
								startElement = event.asStartElement();
								if (startElement.getName().getLocalPart() == (FEATURE)) {
									featureConfig = new FeatureConfig();
									continue;
								}
								if (startElement.getName().getLocalPart().equals(NAME)) {
									event = eventReader.nextEvent();
									String featureName = event.asCharacters().getData();
									if (!FeatureVectorDefinition.VALID_FEATURE_NAMES.contains(featureName)) {
										throw new Exception("Invalid feature name in Config.xml");
									}
									featureConfig.setName(featureName);
									continue;
								}
								if (startElement.getName().getLocalPart().equals(INDEX)) {
									event = eventReader.nextEvent();
									featureConfig.setIndex(Integer.parseInt(event.asCharacters().getData()));
									continue;
								}
								if (startElement.getName().getLocalPart().equals(ENABLED)) {
									event = eventReader.nextEvent();
									featureConfig.setEnabled(Boolean.parseBoolean(event.asCharacters().getData()));
									continue;
								}

							}

							if (event.isEndElement()) {
								EndElement endElement = event.asEndElement();
								if (endElement.getName().getLocalPart() == (FEATURE)) {
									features.add(featureConfig);
								}
								if (endElement.getName().getLocalPart() == (FEATURES)) {
									break;
								}
							}
						}
					}
					if (startElement.getName().getLocalPart() == (MODES)) {
						while (eventReader.hasNext()) {
							event = eventReader.nextEvent();
							if (event.isStartElement()) {
								startElement = event.asStartElement();
								if (startElement.getName().getLocalPart() == (MODE)) {
									modeConfig = new ModeConfig();
									continue;
								}
								if (startElement.getName().getLocalPart().equals(NAME)) {
									event = eventReader.nextEvent();
									modeConfig.setName(event.asCharacters().getData());
									continue;
								}
								if (startElement.getName().getLocalPart().equals(ID)) {
									event = eventReader.nextEvent();
									modeConfig.setId(Integer.parseInt(event.asCharacters().getData()));
									continue;
								}
								if (startElement.getName().getLocalPart().equals(ENABLED)) {
									event = eventReader.nextEvent();
									modeConfig.setEnabled(Boolean.parseBoolean(event.asCharacters().getData()));
									continue;
								}
							}

							if (event.isEndElement()) {
								EndElement endElement = event.asEndElement();
								if (endElement.getName().getLocalPart() == (MODE)) {
									modes.add(modeConfig);
								}
								if (endElement.getName().getLocalPart() == (MODES)) {
									break;
								}
							}
						}
					}
					if (startElement.getName().getLocalPart() == (CLASSIFIERS)) {
						while (eventReader.hasNext()) {
							event = eventReader.nextEvent();
							if (event.isStartElement()) {
								startElement = event.asStartElement();
								if (startElement.getName().getLocalPart() == (CLASSIFIER)) {
									classifierConfig = new ClassifierConfig();
									continue;
								}

								if (startElement.getName().getLocalPart().equals(NAME)) {
									event = eventReader.nextEvent();
									classifierConfig.setName(event.asCharacters().getData());
									continue;
								}
								if (startElement.getName().getLocalPart().equals(ENABLED)) {
									event = eventReader.nextEvent();
									classifierConfig.setEnabled(Boolean.parseBoolean(event.asCharacters().getData()));
									continue;
								}
							}

							if (event.isEndElement()) {
								EndElement endElement = event.asEndElement();
								if (endElement.getName().getLocalPart() == (CLASSIFIER)) {
									classifiers.add(classifierConfig);
								}
								if (endElement.getName().getLocalPart() == (CLASSIFIERS)) {
									break;
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		return config;
	}

}
