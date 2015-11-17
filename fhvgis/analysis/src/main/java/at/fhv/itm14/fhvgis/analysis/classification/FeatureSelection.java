package at.fhv.itm14.fhvgis.analysis.classification;

import java.util.Random;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GainRatioAttributeEval;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.core.Instances;

public class FeatureSelection {

	/**
	 * uses the meta-classifier
	 */
	public static String useClassifier(Instances data, Classifier base) throws Exception {
		AttributeSelectedClassifier classifier = new AttributeSelectedClassifier();
		CfsSubsetEval eval = new CfsSubsetEval();
		GreedyStepwise search = new GreedyStepwise();
		search.setSearchBackwards(true);
		classifier.setClassifier(base);
		classifier.setEvaluator(eval);
		classifier.setSearch(search);
		Evaluation evaluation = new Evaluation(data);
		evaluation.crossValidateModel(classifier, data, 10, new Random(1));
		return evaluation.toSummaryString();
	}

	public static double[][] rankAttributes(Instances data) throws Exception {
		ASEvaluation eval = new GainRatioAttributeEval();
		ASSearch search = new Ranker();
		AttributeSelection attrSelection = new AttributeSelection();
		attrSelection.setEvaluator(eval);
		attrSelection.setSearch(search);
		attrSelection.SelectAttributes(data);
		return attrSelection.rankedAttributes();
	}

	public static String getRankedAttributesString(double[][] rankedAttributes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rankedAttributes.length; i++) {
			sb.append("Attribute ").append(rankedAttributes[i][0]).append(" Score ").append(rankedAttributes[i][1]);
			sb.append("\n");
		}
		return sb.toString();
	}
}
