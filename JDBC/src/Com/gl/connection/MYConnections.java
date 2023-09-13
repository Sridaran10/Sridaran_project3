package Com.gl.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYConnections {
Connection con;
String user="root";
String password ="password";
String url="jdbc:mysql://localhost:3306/jdbc_demo";
	public Connection getMyConnection() {
		
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}


