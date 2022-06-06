package Driver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Functn {
public static void main(String[] args) throws Exception {
	testAdd();
}
public static void testAdd() throws Exception{
	Class.forName("com.mysql.jdbc.Driver").newInstance();

	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root", "root");
	 CallableStatement cal= conn.prepareCall("{?=CALL resu()}");
	 cal.registerOutParameter(1, Types.INTEGER);
	 
	 
	 cal.execute();
	 System.out.println("Count: " + cal.getInt(1) );

}
}
