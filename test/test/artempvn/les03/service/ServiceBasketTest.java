package test.artempvn.les03.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.service.ServiceBasket;

public class ServiceBasketTest {
	ServiceBasket serviceBasket;
	Basket basketTest;
	Ball ballTest1;
	Ball ballTest2;
	Ball ballTest3;
	Ball ballTest4;

	@BeforeClass
	public void setUp() {
		serviceBasket = new ServiceBasket();
		basketTest = new Basket(108_000, 3_000);
		ballTest1 = new Ball(6., CustomColor.BLUE, Material.RUBBER);
		ballTest2 = new Ball(6., CustomColor.RED, Material.RUBBER);
		try {
			basketTest.addBall(ballTest1);
			basketTest.addBall(ballTest2);
		} catch (CustomException e) {
			fail("Unexpected error occurred during initialization");
		}
	}

	@Test
	public void calculateCurrentVolumeNettoTestPositive() {
		double actual = 0;
		try {
			actual = serviceBasket.calculateCurrentVolumeNetto(basketTest);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 1809.5574;

		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateCurrentVolumeNettoTestNegative()
			throws CustomException {
		serviceBasket.calculateCurrentVolumeNetto(null);
	}

	@Test
	public void calculateCurrentWeightTestPositive() {
		double actual = 0;
		try {
			actual = serviceBasket.calculateCurrentWeight(basketTest);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 1628.6016;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateCurrentWeightTestNegative() throws CustomException {
		serviceBasket.calculateCurrentWeight(null);
	}

	@Test
	public void calculateNumberOfBallsByColorTestPositive() {
		int actual = 0;
		try {
			actual = serviceBasket.calculateNumberOfBallsByColor(basketTest,
					CustomColor.BLUE);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 1;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "calculateNumberOfBallsByColorTestNegative", 
			expectedExceptions = CustomException.class)
	public void calculateNumberOfBallsByColorTestNegative(Basket basket,
			CustomColor color) throws CustomException {
		serviceBasket.calculateNumberOfBallsByColor(basket, color);
	}

	@DataProvider
	public Object[][] calculateNumberOfBallsByColorTestNegative() {
		return new Object[][] { { basketTest, null },
				{ null, CustomColor.BLUE } };
	}

	@AfterClass
	public void tierDown() {
		serviceBasket = null;
		basketTest = null;
		ballTest1 = null;
		ballTest2 = null;
	}
}
