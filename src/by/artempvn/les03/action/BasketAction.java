package by.artempvn.les03.action;

import java.util.ArrayList;
import java.util.List;
import by.artempvn.les03.creator.BallCreator;
import by.artempvn.les03.creator.BasketCreator;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.exception.CustomException;

public class BasketAction {

	public List<Ball> createBalls(List<String> inputData)
			throws CustomException {
		List<Ball> balls = new ArrayList<>();
		if (inputData != null) {
			BallCreator ballCreator = new BallCreator();
			for (String input : inputData) {
				try {
					balls.add(ballCreator.create(input));
				} catch (CustomException e) {
					// TODO place for logger, didn't study yet
				}
			}
			if (balls.size() == 0) {
				throw new CustomException("Incorrect data to create any ball");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return balls;
	}

	public Basket createBasket(List<String> inputData) throws CustomException {
		Basket basket = null;
		if (inputData != null) {
			BasketCreator basketCreator = new BasketCreator();
			for (String input : inputData) {
				try {
					basket = basketCreator.create(input);
				} catch (CustomException e) {
					// TODO place for logger, didn't study yet
				}
			}
			if (basket == null) {
				throw new CustomException("Incorrect data to create basket");
			}

		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return basket;
	}

	public int putBallsIntoBasket(List<Ball> balls, Basket basket)
			throws CustomException {
		int addedBalls = 0;
		if (basket != null && balls != null) {
			for (Ball ball : balls) {
				if (ball != null) {
					if (basket.addBall(ball)) {
						addedBalls++;
					}
				}
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return addedBalls;
	}
}
