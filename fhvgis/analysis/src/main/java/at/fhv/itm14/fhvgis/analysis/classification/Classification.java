package at.fhv.itm14.fhvgis.analysis.classification;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import at.fhv.itm14.fhvgis.analysis.Controller;
import at.fhv.itm14.fhvgis.analysis.config.model.ClassifierConfig;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.FastVector;
import weka.core.Instances;

public class Classification {

	private Controller controller;
	private Classifier[] classifiers;

	public Classification(Controller controller) throws NoSuchAlgorithmException {
		this.controller = controller;
		init();
	}

	private void init() throws NoSuchAlgorithmException {
		List<Classifier> cls = new ArrayList<>();
		for (ClassifierConfig c : controller.getConfig().getClassifierConfigs()) {
			if (c.isEnabled()) {
				switch (c.getName()) {
				case "J48":
					cls.add(new J48());
					break;
				case "PART":
					cls.add(new PART());
					break;
				case "DecisionTable":
					cls.add(new DecisionTable());
					break;
				case "DecisionStump":
					cls.add(new DecisionStump());
					break;
				case "RandomForest":
					cls.add(new RandomForest());
					break;
				case "NaiveBayes":
					cls.add(new NaiveBayes());
					break;
				case "BayesNet":
					cls.add(new BayesNet());
					break;
				case "MultilayerPerceptron":
					MultilayerPerceptron mlp = new MultilayerPerceptron();

					// Setting Parameters
					mlp.setLearningRate(0.1);
					mlp.setMomentum(0.2);
					mlp.setTrainingTime(2000);
					// creates a 'nrOfInputs-5-nrOfOutputs' NN
					mlp.setHiddenLayers("5");
					// use it like this: to create a
					// 'nrOfInputs-8-6-4-nrOfOutputs' NN
					// mlp.setHiddenLayers("8, 6, 4");
					cls.add(mlp);
					break;
				default:
					throw new NoSuchAlgorithmException();
				}
			}
		}
		classifiers = new Classifier[cls.size()];
		classifiers = cls.toArray(classifiers);
	}

	private Evaluation classify(Classifier model, Instances trainingSet, Instances testingSet) throws Exception {
		Evaluation evaluation = new Evaluation(trainingSet);

		model.buildClassifier(trainingSet);
		evaluation.evaluateModel(model, testingSet);

		return evaluation;
	}

	public String runCustomCrossValidation(int nrOfFolds) throws Exception {
		Instances data = controller.getTrainingSet();
		Instances[][] split = Validation.createCrossValidationSplit(data, 10);

		// Separate split into training and testing arrays
		Instances[] trainingSplits = split[Validation.TRAINING_POS];
		Instances[] testingSplits = split[Validation.TESTING_POS];

		Classifier[] classifiers = controller.getClassifiers();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < classifiers.length; j++) {

			// Collect every group of predictions for current model in a
			// FastVector
			FastVector predictions = new FastVector();

			// For each training-testing split pair, train and test the
			// classifier
			for (int i = 0; i < trainingSplits.length; i++) {
				Evaluation validation = classify(classifiers[j], trainingSplits[i], testingSplits[i]);

				predictions.appendElements(validation.predictions());

			}

			// Calculate overall accuracy of current classifier on all splits
			double accuracy = Validation.calculateAccuracy(predictions);

			sb.append("Accuracy of " + classifiers[j].getClass().getSimpleName() + ": "
					+ String.format("%.2f%%", accuracy) + "\n---------------------------------\n");
		}
		return sb.toString();
	}

	public String runCrossValidation(int nrOfFolds, boolean useAttributeSelection) throws Exception {
		Instances data = controller.getTrainingSet();
		Classifier[] classifiers = controller.getClassifiers();
		Classifier classifier;
		// attribute selection classifier
		AttributeSelectedClassifier attrSelClassifier = null;

		StringBuilder result = new StringBuilder();
		if (useAttributeSelection) {
			attrSelClassifier = new AttributeSelectedClassifier();
			CfsSubsetEval eval = new CfsSubsetEval();
			GreedyStepwise search = new GreedyStepwise();
			search.setSearchBackwards(true);
			attrSelClassifier.setEvaluator(eval);
			attrSelClassifier.setSearch(search);
		}
		for (int j = 0; j < classifiers.length; j++) {
			if (useAttributeSelection && attrSelClassifier != null) {
				attrSelClassifier.setClassifier(classifiers[j]);
				classifier = attrSelClassifier;
			} else {
				classifier = classifiers[j];
			}

			classifier.buildClassifier(data);

			Evaluation eval = new Evaluation(data);
			eval.crossValidateModel(classifier, data, nrOfFolds, new Random(1));
			String classifierResult = eval.toSummaryString("Classifier: " + classifiers[j].getClass().getSimpleName(),
					true);

			result.append("Date ").append(new Date().toString()).append("\n");
			result.append(classifierResult);
			result.append("\n-------------------------------\n\n");
		}
		return result.toString();
	}

	public Classifier[] getClassifiers() {
		return classifiers;
	}
}
