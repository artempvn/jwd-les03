package by.artempvn.les03.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.artempvn.les03.validator.CheckType;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;

public class ParserData {
	private static final String PATTERN_DOUBLE = 
			"(?<=\\b)\\d+[\\.,]?\\d*(?=[Dd]?\\b)";
	private static final String DELIMETER = ".";
	private static final String DELIMITER_INCORRECT = ",";
	private static final String PATTERN_WORD = "(?<=\\b)\\w+(?=\\b)";

	public double findDouble(String input) throws CustomException {
		double number = 0;
		if (input != null) {
			String parsedString = "";
			Pattern patternDouble = Pattern.compile(PATTERN_DOUBLE);
			Matcher matcherDouble = patternDouble.matcher(input);
			if (matcherDouble.find()) {
				parsedString = input.substring(matcherDouble.start(),
						matcherDouble.end());
				if (parsedString.contains(DELIMITER_INCORRECT)) {
					parsedString = parsedString.replace(DELIMITER_INCORRECT,
							DELIMETER);
				}
				number = Double.parseDouble(parsedString);
			} else {
				throw new CustomException("Can't find correct double value");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return number;
	}

	public Material findMaterial(String input) throws CustomException {
		Material material = null;
		if (input != null) {
			String parsedString = "";
			CheckType checkType = new CheckType();
			Pattern patternMaterial = Pattern.compile(PATTERN_WORD);
			Matcher matcherMaterial = patternMaterial.matcher(input);
			boolean isMaterial = false;
			while (matcherMaterial.find() && !isMaterial) {
				parsedString = input.substring(matcherMaterial.start(),
						matcherMaterial.end());
				if (checkType.isCorrectMaterial(parsedString)) {
					material = Material.valueOf(parsedString.toUpperCase());
					isMaterial = true;
				}
			}
			if (!isMaterial) {
				throw new CustomException("Can't find correct Color value");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return material;
	}

	public CustomColor findColor(String input) throws CustomException {
		CustomColor color = null;
		if (input != null) {
			String parsedString = "";
			CheckType checkType = new CheckType();
			Pattern patternColor = Pattern.compile(PATTERN_WORD);
			Matcher matcherColor = patternColor.matcher(input);
			boolean isColor = false;
			while (matcherColor.find() && !isColor) {
				parsedString = input.substring(matcherColor.start(),
						matcherColor.end());
				if (checkType.isCorrectColor(parsedString)) {
					color = CustomColor.valueOf(parsedString.toUpperCase());
					isColor = true;
				}
			}
			if (!isColor) {
				throw new CustomException("Can't find correct Color value");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return color;
	}
}
