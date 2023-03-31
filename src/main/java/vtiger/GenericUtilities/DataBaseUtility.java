package vtiger.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
public static void main(String[] args) throws Exception {
	 Driver d=new Driver();
		//step1:Register the driver
	     DriverManager.registerDriver(d);
		//step2:Get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db","root", "root");
		//step3:issue create statement
		Statement st=con.createStatement();
		//step4:execute a query
		String  rss ="insert into candidateinfo values('shashi',9,'warangal');";
		int adddata=st.executeUpdate(rss);
		if(adddata>=1)
		{
			System.out.println("data added successfully");
		}
		ResultSet result=st.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+result.getInt(2)+result.getString(3)); 
		}
		//step5:close the database
		con.close();
		System.out.println("db closed");
     }
}
