package by.artempvn.les03.creator;

import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.parser.ParserData;
import by.artempvn.les03.validator.CheckBasket;

public class BasketCreator {
	private static final String BASKET_REGEX =
			"\\d+[,\\.]?\\d*\\s+\\d+[,\\.]?\\d*";
	private static final String SPLIT_REGEX = "\\s+";

	public Basket create(String data) throws CustomException {
		Basket basket;
		if (data != null) {
			if (data.matches(BASKET_REGEX)) {
				String[] parsedData = data.split(SPLIT_REGEX);
				ParserData parser = new ParserData();
				double volumeCapacity = parser.findDouble(parsedData[0]);
				double weightCapacity = parser.findDouble(parsedData[1]);
				CheckBasket checkBasket = new CheckBasket();
				if (checkBasket.isCorrectVolumeCapacity(volumeCapacity)
						&& checkBasket
								.isCorrectWeightCapacity(weightCapacity)) {
					basket = new Basket(volumeCapacity, weightCapacity);
				} else {
					throw new CustomException("Incorrect data value");
				}
			} else {
				throw new CustomException("Incorrect data string");
			}
		} else {
			throw new CustomException("Incorrect input (null)");
		}
		return basket;
	}
}
