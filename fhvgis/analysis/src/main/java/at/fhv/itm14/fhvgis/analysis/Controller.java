package at.fhv.itm14.fhvgis.analysis;

import java.util.List;

import at.fhv.itm14.fhvgis.analysis.classification.Classification;
import at.fhv.itm14.fhvgis.analysis.classification.Training;
import at.fhv.itm14.fhvgis.analysis.config.Config;
import at.fhv.itm14.fhvgis.analysis.config.StaxParser;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVector;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVectorDefinition;
import weka.classifiers.Classifier;
import weka.core.Instances;

public class Controller {

	private Config config;

	private FeatureVectorDefinition featureVectorDefinition;
	private Instances trainingSet;
	private Instances testSet;

	private Classification classification;
	private Training training;

	public Controller() throws Exception {
		config = new StaxParser().readConfig(Config.PATH + "Config.xml");
		featureVectorDefinition = new FeatureVectorDefinition(this);
		classification = new Classification(this);
		training = new Training(this);
	}

	public FeatureVectorDefinition getFeatureVectorDefinition() {
		return featureVectorDefinition;
	}

	public Instances getTrainingSet() {
		return trainingSet;
	}

	public void setTrainingSet(Instances trainingSet) {
		this.trainingSet = trainingSet;
	}

	public void setTrainingSet(String pathToTrain) throws Exception {
		this.trainingSet = this.training.createTrainingData(pathToTrain);
	}

	public void setTrainingSet(List<FeatureVector> featureVectors) throws Exception {
		this.training.createTrainingData(featureVectors);
	}

	public Instances getTestSet() {
		return testSet;
	}

	public void setTestSet(Instances testSet) {
		this.testSet = testSet;
	}

	public Classifier[] getClassifiers() {
		return classification.getClassifiers();
	}

	public Config getConfig() {
		return config;
	}

	public Classification getClassification() {
		return classification;
	}

	public Training getTraining() {
		return training;
	}
}
