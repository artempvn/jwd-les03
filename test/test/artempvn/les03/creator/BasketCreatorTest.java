package test.artempvn.les03.creator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.creator.BasketCreator;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.exception.CustomException;

public class BasketCreatorTest {
	BasketCreator basketCreator;

	@BeforeClass
	public void setUp() {
		basketCreator = new BasketCreator();
	}

	@Test
	public void createTestPositive() {
		Basket actual = null;
		String data = "108000 3000";
		try {
			actual = basketCreator.create(data);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		Basket expected = new Basket(108000., 3000.);
		assertEquals(actual, expected, " Test failed as...");
	}

	@Test(dataProvider = "createTestNegative",
			expectedExceptions = CustomException.class)
	public void createTestNegative(String data) throws CustomException {
		basketCreator.create(data);
	}

	@DataProvider
	public Object[][] createTestNegative() {
		return new Object[][] { { "300 6000." }, { "108000 1000." },
				{ "3. 5. red" }, { null } };
	}

	@AfterClass
	public void tierDown() {
		basketCreator = null;
	}
}
