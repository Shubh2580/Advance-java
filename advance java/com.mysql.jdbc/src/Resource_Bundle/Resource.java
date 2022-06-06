package Resource_Bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Resource {
	public static void main(String[] args) throws Exception {
		
	ResourceBundle rb= ResourceBundle.getBundle("Resource_Bundle.app");
		Class.forName(rb.getString("Driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("username"), rb.getString("pwd"));
		Statement stmt = conn.createStatement();
		
		int i=stmt.executeUpdate("insert into result values (100,126,'neha','sharma',89,90,78)");
		System.out.println(i + " RecordInserted ");

}
}