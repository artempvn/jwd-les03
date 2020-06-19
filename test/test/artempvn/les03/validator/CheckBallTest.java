package test.artempvn.les03.validator;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.validator.CheckBall;

public class CheckBallTest {
	CheckBall checkBall;

	@BeforeClass
	public void setUp() {
		checkBall = new CheckBall();
	}

	@Test(dataProvider = "isCorrectRadius")
	public void isCorrectRadiusTest(double radiusCentimeters,
			boolean expected) {
		boolean actual = checkBall.isCorrectRadius(radiusCentimeters);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectRadius() {
		return new Object[][] { { 10., true }, { 4., false }, { 21., false } };
	}

	@AfterClass
	public void tierDown() {
		checkBall = null;
	}
}
