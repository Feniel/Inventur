package inventur;

import java.sql.*;

public class DBConnect{
	
	private Connection con;
	private Statement st;
	private String sqlAdresse;
	private String benutzer;
	private String passwort;
	
	public DBConnect(Backend ControlSqlQuery){
		sqlAdresse = "jdbc:mysql://localhost:3306/inventur";
		benutzer = "root";
		passwort = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(sqlAdresse,benutzer,passwort);
			st = con.createStatement();
		} catch (Exception e) {
			ControlSqlQuery.setCheckDBConnect(false);
		}
		
	}
	
	public Statement getStatement(){
		return this.st;
	}
}
