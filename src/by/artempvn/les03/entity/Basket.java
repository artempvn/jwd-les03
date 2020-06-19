package by.artempvn.les03.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.validator.CheckBasket;

public class Basket {
	private final double volumeCapacity;
	private final double weightCapacity;
	private final ArrayList<Ball> balls = new ArrayList<Ball>();

	public Basket(double volumeCapacity, double weightCapacity) {
		this.volumeCapacity = volumeCapacity;
		this.weightCapacity = weightCapacity;
	}

	public double getVolumeCapacity() {
		return volumeCapacity;
	}

	public double getWeightCapacity() {
		return weightCapacity;
	}

	public List<Ball> getBallsReadOnly() {
		return (Collections.unmodifiableList(balls));
	}

	public boolean addBall(Ball ball) throws CustomException {
		boolean wasAdded = false;
		if (ball != null) {
			CheckBasket checkBasket = new CheckBasket();
			wasAdded = false;
			if (checkBasket.hasEnoughSpace(ball, this)) {
				balls.add(ball);
				wasAdded = true;
			}
		}
		return wasAdded;
	}

	public boolean removeBall(Ball ball) {
		boolean isRemoved = false;
		if (ball != null) {
			if (balls.contains(ball)) {
				balls.remove(ball);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balls == null) ? 0 : balls.hashCode());
		long temp;
		temp = Double.doubleToLongBits(volumeCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weightCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (balls == null) {
			if (other.balls != null)
				return false;
		} else if (!balls.equals(other.balls))
			return false;
		if (Double.doubleToLongBits(volumeCapacity) != Double
				.doubleToLongBits(other.volumeCapacity))
			return false;
		if (Double.doubleToLongBits(weightCapacity) != Double
				.doubleToLongBits(other.weightCapacity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Basket [volumeCapacity=");
		builder.append(volumeCapacity);
		builder.append(", weightCapacity=");
		builder.append(weightCapacity);
		builder.append(", balls=");
		builder.append(balls);
		builder.append("]");
		return builder.toString();
	}
}
