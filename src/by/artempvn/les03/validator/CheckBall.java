package by.artempvn.les03.validator;

public class CheckBall {
	private static final double RADIUS_MIN = 5.;
	private static final double RADIUS_MAX = 20.;

	public boolean isCorrectRadius(double radiusCentimeters) {
		return (radiusCentimeters >= RADIUS_MIN
				&& radiusCentimeters <= RADIUS_MAX);
	}
}
