package test.artempvn.les03.validator;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.validator.CheckType;

public class CheckTypeTest {
	CheckType checkType;

	@BeforeClass
	public void setUp() {
		checkType = new CheckType();
	}

	@Test(dataProvider = "isCorrectMaterial")
	public void isCorrectMaterialTest(String parsedString, boolean expected) {
		boolean actual = checkType.isCorrectMaterial(parsedString);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectMaterial() {
		return new Object[][] { { "steel", true }, { "WooD", true },
				{ "red", false }, { null, false } };
	}

	@Test(dataProvider = "isCorrectColor")
	public void isCorrectColorTest(String parsedString, boolean expected) {
		boolean actual = checkType.isCorrectColor(parsedString);
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] isCorrectColor() {
		return new Object[][] { { "red", true }, { "RED", true },
				{ "wood", false }, { null, false } };
	}

	@AfterClass
	public void tierDown() {
		checkType = null;
	}
}
