package by.artempvn.les03.creator;

import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.parser.ParserData;
import by.artempvn.les03.validator.CheckBall;

public class BallCreator {
	private static final String BALL_REGEX = "\\d+[,\\.]?\\d*\\s+\\D+\\s+\\D+";

	public Ball create(String data) throws CustomException {
		Ball ball;
		if (data != null) {
			if (data.matches(BALL_REGEX)) {
				ParserData parser = new ParserData();
				CustomColor color = parser.findColor(data);
				Material material = parser.findMaterial(data);
				double radius = parser.findDouble(data);
				CheckBall checkBall = new CheckBall();
				if (checkBall.isCorrectRadius(radius)) {
					ball = new Ball(radius, color, material);
				} else {
					throw new CustomException("Incorrect radius value");
				}
			} else {
				throw new CustomException("Incorrect data string");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return ball;
	}
}
