package at.fhv.itm14.fhvgis.analysis.model;

import java.util.ArrayList;
import java.util.List;

import at.fhv.itm14.fhvgis.analysis.Controller;
import at.fhv.itm14.fhvgis.analysis.config.Config;
import at.fhv.itm14.fhvgis.analysis.config.model.FeatureConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.ModeConfig;
import weka.core.Attribute;
import weka.core.FastVector;

public class FeatureVectorDefinition {

	// all features
	private FastVector fullFeatureVectorDefinition;
	// according to Config.xml
	private FastVector featureVectorDefinition;
	private FastVector modes;
	private Controller controller;
	private Config config;

	public static final String AVG_SPEED = "avgSpeed";
	public static final String AVG_ACC = "avgAcc";
	public static final String MAX_SPEED = "maxSpeed";
	public static final String MIN_SPEED = "minSpeed";
	public static final String MODE = "mode";
	public static final List<String> VALID_FEATURE_NAMES;

	static {
		VALID_FEATURE_NAMES = new ArrayList<>();
		VALID_FEATURE_NAMES.add(AVG_SPEED);
		VALID_FEATURE_NAMES.add(AVG_ACC);
		VALID_FEATURE_NAMES.add(MAX_SPEED);
		VALID_FEATURE_NAMES.add(MIN_SPEED);
	}

	public FeatureVectorDefinition(Controller controller) {
		this.controller = controller;
		init();
	}

	private void init() {
		config = controller.getConfig();

		featureVectorDefinition = new FastVector();
		fullFeatureVectorDefinition = new FastVector();
		for (FeatureConfig f : config.getFeatureConfigs()) {
			fullFeatureVectorDefinition.addElement(new Attribute(f.getName()));
			if (f.isEnabled()) {
				featureVectorDefinition.addElement(new Attribute(f.getName()));
			}
		}
		modes = new FastVector();
		for (ModeConfig m : config.getModeConfigs()) {
			if (m.isEnabled()) {
				modes.addElement(m.getName());
			}
		}
		fullFeatureVectorDefinition.addElement(new Attribute("transportation mode", modes));
		featureVectorDefinition.addElement(new Attribute("transportation mode", modes));
	}

	public FastVector getFeatureVectorDefinition() {
		return featureVectorDefinition;
	}

	public FastVector getFullFeatureVectorDefinition() {
		return fullFeatureVectorDefinition;
	}

	public FastVector getModes() {
		return modes;
	}

}
