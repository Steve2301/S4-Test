package weka.demo.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

import at.fhv.itm14.fhvgis.analysis.config.Config;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("\n+++++++++\n Test one \n+++++++++\n");
		Main.test();
		System.out.println("\n+++++++++\n Test two \n+++++++++\n");
		Main.testArff();
		System.out.println("\n+++++++++\n Test three \n+++++++++\n");
		Main.testWeather();
	}

	/**
	 * https://weka.wikispaces.com/Programmatic+Use
	 * 
	 * @throws Exception
	 */
	public static void test() throws Exception {
		// feature 1
		Attribute Attribute1 = new Attribute("firstNumeric");
		// feature 2
		Attribute Attribute2 = new Attribute("secondNumeric");

		// feature 3
		// Declare a nominal attribute along with its values
		FastVector fvNominalVal = new FastVector(3);
		fvNominalVal.addElement("blue");
		fvNominalVal.addElement("gray");
		fvNominalVal.addElement("black");
		Attribute Attribute3 = new Attribute("aNominal", fvNominalVal);

		// class: result of classification
		// Declare the class attribute along with its values
		FastVector fvClassVal = new FastVector(2);
		fvClassVal.addElement("positive");
		fvClassVal.addElement("negative");
		Attribute ClassAttribute = new Attribute("theClass", fvClassVal);

		// feature vector with all features and the class
		// Declare the feature vector
		FastVector fvWekaAttributes = new FastVector(4);
		fvWekaAttributes.addElement(Attribute1);
		fvWekaAttributes.addElement(Attribute2);
		fvWekaAttributes.addElement(Attribute3);
		fvWekaAttributes.addElement(ClassAttribute);

		// Create an empty training set
		// Rel is the name of the training set
		// set classIndex maps the ClassAttribute (result=positive or negative)
		// of the feature vector, i.e. FastVector has an order
		Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);
		// Set class index
		isTrainingSet.setClassIndex(3);

		// Create the instance
		Instance iExample = new Instance(4);
		iExample.setValue((Attribute) fvWekaAttributes.elementAt(0), 1.0);
		iExample.setValue((Attribute) fvWekaAttributes.elementAt(1), 0.5);
		iExample.setValue((Attribute) fvWekaAttributes.elementAt(2), "gray");
		iExample.setValue((Attribute) fvWekaAttributes.elementAt(3), "positive");

		// add the instance
		isTrainingSet.add(iExample);

		// Create a naïve bayes classifier
		Classifier cModel = (Classifier) new NaiveBayes();
		cModel.buildClassifier(isTrainingSet);

		Instances isTestingSet = new Instances("Test", fvWekaAttributes, 10);
		// Set class index
		isTestingSet.setClassIndex(3);
		// Create the instance
		Instance iTestingSample = new Instance(4);
		iTestingSample.setValue((Attribute) fvWekaAttributes.elementAt(0), 1.0);
		iTestingSample.setValue((Attribute) fvWekaAttributes.elementAt(1), 0.5);
		iTestingSample.setValue((Attribute) fvWekaAttributes.elementAt(2), "gray");
		iTestingSample.setValue((Attribute) fvWekaAttributes.elementAt(3), "positive");

		isTestingSet.add(iTestingSample);

		// Test the model
		Evaluation eTest = new Evaluation(isTrainingSet);
		eTest.evaluateModel(cModel, isTestingSet);

		// Print the result à la Weka explorer:
		String strSummary = eTest.toSummaryString();
		System.out.println(strSummary);

		// Get the confusion matrix
		double[][] cmMatrix = eTest.confusionMatrix();
		for (int row_i = 0; row_i < cmMatrix.length; row_i++) {
			for (int col_i = 0; col_i < cmMatrix.length; col_i++) {
				System.out.print(cmMatrix[row_i][col_i]);
				System.out.print("|");
			}
			System.out.println();
		}

		// Specify that the instance belong to the training set
		// in order to inherit from the set description
		iExample.setDataset(isTrainingSet);

		// Get the likelihood of each classes
		// fDistribution[0] is the probability of being “positive”
		// fDistribution[1] is the probability of being “negative”
		double[] fDistribution = cModel.distributionForInstance(iExample);
		System.out.println("the probability of being positive " + fDistribution[0]);
		System.out.println("the probability of being negative " + fDistribution[1]);
	}

	/**
	 * https://weka.wikispaces.com/Creating+an+ARFF+file
	 * 
	 * @throws ParseException
	 */
	public static void testArff() throws ParseException {
		FastVector atts;
		FastVector attsRel;
		FastVector attVals;
		FastVector attValsRel;
		Instances data;
		Instances dataRel;
		double[] vals;
		double[] valsRel;
		int i;

		// 1. set up attributes
		atts = new FastVector();
		// - numeric
		atts.addElement(new Attribute("att1"));
		// - nominal
		attVals = new FastVector();
		for (i = 0; i < 5; i++)
			attVals.addElement("val" + (i + 1));
		atts.addElement(new Attribute("att2", attVals));
		// - string
		atts.addElement(new Attribute("att3", (FastVector) null));
		// - date
		atts.addElement(new Attribute("att4", "yyyy-MM-dd HH:mm:ss"));
		// - relational
		attsRel = new FastVector();
		// -- numeric
		attsRel.addElement(new Attribute("att5.1"));
		// -- nominal
		attValsRel = new FastVector();
		for (i = 0; i < 5; i++)
			attValsRel.addElement("val5." + (i + 1));
		attsRel.addElement(new Attribute("att5.2", attValsRel));
		dataRel = new Instances("att5", attsRel, 0);
		atts.addElement(new Attribute("att5", dataRel, 0));

		// 2. create Instances object
		data = new Instances("MyRelation", atts, 0);

		// 3. fill with data
		// first instance
		vals = new double[data.numAttributes()];
		// - numeric
		vals[0] = Math.PI;
		// - nominal
		vals[1] = attVals.indexOf("val3");
		// - string
		vals[2] = data.attribute(2).addStringValue("This is a string!");
		// - date
		vals[3] = data.attribute(3).parseDate("2001-11-09 12:13:44");
		// - relational
		dataRel = new Instances(data.attribute(4).relation(), 0);
		// -- first instance
		valsRel = new double[2];
		valsRel[0] = Math.PI + 1;
		valsRel[1] = attValsRel.indexOf("val5.3");
		dataRel.add(new Instance(1.0, valsRel));
		// -- second instance
		valsRel = new double[2];
		valsRel[0] = Math.PI + 2;
		valsRel[1] = attValsRel.indexOf("val5.2");
		dataRel.add(new Instance(1.0, valsRel));
		vals[4] = data.attribute(4).addRelation(dataRel);
		// add
		data.add(new Instance(1.0, vals));

		// second instance
		vals = new double[data.numAttributes()]; // important: needs NEW array!
		// - numeric
		vals[0] = Math.E;
		// - nominal
		vals[1] = attVals.indexOf("val1");
		// - string
		vals[2] = data.attribute(2).addStringValue("And another one!");
		// - date
		vals[3] = data.attribute(3).parseDate("2000-12-01 14:01:11");
		// - relational
		dataRel = new Instances(data.attribute(4).relation(), 0);
		// -- first instance
		valsRel = new double[2];
		valsRel[0] = Math.E + 1;
		valsRel[1] = attValsRel.indexOf("val5.4");
		dataRel.add(new Instance(1.0, valsRel));
		// -- second instance
		valsRel = new double[2];
		valsRel[0] = Math.E + 2;
		valsRel[1] = attValsRel.indexOf("val5.1");
		dataRel.add(new Instance(1.0, valsRel));
		vals[4] = data.attribute(4).addRelation(dataRel);
		// add
		data.add(new Instance(1.0, vals));

		// 4. output data
		System.out.println(data);
	}

	/**
	 * http://www.programcreek.com/2013/01/a-simple-machine-learning-example-in-
	 * java/
	 * 
	 * @throws Exception
	 */
	public static void testWeather() throws Exception {
		BufferedReader datafile = readDataFile(Config.PATH + "weather.arff");

		Instances data = new Instances(datafile);
		data.setClassIndex(data.numAttributes() - 1);

		// Do 10-split cross validation
		Instances[][] split = crossValidationSplit(data, 10);

		// Separate split into training and testing arrays
		Instances[] trainingSplits = split[0];
		Instances[] testingSplits = split[1];

		// Use a set of classifiers
		Classifier[] models = { 
				new J48(), // a decision tree
				new PART(), 
				new DecisionTable(), // decision table majority classifier
				new DecisionStump() // one-level decision tree
		};

		// Run for each model
		for (int j = 0; j < models.length; j++) {

			// Collect every group of predictions for current model in a
			// FastVector
			FastVector predictions = new FastVector();

			// For each training-testing split pair, train and test the
			// classifier
			for (int i = 0; i < trainingSplits.length; i++) {
				Evaluation validation = classify(models[j], trainingSplits[i], testingSplits[i]);

				predictions.appendElements(validation.predictions());

				// Uncomment to see the summary for each training-testing pair.
				// System.out.println(models[j].toString());
			}

			// Calculate overall accuracy of current classifier on all splits
			double accuracy = calculateAccuracy(predictions);

			// Print current classifier's name and accuracy in a complicated,
			// but nice-looking way.
			System.out.println("Accuracy of " + models[j].getClass().getSimpleName() + ": "
					+ String.format("%.2f%%", accuracy) + "\n---------------------------------");
		}
	}

	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;

		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}

		return inputReader;
	}

	public static Evaluation classify(Classifier model, Instances trainingSet, Instances testingSet) throws Exception {
		Evaluation evaluation = new Evaluation(trainingSet);

		model.buildClassifier(trainingSet);
		evaluation.evaluateModel(model, testingSet);

		return evaluation;
	}

	public static double calculateAccuracy(FastVector predictions) {
		double correct = 0;

		for (int i = 0; i < predictions.size(); i++) {
			NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
			if (np.predicted() == np.actual()) {
				correct++;
			}
		}

		return 100 * correct / predictions.size();
	}

	public static Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {
		Instances[][] split = new Instances[2][numberOfFolds];

		for (int i = 0; i < numberOfFolds; i++) {
			split[0][i] = data.trainCV(numberOfFolds, i);
			split[1][i] = data.testCV(numberOfFolds, i);
		}

		return split;
	}
}
