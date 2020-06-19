package test.artempvn.les03.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;

public class BasketTest {
	Basket basketTest;
	Ball ballTest1;
	Ball ballTest2;

	@BeforeClass
	public void setUp() {
		ballTest1 = new Ball(5., CustomColor.BLUE, Material.WOOD);
		ballTest2 = new Ball(100., CustomColor.RED, Material.STEEL);
	}

	@BeforeMethod
	public void BeforeMethod() {
		basketTest = new Basket(108_000, 3_000);
	}

	@Test(dataProvider = "addBall")
	public void addBallTest(Ball ball, boolean expected) {
		boolean actual = false;
		try {
			actual = basketTest.addBall(ball);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] addBall() {
		return new Object[][] { { ballTest1, true }, { ballTest2, false },
				{ null, false } };
	}

	@Test(dataProvider = "removeBall", dependsOnMethods = "addBallTest")
	public void removeBallTest(Ball ball, boolean expected) {
		try {
			basketTest.addBall(ballTest1);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		boolean actual = basketTest.removeBall(ball);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] removeBall() {
		return new Object[][] { { ballTest1, true }, { ballTest2, false },
				{ null, false } };
	}

	@AfterMethod
	public void afterMethod() {
		basketTest = null;
	}

	@AfterClass
	public void tierDown() {
		ballTest1 = null;
		ballTest2 = null;
	}
}
