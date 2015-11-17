package at.fhv.itm14.fhvgis.analysis.classification;

import weka.classifiers.evaluation.NominalPrediction;
import weka.core.FastVector;
import weka.core.Instances;

public class Validation {

	public static final int TRAINING_POS = 0;
	public static final int TESTING_POS = 1;
	
	public static Instances[][] createCrossValidationSplit(Instances data, int numberOfFolds) {
		Instances[][] split = new Instances[2][numberOfFolds];

		for (int i = 0; i < numberOfFolds; i++) {
			split[TRAINING_POS][i] = data.trainCV(numberOfFolds, i);
			split[TESTING_POS][i] = data.testCV(numberOfFolds, i);
		}

		return split;
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

}
