package test.artempvn.les03.reader;

import static org.testng.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.artempvn.les03.reader.DataReader;

public class DataReaderTest {
	DataReader reader;
	String path = "inpot/asddsa.txt";

	@BeforeClass
	public void setUp() {
		reader = new DataReader();
	}

	@Test(dataProvider = "readFileTest")
	public void readFileTest(String path) {
		List<String> actual = reader.readFile(path);
		List<String> expected = Arrays.asList("20 steel red", "20 steel black",
				"5.5 wood blue", "20 steel red", "20 steel black",
				"20 steel red", "5.5 wood black", "5.5 blue wood",
				"1080000 3000");
		assertTrue(actual.equals(expected), " Test failed as...");
	}

	@DataProvider
	public Object[][] readFileTest() {
		return new Object[][] { { "input/data.txt" },
				{ "input/incorrectDataFile.txt" }, { null } };
	}

	@AfterClass
	public void tierDown() {
		reader = null;
	}
}
