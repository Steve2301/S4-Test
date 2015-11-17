package at.fhv.itm14.fhvgis.analysis.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.fhv.itm14.fhvgis.analysis.config.model.AbstractEnabableConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.ClassifierConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.FeatureConfig;
import at.fhv.itm14.fhvgis.analysis.config.model.ModeConfig;

public class Config {

	private static Config instance;
	public static final String PATH = "./src/main/resources/";

	private List<ClassifierConfig> classifierConfigs;
	private List<ModeConfig> modeConfigs;
	private List<FeatureConfig> featureConfigs;
	private Map<String, Boolean> enabledFeatures;
	private Map<String, Boolean> enabledModes;
	private Map<String, Boolean> enabledClassifiers;

	private Config() {
		enabledFeatures = new HashMap<>();
		enabledModes = new HashMap<>();
		enabledClassifiers = new HashMap<>();
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public boolean isModeEnabled(String mode) {
		return isEnabled(mode, modeConfigs, enabledModes);
	}

	public boolean isFeatureEnabled(String feature) {
		return isEnabled(feature, featureConfigs, enabledFeatures);
	}

	public boolean isClassifierEnabled(String classifier) {
		return isEnabled(classifier, classifierConfigs, enabledClassifiers);
	}

	private boolean isEnabled(String name, List<? extends AbstractEnabableConfig> configs,
			Map<String, Boolean> enabledMap) {
		return enabledMap.get(name) != null ? enabledMap.get(name) : initEnabledMap(name, configs, enabledMap);
	}

	private boolean initEnabledMap(String mode, List<? extends AbstractEnabableConfig> configs,
			Map<String, Boolean> enabledMap) {
		for (AbstractEnabableConfig c : configs) {
			if (c.getName().equals(mode)) {
				enabledMap.put(mode, c.isEnabled());
				return c.isEnabled();
			}
		}
		enabledMap.put(mode, false);
		return false;
	}

	public List<ClassifierConfig> getClassifierConfigs() {
		return new ArrayList<>(classifierConfigs);
	}

	void setClassifierConfigs(List<ClassifierConfig> classifierConfigs) {
		this.classifierConfigs = classifierConfigs;
	}

	public List<ModeConfig> getModeConfigs() {
		return new ArrayList<>(modeConfigs);
	}

	void setModeConfigs(List<ModeConfig> modeConfigs) {
		this.modeConfigs = modeConfigs;
	}

	public List<FeatureConfig> getFeatureConfigs() {
		return new ArrayList<>(featureConfigs);
	}

	void setFeatureConfigs(List<FeatureConfig> featureConfigs) {
		this.featureConfigs = featureConfigs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Features: \n");
		for (FeatureConfig f : featureConfigs) {
			sb.append(f.toString()).append("\n");
		}
		sb.append("Modes: \n");
		for (ModeConfig m : modeConfigs) {
			sb.append(m.toString()).append("\n");
		}
		sb.append("Classifiers: \n");
		for (ClassifierConfig f : classifierConfigs) {
			sb.append(f.toString()).append("\n");
		}
		return sb.toString();
	}

}
