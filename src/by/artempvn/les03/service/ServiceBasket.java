package by.artempvn.les03.service;

import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.entity.Color;

public class ServiceBasket {

	public double calculateCurrentVolumeNetto(Basket basket)
			throws CustomException {
		if (basket == null) {
			throw new CustomException("Incorrect input (null)");
		}
		double volumeNetto = 0;
		ServiceBall serviceBall = new ServiceBall();
		for (Ball ball : basket.getBallsReadOnly()) {
			volumeNetto += serviceBall.calculateVolume(ball);
		}
		return volumeNetto;
	}

	public double calculateCurrentWeight(Basket basket) 
			throws CustomException {
		if (basket == null) {
			throw new CustomException("Incorrect input (null)");
		}
		double weight = 0;
		ServiceBall serviceBall = new ServiceBall();
		for (Ball ball : basket.getBallsReadOnly()) {
			weight += serviceBall.calculateWeight(ball);
		}
		return weight;
	}

	public int calculateNumberOfBallsByColor(Basket basket, Color color)
			throws CustomException {
		if (basket == null || color == null) {
			throw new CustomException("Incorrect input (null)");
		}
		int count = 0;
		for (Ball ball : basket.getBallsReadOnly()) {
			if (color == ball.getColor()) {
				count++;
			}
		}
		return count;
	}
}
