package Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDSMain {
	
	public static void main(String[] args) throws Exception {
		for (int i=0; i<=18; i++) {
			System.out.println("Loop:- " + i);
		
	testJdbc();}
	}
	private static void testJdbc() throws Exception {
		String sql = "Select id, rollno  from result";
		Connection conn = JdbcDataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		System.out.println("DB Pool Connection");
		System.out.println("ID\tRollNo");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println("\t" + rs.getInt(2));
	
		
	}

	
		JdbcDataSource.closeConnection(conn, stmt, rs);
	}

}
