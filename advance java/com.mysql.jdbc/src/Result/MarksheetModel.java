package Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select max(id) from result");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

	}
	

	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Insert into result values (?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setInt(2, bean.getRollNo());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChem());
		ps.setInt(7, bean.getMaths());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println("Inserted : " + i);
		ps.close();
		conn.close();

	}

	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("update result set id=?, fname=?, lname=?,physics=?,chemistry=?,maths=? where rollno=?");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChem());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getRollNo());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Updated");
		ps.close();
		conn.close();

	}

	public void delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from result where rollno=?");
		ps.setInt(1, bean.getRollNo());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Deleted");
		ps.close();
		conn.close();
	}

	public List<MarksheetBean> get(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from result where rollno = ?");
		ps.setInt(1, bean.getRollNo());
		ResultSet rs = ps.executeQuery();
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMaths(rs.getInt(7));
			list.add(bean1);
		}
		return list;

	}

	public List<MarksheetBean> search() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from result");
		ResultSet rs = ps.executeQuery();
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMaths(rs.getInt(7));
			list.add(bean1);
		}
		return list;
	}

	public List<MarksheetBean> getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select *,  ((physics + chemistry + maths)/3) as percentage from result where (physics > 40 AND chemistry > 40 AND Maths > 40) order by (physics + chemistry + maths)");
		ResultSet rs = ps.executeQuery();
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollNo(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMaths(rs.getInt(7));
			list.add(bean1);
		}
		return list;
	}
}
