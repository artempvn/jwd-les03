package test.artempvn.les03.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.service.ServiceBall;

public class ServiceBallTest {
	ServiceBall serviceBall;
	Ball ballTest;

	@BeforeClass
	public void setUp() {
		serviceBall = new ServiceBall();
		ballTest = new Ball(10., CustomColor.BLACK, Material.STEEL);
	}

	@Test
	public void calculateVolumeTestPositive() {
		double actual = 0;
		try {
			actual = serviceBall.calculateVolume(ballTest);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 4_188.7902;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateVolumeTestNegative() throws CustomException {
		serviceBall.calculateVolume(null);
	}

	@Test
	public void calculateWeightTestPositive() {
		double actual = 0;
		try {
			actual = serviceBall.calculateWeight(ballTest);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		double expected = 32_672.5636;
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@Test(expectedExceptions = CustomException.class)
	public void calculateWeightTestNegative() throws CustomException {
		serviceBall.calculateWeight(null);
	}

	@AfterClass
	public void tierDown() {
		serviceBall = null;
		ballTest = null;
	}
}
