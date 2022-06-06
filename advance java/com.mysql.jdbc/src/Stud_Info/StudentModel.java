package Stud_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select max(id) from stud_info");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

}
}