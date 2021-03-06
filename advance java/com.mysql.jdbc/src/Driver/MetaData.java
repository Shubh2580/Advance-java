package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaData {
	public static void main(String[] args) throws Exception {
		testAdd();
}
public static void testAdd() throws Exception{
	Class.forName("com.mysql.jdbc.Driver").newInstance();

	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root", "root");
	Statement stmt= conn.createStatement();
	ResultSet rs= stmt.executeQuery("Select * from result");
	ResultSetMetaData rsmt= rs.getMetaData();
	System.out.println("Catalog Name: " + rsmt.getCatalogName(1));
	System.out.println("Table Name: " + rsmt.getTableName(1));
	int columnCount= rsmt.getColumnCount();
	System.out.println("Total Columns: "+ columnCount);
	
	for (int i=1; i<=columnCount; i++) {
		System.out.println("Label: "+ rsmt.getColumnLabel(i));
		System.out.println("Type: "+ rsmt.getColumnTypeName(i));
	}

}}