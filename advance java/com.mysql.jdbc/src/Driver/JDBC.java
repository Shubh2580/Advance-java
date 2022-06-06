package Driver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;



public class JDBC {

public static void main(String[] args) throws Exception {
testAdd();
//testSelect();
}

public static void testAdd() throws Exception {
Class.forName("com.mysql.jdbc.Driver").newInstance();

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root", "root");
 CallableStatement cal= conn.prepareCall("{CALL col(?)}");
 CallableStatement cal1= conn.prepareCall("{CALL SumPhy(?)}");
 
 cal.registerOutParameter(1, Types.INTEGER);
 cal1.registerOutParameter(1, Types.INTEGER);
cal.execute();
cal1.execute();
int count = cal.getInt(1);
int total = cal1.getInt(1);
System.out.println("Count: " + count);
System.out.println("Total Marks: " + total);
}
}