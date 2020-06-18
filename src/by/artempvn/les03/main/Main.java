package by.artempvn.les03.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.artempvn.les03.action.BasketAction;
import by.artempvn.les03.creator.BallCreator;
import by.artempvn.les03.creator.BasketCreator;
import by.artempvn.les03.entity.Ball;
import by.artempvn.les03.entity.Basket;
import by.artempvn.les03.entity.Color;
import by.artempvn.les03.exception.CustomException;
import by.artempvn.les03.parser.ParserData;
import by.artempvn.les03.reader.DataReader;
import by.artempvn.les03.service.ServiceBall;
import by.artempvn.les03.service.ServiceBasket;
import by.artempvn.les03.validator.CheckType;

public class Main {
	public static void main (String...args) throws CustomException  {
		DataReader dr= new DataReader();
		ServiceBall sc=new ServiceBall();
		sc.calculateVolume(null);

	
	}

}
