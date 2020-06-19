package by.artempvn.les03.validator;

import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;

public class CheckType {

	public boolean isCorrectMaterial(String parsedString) {
		boolean isCorrect = false;
		if (parsedString != null) {
			for (Material material : Material.values()) {
				if (material.name().equalsIgnoreCase(parsedString)) {
					isCorrect = true;
				}
			}
		}
		return isCorrect;
	}

	public boolean isCorrectColor(String parsedString) {
		boolean isCorrect = false;
		if (parsedString != null) {
			for (CustomColor color : CustomColor.values()) {
				if (color.name().equalsIgnoreCase(parsedString)) {
					isCorrect = true;
				}
			}
		}
		return isCorrect;
	}
}
