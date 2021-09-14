package utils;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.log4testng.Logger;
import java.util.List;

public class GetInputs {
	static String audioassert,videoassert = null;
	private final static Logger LOGGER = Logger.getLogger(GetInputs.class);
	
	public int stringToInt(String value) {
		int number = Integer.parseInt(value);
		return number;
	}
	
	public static ArrayList<String> splitData(String userinput) {
		
		String[] result = null;
		if(userinput != null) {
		    result = userinput.split("\\.");	
		}
		//System.out.println(result[0]);
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < result[0].length(); i++) {
		    int j = Character.digit(result[0].charAt(i), 10);
		    String number = String.valueOf(j);
		    list.add(number);
		   // System.out.println("digit: " + number);
		}
		return list;
	}

	
	public static void assertKeyValue(HashMap<String, String> actualMap, String key, String expectedvalue) {
		
		for (String name: actualMap.keySet()) {
		    String key1 = name.toString();
		    String value = actualMap.get(name).toString();
		    System.out.println(key1 + " " + value);
		}
		
		String actualvalue = actualMap.get(key);
		System.out.println(actualvalue+ " key is: "+ key);
		assertEquals(actualvalue, expectedvalue);
	}
	/*
	public static void main(String[] args) throws Exception {
		splitData("5000.0");
    }*/
	
}
