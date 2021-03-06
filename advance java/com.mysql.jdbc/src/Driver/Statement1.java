package Driver;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Statement1{
	public static void main(String[] args) throws Exception {
		testSelect();
		//testInsert();
		//testUpdate();
		//testDelete();
		//testget();
	}
	
	private static void testget() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from result where id=1");

		while (rs.next()) {

			System.out.println(rs.getString("ID"));
			System.out.println(rs.getString("RollNo"));
			System.out.println(rs.getString("FName"));
			System.out.println(rs.getString("LName"));
			System.out.println(rs.getString("Physics"));
			System.out.println(rs.getString("Chemistry"));
			System.out.println(rs.getString("Maths"));

		}}

	private static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		int i=stmt.executeUpdate("delete from result where id=10" );
		System.out.println(i +" :RecordDeleted");
		
		
	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		int i=stmt.executeUpdate("update result set Rollno='127' ,fname='saloni' where id=10" );
		System.out.println(i +" :RecordUpdated");
		
	}

	private static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		Statement stmt = conn.createStatement();
		
		int i=stmt.executeUpdate("insert into result values (10,126,'neha','sharma',89,90,78)");
		System.out.println(i +"RecordInserted");
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from result");

		while (rs.next()) {

			System.out.print("\t"+rs.getString("ID"));
			System.out.print("\t"+rs.getString("RollNo"));
			System.out.print("\t"+rs.getString("FName"));
			System.out.print("\t"+rs.getString("LName"));
			System.out.print("\t"+rs.getString("Physics"));
			System.out.print("\t"+rs.getString("Chemistry"));
			System.out.println("\t"+rs.getString("Maths"));

		}
		stmt.close();
		rs.close();
		conn.close();
	}

}
