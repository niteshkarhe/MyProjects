package executeQuery;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.sql.Connection;

public class StoreListOfData 
{
	private static Map<String, List<String>> getTableColMap()
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		try
		{
			InputStream file = new FileInputStream("D:\\NK\\Eclipse Programs\\JDBC\\src\\ColMapping.properties");
			Properties prop = new Properties();
			prop.load(file);
			Enumeration<String> enums = (Enumeration<String>) prop.propertyNames();
			while(enums.hasMoreElements())
			{
				List<String> valueList = new ArrayList<String>();
				String key = enums.nextElement();
				String[] values = prop.getProperty(key).split(",");
				valueList.addAll(Arrays.asList(values));
				map.put(key, valueList);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return map;
	}
	
	private static Map<String, List<String>> getSqlMap()
	{
		String URL = "jdbc:mysql://localhost:3306/qadatabase";
    	String username = "root";
    	String password = "Nit@1992";
    	Connection con=null;
    	Statement stmt = null;
    	ResultSet rs=null;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
    	
		try
		{
			Properties prop = new Properties();
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, username, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select *from Customers where Country='India' and CustomerId=101;");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println(getTableColMap());
			for(int i=1; i<=rsmd.getColumnCount(); i++)
			{
				List<String> valuesList = new ArrayList<String>();
				while(rs.next())
				{
					String key = rsmd.getColumnName(i);
					valuesList.add(rs.getString(i));
					map.put(key, valuesList);
				}
				rs.beforeFirst();
			}
		}
		catch(Exception e)
		{
			
		}
		return map;
	}
	
	private static Map<String, String> getReplaceColMap()
	{
		Set<Entry<String, List<String>>> tableEntries = getTableColMap().entrySet();
		Set<Entry<String, List<String>>> sqlEntries = getSqlMap().entrySet();
		for(Entry<String, List<String>> tableEntry : tableEntries)
		{
			for(Entry<String, List<String>> sqlEntry : sqlEntries)
			{
				if(tableEntry.getValue().size()>1)
				{
					
				}
			}
		}
		return null;
	}
	
	private static Map<String, String> putData(String colType)
	{
		return null;
	}
	
	private static Map<String, String> getResponseMap()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("indiv.Addr", "105 Maroti");
		map.put("indiv.Postal", "444012");
		map.put("nonIndiv.Postal", "417569");
		map.put("nonIndiv.Addr", "Ring Road");
		map.put("indiv.countr", "India");
		map.put("nonIndiv.country", "India");
		map.put("indiv.CustName", "Tom");
		map.put("nonIndiv.CustName", "Bill");
		map.put("indiv.CustId", "101");
		map.put("nonIndiv.CustId", "106");
		map.put("indiv.city", "Pune");
		map.put("nonIndiv.city", "Kochi");
		map.put("nonIndiv.ContactName", "Martin");
		map.put("indiv.ContactName", "Tommy");
		return map;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(getSqlMap());
	}
}
