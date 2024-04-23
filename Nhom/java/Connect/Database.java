/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author datba
 */
public class Database {
	
	public static Connection con = null;
	
	private static Database instance = new Database();
	
	public static Database getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=testSQL;encrypt=true;trustServerCertificate=true";
			String user = "sa";
			String pwd = "6f6562";
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
    
}
