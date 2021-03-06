package by.artempvn.les03.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
	private static final String DEFAULT_PASS = "input/data.txt";

	public List<String> readFile(String path) {
		if (path == null || !Files.isReadable(Paths.get(path))) {
			path = DEFAULT_PASS;
		}
		List<String> strings = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			strings = stream.collect(Collectors.toList());
		} catch (IOException ex) {
			throw new RuntimeException("Fatal error: could't open data file.",
					ex);
		}
		return strings;
	}
}
