package at.fhv.itm14.fhvgis.analysis.classification;

import java.util.List;

import at.fhv.itm14.fhvgis.analysis.Controller;
import at.fhv.itm14.fhvgis.analysis.config.Config;
import at.fhv.itm14.fhvgis.analysis.config.model.FeatureConfig;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVector;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVectorDefinition;
import at.fhv.itm14.fhvgis.analysis.preprocessing.InOutUtil;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class Training {

	private Instances trainingSet;
	private Controller controller;

	public Training(Controller controller) {
		this.controller = controller;
	}

	public Instances createTrainingData(String pathToTrain) throws Exception {
		/**
		 * create training data within an .arff structure...implement disabling
		 * of parameter (e.g. do not use acceleration)
		 */
		trainingSet = InOutUtil.getInstance().loadArff(pathToTrain);
		controller.setTrainingSet(trainingSet);
		return trainingSet;
	}

	public Instances createTrainingData(List<FeatureVector> featureVectors) throws Exception {
		trainingSet = new Instances("SampleTrainData",
				controller.getFeatureVectorDefinition().getFeatureVectorDefinition(), 0);

		double[] vals;
		int i;
		for (FeatureVector fVector : featureVectors) {
			if (Config.getInstance().isModeEnabled(fVector.getTransportationMode())) {
				i = 0;
				vals = new double[trainingSet.numAttributes()];
				if (Config.getInstance().isFeatureEnabled(FeatureVectorDefinition.AVG_SPEED)) {
					vals[i] = fVector.getAvgSpeed();
					i++;
				}
				if (Config.getInstance().isFeatureEnabled(FeatureVectorDefinition.AVG_ACC)) {
					vals[i] = fVector.getAvgAcc();
					i++;
				}
				if (Config.getInstance().isFeatureEnabled(FeatureVectorDefinition.MAX_SPEED)) {
					vals[i] = fVector.getMaxSpeed();
					i++;
				}
				if (Config.getInstance().isFeatureEnabled(FeatureVectorDefinition.MIN_SPEED)) {
					vals[i] = fVector.getMinSpeed();
					i++;
				}
				vals[i] = controller.getFeatureVectorDefinition().getModes().indexOf(fVector.getTransportationMode());
				trainingSet.add(new Instance(1.0, vals));
			}
		}
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		controller.setTrainingSet(trainingSet);
		return trainingSet;
	}

	public Instances createTrainingDataWithFilter(List<FeatureVector> featureVectors) throws Exception {
		trainingSet = new Instances("SampleTrainData",
				controller.getFeatureVectorDefinition().getFullFeatureVectorDefinition(), 0);

		double[] vals;
		int i;
		for (FeatureVector fVector : featureVectors) {
			if (Config.getInstance().isModeEnabled(fVector.getTransportationMode())) {
				i = 0;
				vals = new double[trainingSet.numAttributes()];
				vals[i++] = fVector.getAvgSpeed();
				vals[i++] = fVector.getAvgAcc();
				vals[i++] = fVector.getMaxSpeed();
				vals[i++] = fVector.getMinSpeed();
				vals[i] = controller.getFeatureVectorDefinition().getModes().indexOf(fVector.getTransportationMode());
				trainingSet.add(new Instance(1.0, vals));
			}
		}
		
		StringBuilder removeParameter = new StringBuilder();
		for (FeatureConfig f : Config.getInstance().getFeatureConfigs()) {
			if (!f.isEnabled()) {
				if (removeParameter.length() > 0) {
					removeParameter.append(", ");
				}
				removeParameter.append(f.getIndex());
			}
		}
		String[] opts = new String[] {"-R", removeParameter.toString()};
		Remove removeFilter = new Remove();
		removeFilter.setOptions(opts);
		removeFilter.setInputFormat(trainingSet);
		trainingSet = Filter.useFilter(trainingSet, removeFilter);
		
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		controller.setTrainingSet(trainingSet);
		return trainingSet;
	}

	/**
	 * Example train and test ...
	 */
	public String trainAndTest(String pathToTrain, String pathToTest) throws Exception {
		Instances train = InOutUtil.getInstance().loadArff(pathToTrain);
		Instances test = InOutUtil.getInstance().loadArff(pathToTest);
		// train classifier
		Classifier cls = new RandomForest();
		cls.buildClassifier(train);
		// evaluate classifier and print some statistics
		Evaluation eval = new Evaluation(train);
		eval.evaluateModel(cls, test);
		return eval.toSummaryString("\nResults\n======\n", false);
	}
}
