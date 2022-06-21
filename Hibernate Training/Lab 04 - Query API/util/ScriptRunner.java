package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ScriptRunner {

	public static void main(String[] args) throws Exception {
		String driverClass = "com.mysql.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		
		Connection conn = null;
		Statement st = null;
		FileReader file = null;
		BufferedReader buffer = null;
		
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
		
			file = new FileReader("bin/script.sql");
			buffer = new BufferedReader(file);
			
			String sql = "";
			while(true) {
				sql = buffer.readLine();
				if(sql == null)
					break;
				if(sql.length() != 0) {
					System.out.println(sql);
					st.execute(sql);
				}				
			}			
		}
		finally {
			try {
				st.close();
				conn.close();
				buffer.close();
				file.close();
			} catch(Exception e) { }
		}
	}
}
