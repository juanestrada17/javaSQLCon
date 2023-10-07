/**
 * File name: DataSource.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Class that handles the connection and loading of properties of the app. 
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
package daolayer;

import java.sql.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author juane
 */
public class DataSource {
    
    private Connection connection = null;
    
    public DataSource(){
        
    }
  
    public Connection createConnection(){
        Properties props = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("src/database.properties"));) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
	}
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        
       try{ 
          if(connection != null){
           System.out.println("Cannot create new connection, one exists already");
           } else {
              connection = DriverManager.getConnection(url, username, password);
           }
           
       } catch (SQLException sqlException) {
           sqlException.printStackTrace();
       } 
       return connection; 
    }
}
