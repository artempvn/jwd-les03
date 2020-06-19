package test.artempvn.les03.action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.action.BasketAction;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;

public class BasketActionTest {
	BasketAction basketAction;
	List<Ball> ballsTest;
	Basket basketTest;

	@BeforeClass
	public void setUp() {
		basketAction = new BasketAction();
		basketTest = new Basket(108000, 3000);
		ballsTest = Arrays.asList(new Ball(5., CustomColor.RED, Material.WOOD),
				new Ball(5, CustomColor.BLACK, Material.STEEL), null);
	}

	@Test
	public void createBallsTestPositive() {
		List<Ball> actual = null;
		List<String> inputData = Arrays.asList("20 steel red", "20 steel black",
				" there is no ball data");
		try {
			actual = basketAction.createBalls(inputData);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		List<Ball> expected = Arrays.asList(
				new Ball(20, CustomColor.RED, Material.STEEL),
				new Ball(20, CustomColor.BLACK, Material.STEEL));
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "createBallsTestNegative", 
			expectedExceptions = CustomException.class)
	public void createBallsTestNegative(List<String> inputData)
			throws CustomException {
		basketAction.createBalls(inputData);
	}

	@DataProvider
	public Object[][] createBallsTestNegative() {
		return new Object[][] { { Arrays.asList(" there is no ball data") },
				{ null } };
	}

	@Test
	public void createBasketTestPositive() {
		Basket actual = null;
		List<String> inputData = Arrays.asList("20 steel red", "108000 3000",
				" there is no basket data");
		try {
			actual = basketAction.createBasket(inputData);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		Basket expected = new Basket(108000, 3000);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "createBasketTestNegative",
			expectedExceptions = CustomException.class)
	public void createBasketTestNegative(List<String> inputData)
			throws CustomException {
		basketAction.createBasket(inputData);
	}

	@DataProvider
	public Object[][] createBasketTestNegative() {
		return new Object[][] { { Arrays.asList(" there is no Basket data") },
				{ null } };
	}

	@Test
	public void putBallsIntoBasketTestPositive() {
		int actual = 0;
		try {
			actual = basketAction.putBallsIntoBasket(ballsTest, basketTest);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		int expected = 1;
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "putBallsIntoBasketTestNegative",
			expectedExceptions = CustomException.class)
	public void putBallsIntoBasketTestNegative(List<Ball> balls, Basket basket)
			throws CustomException {
		basketAction.putBallsIntoBasket(balls, basket);
	}

	@DataProvider
	public Object[][] putBallsIntoBasketTestNegative() {
		return new Object[][] {
				{ Arrays.asList(" there is no Basket data"), null },
				{ null, basketTest } };
	}

	@AfterClass
	public void tierDown() {
		basketAction = null;
		ballsTest = null;
		basketTest = null;
	}
}
