package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactnHandl {
 public static void main(String[] args) throws Exception {
		testAdd();
	}
	public static void testAdd() throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root", "root");
		conn.setAutoCommit(false);
		Statement stmt= conn.createStatement();
		int i= stmt.executeUpdate("Insert into result values(14,115, 'Rekha', 'Singh', 69,96,69)");
		int j= stmt.executeUpdate("Insert into result values(15,116, 'Rekha', 'Sharma', 73,84,55)");
		int k= stmt.executeUpdate("Insert into result values(14,115, 'Rekha', 'Singh', 69,96,69)");
		int l= stmt.executeUpdate("Insert into result values(15,116, 'Rekha', 'Sharma', 73,84,55)");
		conn.commit();
		System.out.println(i+ j+k+l+ "Record Inserted");
		stmt.close();
		conn.close();
				

}
}
