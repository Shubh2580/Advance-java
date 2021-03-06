package Driver;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStat1 {
	
	public static void main(String[] args) throws Exception {
		//testInsert();
		//testUpdate();
		testSelect();
		//testGet(1);
		//testGet();
		//testDelete();
		//testDeleteone();
		//testDeletetwo(16);
	}

	private static void testDeletetwo(int pk) throws Exception{	
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		
		
		
		PreparedStatement ps =conn.prepareStatement("delete from result where id=?");
		ps.setInt(1,pk);
	
		int i=ps.executeUpdate();
		System.out.println(i + ":RecordDeleted");
	}

		
	

	private static void testDeleteone() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		
		
		int id=17;
		PreparedStatement ps =conn.prepareStatement("delete from result where id=?");
		ps.setInt(1,id);
	
		int i=ps.executeUpdate();
		System.out.println(i + ":RecordDeleted");
	}

		
	
	private static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		
		
		
		PreparedStatement ps =conn.prepareStatement("delete from result where id=18");
		
	
		int i=ps.executeUpdate();
		System.out.println(i + ":RecordDeleted");
	}

		
	
	private static void testGet() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
	int id = 1;
		PreparedStatement ps =conn.prepareStatement("select * from result where id=?");
		ps.setInt(1,id);
	
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.print("\t"+rs.getString("ID"));
			System.out.print("\t"+rs.getString("RollNo"));
			System.out.print("\t"+rs.getString("FName"));
			System.out.print("\t"+rs.getString("LName"));
			System.out.print("\t"+rs.getString("Physics"));
			System.out.print("\t"+rs.getString("Chemistry"));
			System.out.println("\t"+rs.getString("Maths"));

		}
	
		rs.close();
		conn.close();
	
		
	}

	private static void testGet(int pk) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
	
		PreparedStatement ps =conn.prepareStatement("select * from result where id=?");
		ps.setInt(1, pk);
	
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getString("\t"+"id"));
			System.out.print(rs.getString("\t"+"rollno"));
			System.out.print(rs.getString("\t"+"fname"));
			System.out.print(rs.getString("\t"+"lname"));
			System.out.print(rs.getString("\t"+"physics"));
			System.out.print(rs.getString("\t"+"chemistry"));
			System.out.println(rs.getString("\t"+"maths"));

		}
	
		rs.close();
		conn.close();
	
		
		
	}

	private static void testSelect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
	
		
		
		PreparedStatement ps =conn.prepareStatement("select * from result");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.print("\t"+rs.getString("ID"));
			System.out.print("\t"+rs.getString("RollNo"));
			System.out.print("\t"+rs.getString("FName"));
			System.out.print("\t"+rs.getString("LName"));
			System.out.print("\t"+rs.getString("Physics"));
			System.out.print("\t"+rs.getString("Chemistry"));
			System.out.println("\t"+rs.getString("Maths"));

		}
	
		rs.close();
		conn.close();
	
		
	

		
		
	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		int id=18;
		int rollno=129;
		String fname="flora";
		String lname="somani";
		int physics=45;
		int chemistry=77;
		int maths=55;
		
		
		PreparedStatement ps =conn.prepareStatement("update marksheet set rollno=?,fname=?,lname=?,physics=?,chemistry=?,maths=? where id=?");
		
		ps.setInt(1, rollno);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, physics);
		ps.setInt(5, chemistry);
		ps.setInt(6, maths);
		ps.setInt(7, id);
		
		int i=ps.executeUpdate();
		System.out.println(i + ":RecordUpdated");
	}

		
		
	
	private static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		int id=18;
		int rollno=128;
		String fname="inaya";
		String lname="joshi";
		int physics=55;
		int chemistry=66;
		int maths=77;
		
		
		PreparedStatement ps =conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setInt(2, rollno);
		ps.setString(3, fname);
		ps.setString(4, lname);
		ps.setInt(5, physics);
		ps.setInt(6, chemistry);
		ps.setInt(7, maths);
		
		int i=ps.executeUpdate();
		System.out.println(i + ":RecordInstered");
	}

}
