package test.artempvn.les03.validator;

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
import by.artempvn.les03.validator.CheckBasket;

public class CheckBasketTest {
	CheckBasket checkBasket;
	Basket basketTest;
	Ball ballTest1;
	Ball ballTest2;
	Ball ballTest3;
	Ball ballTest4;
	Ball ballTest5;

	@BeforeClass
	public void setUp() {
		checkBasket = new CheckBasket();
		basketTest = new Basket(108_000, 3_000);
		ballTest1 = new Ball(5., CustomColor.BLUE, Material.WOOD);
		ballTest2 = new Ball(5., CustomColor.RED, Material.WOOD);
		ballTest3 = new Ball(5., CustomColor.BLUE, Material.WOOD);
		ballTest4 = new Ball(10., CustomColor.BLUE, Material.STEEL);
		ballTest5 = new Ball(50., CustomColor.BLUE, Material.WOOD);
		try {
			basketTest.addBall(ballTest1);
			basketTest.addBall(ballTest2);
		} catch (CustomException e) {
			fail("Unexpected error occurred during initialization");
		}
	}

	@Test(dataProvider = "isCorrectWeightCapacity")
	public void isCorrectWeightCapacityTest(double weightCapacity,
			boolean expected) {
		boolean actual = checkBasket.isCorrectWeightCapacity(weightCapacity);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectWeightCapacity() {
		return new Object[][] { { 10_000, true }, { 2_000., false },
				{ 60_000., false } };
	}

	@Test(dataProvider = "isCorrectVolumeCapacity")
	public void isCorrectVolumeCapacityTest(double volumeCapacity,
			boolean expected) {
		boolean actual = checkBasket.isCorrectVolumeCapacity(volumeCapacity);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectVolumeCapacity() {
		return new Object[][] { { 500_000, true }, { 50_000., false },
				{ 5_000_000., false } };
	}

	@Test(dataProvider = "hasEnoughSpaceTestPositive")
	public void hasEnoughSpaceTestPositive(Ball ball, Basket basket,
			boolean expected) {
		boolean actual = false;
		try {
			actual = checkBasket.hasEnoughSpace(ball, basket);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] hasEnoughSpaceTestPositive() {
		return new Object[][] { { ballTest3, basketTest, true },
				{ ballTest4, basketTest, false },
				{ ballTest5, basketTest, false } };
	}

	@Test(dataProvider = "hasEnoughSpaceTestNegative",
			expectedExceptions = CustomException.class)
	public void hasEnoughSpaceTestNegative(Ball ball, Basket basket)
			throws CustomException {
		checkBasket.hasEnoughSpace(ball, basket);
	}

	@DataProvider
	public Object[][] hasEnoughSpaceTestNegative() {
		return new Object[][] { { null, basketTest }, { ballTest4, null } };
	}

	@AfterClass
	public void tierDown() {
		checkBasket = null;
		ballTest1 = null;
		ballTest2 = null;
		ballTest3 = null;
		ballTest4 = null;
		ballTest5 = null;
	}
}
