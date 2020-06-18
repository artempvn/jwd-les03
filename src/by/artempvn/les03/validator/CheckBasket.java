package by.artempvn.les03.validator;

import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.service.ServiceBall;
import by.artempvn.les03.service.ServiceBasket;

public class CheckBasket {
	private static final double VOLUME_BRUTTO_RATIO = 0.74;
	private static final double WEIGHT_CAPACITY_MIN = 3_000;
	private static final double WEIGHT_CAPACITY_MAX = 50_000;
	private static final double VOLUME_CAPACITY_MIN = 108_000;
	private static final double VOLUME_CAPACITY_MAX = 1_080_000;

	public boolean isCorrectWeightCapacity(double weightCapacity) {
		return (weightCapacity >= WEIGHT_CAPACITY_MIN
				&& weightCapacity <= WEIGHT_CAPACITY_MAX);
	}

	public boolean isCorrectVolumeCapacity(double volumeCapacity) {
		return (volumeCapacity >= VOLUME_CAPACITY_MIN
				&& volumeCapacity <= VOLUME_CAPACITY_MAX);
	}

	public boolean hasEnoughSpace(Ball ball, Basket basket)
			throws CustomException {
		if (basket == null || ball == null) {
			throw new CustomException("Incorrect input (null)");
		}
		ServiceBasket serviceBasket = new ServiceBasket();
		ServiceBall serviceBall = new ServiceBall();
		boolean hasEnoughSpace = true;
		double currentVolumeBasketNetto = serviceBasket
				.calculateCurrentVolumeNetto(basket) / VOLUME_BRUTTO_RATIO;
		if (basket.getVolumeCapacity() - currentVolumeBasketNetto < serviceBall
				.calculateVolume(ball)
				|| basket.getWeightCapacity()
						- serviceBasket.calculateCurrentWeight(
								basket) < serviceBall.calculateWeight(ball)) {
			hasEnoughSpace = false;
		}
		return hasEnoughSpace;
	}
}
