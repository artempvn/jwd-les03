package by.artempvn.les03.validator;

import by.artempvn.les03.entity.Color;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;

public class CheckType {

	public boolean isCorrectMaterial(String parsedString)
			throws CustomException {
		if (parsedString == null) {
			throw new CustomException("Incorrect input (null)");
		}
		boolean isCorrect = false;
		for (Material material : Material.values()) {
			if (material.name().equalsIgnoreCase(parsedString)) {
				isCorrect = true;
			}
		}
		return isCorrect;
	}

	public boolean isCorrectColor(String parsedString) throws CustomException {
		if (parsedString == null) {
			throw new CustomException("Incorrect input (null)");
		}
		boolean isCorrect = false;
		for (Color color : Color.values()) {
			if (color.name().equalsIgnoreCase(parsedString)) {
				isCorrect = true;
			}
		}
		return isCorrect;
	}
}
