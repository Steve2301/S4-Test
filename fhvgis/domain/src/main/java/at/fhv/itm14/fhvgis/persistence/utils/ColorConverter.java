package at.fhv.itm14.fhvgis.persistence.utils;

import java.awt.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

	private static final String SEPARATOR = "|";

	@Override
	public String convertToDatabaseColumn(Color color) {
		StringBuilder builder = new StringBuilder();
		builder.append(color.getRed()).append(SEPARATOR).append(color.getGreen()).append(SEPARATOR)
				.append(color.getBlue()).append(SEPARATOR).append(color.getAlpha());

		return builder.toString();
	}

	@Override
	public Color convertToEntityAttribute(String dbData) {
		String[] rgb = dbData.split("\\|");
		return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]),
				Integer.parseInt(rgb[3]));
	}

}
