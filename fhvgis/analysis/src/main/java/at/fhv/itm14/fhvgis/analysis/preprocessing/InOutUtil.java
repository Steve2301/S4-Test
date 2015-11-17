package at.fhv.itm14.fhvgis.analysis.preprocessing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class InOutUtil {

	private static InOutUtil instance;

	public static InOutUtil getInstance() {
		if (instance == null) {
			instance = new InOutUtil();
		}
		return instance;
	}

	private InOutUtil() {
	}

	/**
	 * Loads an .arff file from given path and sets the classIndex of the
	 * returned instances-data by default to (data.numAttributes() - 1)
	 * 
	 * @param path
	 *            location of .arff file
	 * @return data: the .arff file as an {@link Instances} object
	 * @throws Exception
	 */
	public Instances loadArff(String path) throws Exception {
		DataSource source = new DataSource(path);
		Instances data = source.getDataSet();
		// setting class attribute if the data format does not provide it
		// e.g. the XRFF format saves the class attribute information as well
		if (data.classIndex() == -1) {
			data.setClassIndex(data.numAttributes() - 1);
		}
		return data;
	}

	public void saveArff(Instances data, String path) throws IOException {
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(path));
		saver.writeBatch();
	}
	
	public void saveToFile(String data, String path) throws IOException {
		Files.write(Paths.get(path), data.getBytes());
	}
	
	public void appendToFile(String data, String path) throws IOException {
		Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
	}
}
