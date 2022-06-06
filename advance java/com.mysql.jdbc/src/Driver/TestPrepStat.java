package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class TestPrepStat {
	public static void main(String[] args) throws Exception {
		testAdd();
		//testSelect();
	}

	public static void testAdd() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oyo", "root", "root");
		int Id = 7;
		String name = "Sai";
		String Add = "Legal";
		int Rooms = 10;
		int MId = 4;
		PreparedStatement ps =  conn.prepareStatement("Update indore set Name=?, Address=?, Rooms=?, Manager_Id=? where id=?");
		
		ps.setString(1, name);
		ps.setString(2, Add);
		ps.setInt(3, Rooms);
		ps.setInt(4, MId);
		ps.setInt(5, Id);
		int i= ps.executeUpdate();
		System.out.println(i+ "Record Updated");

	}
}
