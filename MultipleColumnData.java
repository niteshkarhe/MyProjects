package executeQuery;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.google.common.base.Strings;

public class MultipleColumnData 
{
	static String partyIdType;
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
				if(prop.getProperty(key).contains(","))
				{
					String[] values = prop.getProperty(key).split(",");
					valueList.addAll(Arrays.asList(values));
					map.put(key, valueList);
				}
				else
				{
					String value = prop.getProperty(key);
					valueList.add(value);
					map.put(key, valueList);
				}
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
		String key=null;
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
			String colType = getPartyIdAndType();
			rs = stmt.executeQuery("select *from Customers where Country='India' and CustomerId=101");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//System.out.println(getTableColMap());
			for(int i=1; i<=rsmd.getColumnCount(); i++)
			{
				List<String> valuesList = new ArrayList<String>();
				while(rs.next())
				{
					String dbColName = rsmd.getColumnName(i);
					List<String> columnNames = getReplacedColName(dbColName);
					if(!Strings.isNullOrEmpty(colType))
					{
						if(columnNames.size()>1)
						{
							for(String col : columnNames)
							{
								if(col.contains(colType))
								{
									key=col;
								}
							}
						}
						else
						{
							key=columnNames.get(0);
						}
					}
					else
					{
						key=columnNames.get(0);
					}
					
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
	
	private static List<String> getReplacedColName(String sqlColName)
	{
		List<String> colmnNames = new ArrayList<String>();
		Set<Entry<String, List<String>>> tableEntries = getTableColMap().entrySet();
		for(Entry<String, List<String>> tableEntry : tableEntries)
		{
			if(tableEntry.getKey().equals(sqlColName))
			{
				colmnNames = tableEntry.getValue();
			}
		}
		return colmnNames;
	}
	
	private static Map<String, List<String>> getReplaceColMap()
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Set<Entry<String, List<String>>> tableEntries = getTableColMap().entrySet();
		Set<Entry<String, List<String>>> sqlEntries = getSqlMap().entrySet();
		for(Entry<String, List<String>> tableEntry : tableEntries)
		{
			for(Entry<String, List<String>> sqlEntry : sqlEntries)
			{
				if(tableEntry.getKey().equals(sqlEntry.getKey()))
				{
					/*String key = tableEntry.getValue();
					List<String> valueList = sqlEntry.getValue();
					map.put(key, valueList);*/
				}
			}
		}
		return map;
	}
	
	private static Map<String, String> getResponseMap()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("indiv.Addr", "105 Maroti");
		map.put("indiv.Postal", "444012");
		map.put("indiv.ContactName", "Tommy");
		map.put("nonIndiv.city", "Kochi");
		map.put("nonIndiv.Addr", "Ring Road");
		map.put("country", "India");
		map.put("indiv.CustName", "Tom");
		map.put("nonIndiv.CustName", "Bill");
		map.put("indiv.CustId", "101");
		map.put("nonIndiv.CustId", "106");
		map.put("indiv.city", "Pune");
		map.put("nonIndiv.ContactName", "Martin");
		map.put("nonIndiv.Postal", "417569");
		return map;
	}
	
	private static void setPartyIdAndType(String type)
	{
		partyIdType = type;
	}
	
	private static String getPartyIdAndType() {
		return partyIdType;
	}
	private static boolean verifyData()
	{
		boolean check=false;
		Set<Entry<String,String>> responseMapEntries=getResponseMap().entrySet();
		Set<Entry<String,List<String>>> sqlMapEntries=getSqlMap().entrySet();
		
		for(Entry<String,List<String>> sqlEntry : sqlMapEntries)
		{
			for(Entry<String,String> responseEntry : responseMapEntries)
			{
				if(responseEntry.getKey().equals(sqlEntry.getKey()))
				{
					check=true;
					if(sqlEntry.getValue().contains(responseEntry.getValue()))
					{
						check=true;
						System.out.println("Response Parameter= "+responseEntry.getKey()+" and value: "+responseEntry.getValue());
						System.out.println("Values in database: "+sqlEntry.getValue());
						System.out.println(responseEntry.getKey()+" parameter has value = "+responseEntry.getValue()+" in database.");
					}
					else
					{
						System.err.println("value fail");
						check=false;
					}
				}
			}
		}
		return check;
	}
	
	public static void main(String[] args) 
	{
		setPartyIdAndType("indiv");
		System.out.println(getSqlMap());
		//System.out.println(getReplaceColMap());
		boolean check = verifyData();
		System.out.println(check);
	}
}
