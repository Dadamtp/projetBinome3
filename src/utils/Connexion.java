package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connexion instance;
	private Connection cn;
	
	public Connexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//cn = DriverManager.getConnection("jdbc:oracle:thin:@gloin:1521:iut", "perezd", "123");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "perezd", "123");
			
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public synchronized static Connexion getInstance() {
		if (instance == null)
			instance = new Connexion();
		return instance;
	}
	
	public void Deconnexion() {
		if (cn != null)
			try {
				cn.close();
			} catch (SQLException e) {
				System.out.println("Deconnexion impossible.");
				e.printStackTrace();
			}
	}
}
