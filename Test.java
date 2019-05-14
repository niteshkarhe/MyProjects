package baseClass;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test 
{
	private static JSONArray responseArray;
	private static JSONObject responseElement;
	private static Map<String, String> jsonMap = new HashMap<String, String>();
	private static JSONParser jsonParser = new JSONParser();
	private static void readJson()
	{
		jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("test.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            responseArray = (JSONArray) obj;
            responseElement = (JSONObject) responseArray.get(0);
            System.out.println(responseArray);
            
            Test.checkIfJsonValueIsArray(responseElement);
 
        } 
        catch (IOException | ParseException e) 
        {
            e.printStackTrace();
        }
	}
	
	private static void checkIfJsonValueIsArray(JSONObject JSONObject)
	{
		Set<Entry<String,String>> jsonEntrySet = JSONObject.entrySet();
		for(Entry<String,String> entry : jsonEntrySet)
		{
			System.out.println(entry);
			Object jsonValue = entry.getValue();
			boolean checkForArray = jsonValue instanceof JSONArray;
			if(checkForArray==true)
			{
				Test.getJsnObject((JSONArray)jsonValue);
			}
			
			else
			{
				String key = entry.getKey();
				String value = entry.getValue();
				jsonMap.put(key, value);
			}
		}
	}
	
	private static void getJsnObject(JSONArray jsonValue)
	{
        responseElement = (JSONObject) jsonValue.get(0);
        
        Test.getJsonHashMap(responseElement);
        //To remove values which doesn't contain '['
        Iterator<String> itr = responseElement.keySet().iterator();
		while(itr.hasNext())
		{
			String key = itr.next();
			String value = responseElement.get(key).toString();
			if(value.contains("["))
			{
				itr.remove();
			}
		}
        
		Test.checkIfJsonValueIsArray(responseElement);
       // if(responseElement.)
        //return responseElement;
	}
	
	private static void getJsonHashMap(JSONObject jObject)
	{
		Set<Entry<String, String>> jsonEntrySet = jObject.entrySet();
		for(Entry<String, String> entry : jsonEntrySet)
		{
			String key = entry.getKey();
			String value = entry.getValue();
			if(!value.contains("["))
			{
				jsonMap.put(key, value);
			}
		}
		System.out.println(jsonMap);
	}
	
	public static void main(String[] args) 
	{
		Test.readJson();
		System.out.println(jsonMap);
		/*jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("test.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            responseArray = (JSONArray) obj;
            
            responseElement = (JSONObject) responseArray.get(0);
            System.out.println(responseElement.size());
            System.out.println(responseArray);
            
            //Test.checkIfJsonValueIsArray(responseElement);
 
        } 
        catch (IOException | ParseException e) 
        {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Set<Entry<String, String>> jsonEntrySet = responseElement.entrySet();
		for(Entry<String, String> entry : jsonEntrySet)
		{
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof JSONArray)
			{
				map.put(key, value);
			}
			else
			{
				map.put(key, value);
			}
			
		}
		
		System.out.println(map);*/
	}
}
