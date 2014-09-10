package ua.cn.notebook.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Connection to data base
 * @author Kseniia
 *
 */
public class ConnectionDB {

	private static Connection con = null;
	private static java.sql.Statement stmt = null;

	 public static Connection getConnection() {
	        if (con != null)
	            return con;
	        else {
	            try {
	            	Properties prop = new Properties();
	    			try {
						prop.load(ConnectionDB.class.getClassLoader().getResourceAsStream(
								"db.properties"));
					} catch (IOException e) {
						e.printStackTrace();
					}
	    			
	    			String drivers = prop.getProperty("db.driver");
	    			String connectionURL = prop.getProperty("db.url");
	    			String username = prop.getProperty("db.user");
	    			String password = prop.getProperty("db.password");
	    			              
	                Class.forName(drivers);
	                con = DriverManager.getConnection(connectionURL, username, password);
	                System.out.println("Connection Successful");
	                
	                stmt = con.createStatement();
	    			String sql = "CREATE TABLE IF NOT EXISTS users "
	    					+ "(id         int                PRIMARY KEY NOT NULL, "
	    					+ " secondname character varying, "
	    					+ " firstname  character varying, "
	    					+ " age        integer, "
	    					+ " gender     char,              CHECK (gender = 'm'::char OR gender = 'f'::char), "
	    					+ " phone      character varying)";
	    			stmt.executeUpdate(sql); 	    			
	    			stmt.close();       
	            } catch (Exception e) {
	            	e.printStackTrace();
	    			System.out.println("error !");
	            }
	            System.out.println("Table created successfully");
	            return con;	        
	 }
   }
}

	


