package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconnectivity {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		String path = "jdbc:mysql://"+host+":"+ port + "/qadbt";
		Connection con = DriverManager.getConnection(path, "root", "Harish@0605");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM Credentials WHERE scenario = 'zerobalancecard';");
		while(rs.next()) {
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
//			rs.getString("username");
//			rs.getString("password");
		}
		

	}
}
