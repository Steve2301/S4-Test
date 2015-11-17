package at.fhv.itm14.fhvgis.analysis;

import java.util.ArrayList;
import java.util.List;

import at.fhv.itm14.fhvgis.analysis.classification.FeatureSelection;
import at.fhv.itm14.fhvgis.analysis.config.Config;
import at.fhv.itm14.fhvgis.analysis.model.FeatureVector;
import weka.core.Debug.Random;

public class EvaluationSetup {

	public void evaluateWeather() throws Exception {
		Controller controller = new Controller();
		controller.setTrainingSet(Config.PATH + "weather.arff");
		String result = controller.getClassification().runCustomCrossValidation(10);
		System.out.println(result);
	}

	public void evaluateSampleData() throws Exception {
		List<FeatureVector> samplefVs = new ArrayList<>();

		double avgSpeed;
		double avgAcc;
		double maxSpeed;
		double minSpeed;

		for (int i = 0; i < 200; i++) {
			avgSpeed = new Random().doubles(0.01, 0.02).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.02, 0.06).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(0.01, 0.02).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 0.02).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Stationary"));

			avgSpeed = new Random().doubles(4, 9).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.2, 0.6).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(5, 13).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 1.5).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Walking"));

			avgSpeed = new Random().doubles(13, 25).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.5, 1.2).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(0, 35).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 5).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Bicycle"));

			avgSpeed = new Random().doubles(25, 55).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.5, 3).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(50, 80).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 15).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Bus"));

			avgSpeed = new Random().doubles(55, 130).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.3, 1).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(80, 170).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 30).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Train"));

			avgSpeed = new Random().doubles(35, 105).limit(1).findFirst().getAsDouble();
			avgAcc = new Random().doubles(0.5, 3).limit(1).findFirst().getAsDouble();
			maxSpeed = new Random().doubles(60, 145).limit(1).findFirst().getAsDouble();
			minSpeed = new Random().doubles(0, 25).limit(1).findFirst().getAsDouble();
			samplefVs.add(new FeatureVector(avgSpeed, avgAcc, maxSpeed, minSpeed, "Car"));
		}

		Controller c = new Controller();

		c.setTrainingSet(samplefVs);
		String result = c.getClassification().runCrossValidation(10, false);
		System.out.println(result);
		/*
		InOutUtil.getInstance().saveToFile(result, Config.PATH + "transport_sample_result"
				+ new Date().toString().replace(':', '_').replace(' ', '_') + ".txt");
		*/
		double[][] ranked = FeatureSelection.rankAttributes(c.getTrainingSet());
		System.out.println(FeatureSelection.getRankedAttributesString(ranked));
	}

	public static void main(String[] args) throws Exception {
		System.out.println("\n+++++++++\n Test evaluateWeather \n+++++++++\n");
		new EvaluationSetup().evaluateWeather();
		System.out.println("\n+++++++++\n Test evaluateSampleData \n+++++++++\n");
		new EvaluationSetup().evaluateSampleData();
		System.out.println("\n+++++++++\n Tests FINISHED \n+++++++++\n");
	}
}
