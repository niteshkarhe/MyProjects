package jsonFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;

public class GetJsonData 
{
	private static JsonFile data;
	static JSONParser parser = new JSONParser();
	public static Map<String, Object> clientRespData;
	public static Map<String, Object> customerRespData;
	
	private static void changeClassName()
	{
		String folder_path = 
	               "D:\\NK\\Eclipse Programs\\Json\\To\\src\\main\\java\\jsonFile"; 
	  
	        // creating new folder 
	        File myfolder = new File(folder_path); 
	  
	        File[] file_array = myfolder.listFiles(); 
	        File myfile = new File(folder_path+ "\\Nationality_.java");
	        myfile.renameTo(new File(folder_path+"\\"+"Nationality_Customer.java"));
	}
	
	private static JsonFile getJsonFileObject()
	{
		try(BufferedReader  reader = new BufferedReader (new FileReader("jsonFile.json")))
        {
        	data = new Gson().fromJson(reader, JsonFile.class);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return data;
	}
	
	public Map<String, Object> getClientsResponseMap()
	{
		try
		{
			clientRespData = new HashMap<String, Object>();
			JsonFile jsonRespObj = getJsonFileObject();	

			for(Client  c : jsonRespObj.getClients())
			{
				clientRespData.put("id", c.getId());
				clientRespData.put("isActive", c.getIsActive());
				clientRespData.put("age", c.getAge());
				clientRespData.put("gender", c.getGender());
				clientRespData.put("name", c.getName());
				if(c.getNationality() instanceof List )
				{
					for(Nationality n : c.getNationality())
		    		{
						clientRespData.put("First", n.getFirst());
						clientRespData.put("Second", n.getSecond());
		    		}
				}
				else if(c.getPhone() instanceof Phone)
				{
					clientRespData.put("First", new Phone().getMobile());
					clientRespData.put("Second", new Phone().getTele());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return clientRespData;
	}
	
	public Map<String, Object> getCustomerResponseMap()
	{
		customerRespData = new HashMap<String, Object>();
		JsonFile jsonRespObj = getJsonFileObject();
		for(Customer c : jsonRespObj.getCustomer())
		{
			customerRespData.put("id", c.getId());
			customerRespData.put("isActive", c.getIsActive());
			customerRespData.put("age", c.getAge());
			customerRespData.put("gender", c.getGender());
			customerRespData.put("name", c.getName());
			
			if(c.getNationality() instanceof List )
			{
				for(Nationality_ n : c.getNationality())
	    		{
					customerRespData.put("First", n.getFirst());
					customerRespData.put("Second", n.getSecond());
	    		}
			}
		}
		return customerRespData;
	}
	
	public static void main(String[] args) 
	{
		/*clientRespData = new GetJsonData().getClientsResponseMap();
		customerRespData = new GetJsonData().getCustomerResponseMap();
		
		System.out.println("Client Response Data*****");
        clientRespData.entrySet().forEach(entry -> System.out.println(entry));
        
        System.out.println("Customer Response Data*****");
        customerRespData.entrySet().forEach(entry -> System.out.println(entry));*/
		
	}
}

