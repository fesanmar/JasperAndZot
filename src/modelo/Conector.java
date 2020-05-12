package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector
{
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/yourDatabase?serverTimezone=YourTimezone";
	private String login = "yourUser";
	private String password = "yourPassword";
	private Connection conn = null;
	
	public Conector()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConexion()
	{
		return conn;
	}
	
	public void close()
	{
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
