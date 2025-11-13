package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LocatorReader {
	
	public JSONObject Locators;
	
	public LocatorReader(String Filepath)
	{
		JSONParser parser = new JSONParser();
		try {
		Locators = 	(JSONObject) parser.parse(new FileReader(Filepath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public String getLocatorType(String key)
	{
		JSONObject Locator = (JSONObject)Locators.get(key);
		return (String) Locator.get("type");
	}
	
	public String getLocatorValue(String key)
	{
		JSONObject Locator = (JSONObject)Locators.get(key);
		return (String) Locator.get("value");
	}
}
