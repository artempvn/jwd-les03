package test.artempvn.les03.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.entity.CustomColor;
import by.artempvn.les03.entity.Material;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.parser.ParserData;

public class ParserDataTest {

	ParserData parserData;

	@BeforeClass
	public void setUp() {
		parserData = new ParserData();
	}

	@Test(dataProvider = "findDouble")
	public void findDoubleTestPositive(String input, double expected) {
		double actual = 0;
		try {
			actual = parserData.findDouble(input);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, 0.001, " Test failed as...");
	}

	@DataProvider
	public Object[][] findDouble() {
		return new Object[][] { { " 15.3 ", 15.3 }, { " 15,3 ", 15.3 },
				{ "15D", 15. }, };
	}

	@Test(dataProvider = "findDoubleTestNegative", 
			expectedExceptions = CustomException.class)
	public void findDoubleTestNegative(String input) throws CustomException {
		parserData.findDouble(input);
	}

	@DataProvider
	public Object[][] findDoubleTestNegative() {
		return new Object[][] { { "12L" }, { null } };
	}

	@Test(dataProvider = "findMaterial")
	public void findMaterialTestPositive(String input, Material expected) {
		Material actual = null;
		try {
			actual = parserData.findMaterial(input);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findMaterial() {
		return new Object[][] { { " steel  ", Material.STEEL },
				{ " 123 wood ", Material.WOOD },
				{ "steel wood", Material.STEEL } };
	}

	@Test(dataProvider = "findMaterialTestNegative",
			expectedExceptions = CustomException.class)
	public void findMaterialTestNegative(String input) throws CustomException {
		parserData.findMaterial(input);
	}

	@DataProvider
	public Object[][] findMaterialTestNegative() {
		return new Object[][] { { "just some words " }, { null } };
	}

	@Test(dataProvider = "findColor")
	public void findColorTestPositive(String input, CustomColor expected) {
		CustomColor actual = null;
		try {
			actual = parserData.findColor(input);
		} catch (CustomException e) {
			fail("exception occurred");
		}
		assertEquals(actual, expected, " Test failed as...");
	}

	@DataProvider
	public Object[][] findColor() {
		return new Object[][] { { "steel green red ", CustomColor.GREEN },
				{ " 123 red ", CustomColor.RED } };
	}

	@Test(dataProvider = "findColorTestNegative",
			expectedExceptions = CustomException.class)
	public void findColorTestNegative(String input) throws CustomException {
		parserData.findColor(input);
	}

	@DataProvider
	public Object[][] findColorTestNegative() {
		return new Object[][] { { "just some words " }, { null } };
	}

	@AfterClass
	public void tierDown() {
		parserData = null;
	}
}
