package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/movies";
	private static String USER = "root";
	private static String PASSWORD = "1408";
	
	private static GenericDAO instancia;
	private Connection con;
	
	private GenericDAO() throws ClassNotFoundException, SQLException { 
		Class.forName( JDBC_DRIVER );
		con =DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}
	
	public static GenericDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instancia == null) { 
			instancia = new GenericDAO();
		}
		return instancia;		
	}

	public Connection getCon() {
		return con;
	}
}
