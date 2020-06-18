package by.artempvn.les03.service;

import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.exception.CustomException;

import static java.lang.Math.*;

public class ServiceBall {

	public double calculateVolume(Ball ball) throws CustomException {
		if (ball == null) {
			throw new CustomException("Incorrect input (null)");
		}
		double volume = (4. / 3. * PI * (pow(ball.getRadiusCentimeters(), 3)));
		return volume;
	}

	public double calculateWeight(Ball ball) throws CustomException {
		if (ball == null) {
			throw new CustomException("Incorrect input (null)");
		}
		double weight = ball.getMaterial().getDensity() * calculateVolume(ball);
		return weight;
	}
}
