package in.co.rays.model;

import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.LoginBean;


public class LoginModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?, ? )");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLogin());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getGender());
		ps.setDate(7, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(8, bean.getMobileNo());
		// ps.setString(9, bean.getAddress());

		/*
		 * for (String s : bean.getAddress()) {
		 * 
		 * ps.setString(9, s); }
		 */

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Inserted");
		ps.close();
		conn.close();

	}

	public LoginBean authenticate(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where login = ? and password = ?");
		ps.setString(1, bean.getLogin());
		ps.setString(2, bean.getPassword());
		ResultSet rs = ps.executeQuery();
		LoginBean bean1 = null;
		while (rs.next()) {
			bean1 = new LoginBean();
			bean1.setId(rs.getInt(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setLogin(rs.getString(4));
			bean1.setPassword(rs.getString(5));
			bean1.setGender(rs.getString(6));
			bean1.setDob(rs.getDate(7));
			bean1.setMobileNo(rs.getString(8));

		}
		return bean1;

	}

	public LoginBean findByLogin(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where login = ?");
		ps.setString(1, bean.getLogin());
		ResultSet rs = ps.executeQuery();
		LoginBean bean1 = null;
		while (rs.next()) {
			bean1 = new LoginBean();
			bean1.setId(rs.getInt(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setLogin(rs.getString(4));
			bean1.setPassword(rs.getString(5));
			bean1.setGender(rs.getString(6));
			bean1.setDob(rs.getDate(7));
			bean1.setMobileNo(rs.getString(8));

		}
		return bean1;

	}

	public LoginBean findByPk(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, bean.getId());
		ResultSet rs = ps.executeQuery();
		LoginBean bean1 = null;
		while (rs.next()) {
			bean1 = new LoginBean();
			bean1.setId(rs.getInt(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setLogin(rs.getString(4));
			bean1.setPassword(rs.getString(5));
			bean1.setGender(rs.getString(6));
			bean1.setDob(rs.getDate(7));
			bean1.setMobileNo(rs.getString(8));

		}
		return bean1;

	}

	public List<LoginBean> search(LoginBean bean, int pageNo, int pageSize) throws Exception {
		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
                sql.append(" AND FIRSTNAME like '" + bean.getFirstName() + "%'");
            }
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and last like '" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password like '" + bean.getPassword() + "%'");
			}
			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" and gender like '" + bean.getGender() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getDate() > 0) {
				sql.append(" and dob = " + bean.getGender());
			}
			if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
				sql.append(" and mobile no = " + bean.getMobileNo());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
				
			

			sql.append(" Limit " + pageNo + ", " + pageSize);
		}
		System.out.println(sql);

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList<LoginBean> list = new ArrayList<LoginBean>();
		while (rs.next()) {

			LoginBean bean1 = new LoginBean();
			bean1.setId(rs.getInt(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setLogin(rs.getString(4));
			bean1.setPassword(rs.getString(5));
			bean1.setGender(rs.getString(6));
			bean1.setDob(rs.getDate(7));
			bean1.setMobileNo(rs.getString(8));
			list.add(bean1);

		}
		return list;

	}

	public void update(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(
				"update user set firstname=?, lastname=?,login=?,password=?,gender=?,dob=?,mobile=? where id=?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLogin());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getGender());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getMobileNo());
		ps.setInt(8, bean.getId());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Updated");
		ps.close();
		conn.close();

	}
	public void delete(LoginBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from user where id=?");
		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + ":Record Deleted");
		ps.close();
		conn.close();

	}
	
}
