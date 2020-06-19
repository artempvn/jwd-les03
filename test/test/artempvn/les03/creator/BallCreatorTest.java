package test.artempvn.les03.creator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.creator.BallCreator;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;

public class BallCreatorTest {
	BallCreator ballCreator;

	@BeforeClass
	public void setUp() {
		ballCreator = new BallCreator();
	}

	@Test
	public void createTestPositive() {
		Ball actual = null;
		String data = "5.5 steel black";
		try {
			actual = ballCreator.create(data);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		Ball expected = new Ball(5.5, CustomColor.BLACK, Material.STEEL);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "createTestNegative",
			expectedExceptions = CustomException.class)
	public void createTestNegative(String data) throws CustomException {
		ballCreator.create(data);
	}

	@DataProvider
	public Object[][] createTestNegative() {
		return new Object[][] { { "3. steel red" }, { "3. 5. red" }, { null } };
	}

	@AfterClass
	public void tierDown() {
		ballCreator = null;
	}
}
