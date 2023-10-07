// Algonquin college of applied arts and technology
package serverConnection;

/**
 * File name: JavaConnection.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: class that handles the Java connection and methods
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
/**
 *
 * @author juane
 */
public class JavaConnection {
    private Connection connection; 
    private PreparedStatement statement; 
    private ResultSet resultSet; 
    
    /**
     * Constructor without parameters
     */
    public JavaConnection(){
    
    }
    
    /**
     * Loads the properties using the Properties class and InputSteam
     * @param path the path of the database.properties
     * @return the properties
     */
    private Properties loadProperties(String path){
       Properties props = new Properties();
       InputStream input = null;
       try {
        // We use the Paths.get in order to access the folder where the
        // properties are located 
           input = Files.newInputStream(Paths.get(path));
       // Load the properties so that we can use them later
           props.load(input);
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           try {
               input.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return props;
    }
    
    /**
     * Connects the user to the database using url, username and password
     * @param path the path of the database.properties.
     */
    public void connect(String path){
       Properties props = loadProperties(path);
       String url = props.getProperty("jdbc.url");
       String username = props.getProperty("jdbc.username");
       String password = props.getProperty("jdbc.password");
       try{
           connection = DriverManager.getConnection(url, username, password);
       } catch (SQLException sqlException) {
           sqlException.printStackTrace();
       } 
    }
    
    /**
     * Method that displays the data from the database with a Prepared SQL
     * Statement
     */
    public void printTable(){
        try{
            statement = connection.prepareStatement(
                   "SELECT * FROM Recipients",
                   ResultSet.TYPE_SCROLL_INSENSITIVE, 
                   ResultSet.CONCUR_UPDATABLE);

           // query database. We use the result set to store the query result.                                        
           resultSet = statement.executeQuery();
           // Accesses information about the data, such as the column name or 
           //column count 
           ResultSetMetaData metaData = resultSet.getMetaData();
           // Uses the metadata to get the column count 
           int columnCount = metaData.getColumnCount();
           
            // Print rows
            while (resultSet.next()) {
                
                String name = resultSet.getString("Name");
                String nameParts[] = name.split(";");

                System.out.print(resultSet.getInt("AwardID") + " | ");
                if(nameParts.length == 2){
                    System.out.print(nameParts[1] + " " + nameParts[0]+ " | ");
                } else{
                    System.out.print(nameParts[0]+ " | ");

                }
                System.out.print(resultSet.getInt("Year")+ " | ");
                System.out.print(resultSet.getString("City")+ " | ");
                System.out.print(resultSet.getString("Category"));
                System.out.println();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Method that displays information about the columns of the database. 
     */
    public void displayColumnInfo(){
        try{
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        for(int i = 1; i <= columnCount; i++){
               System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i) + " " + 
                       metaData.getColumnClassName(i));
           }
           
           System.out.println();
        } catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    /**
     * Inserts a record into the database.
     * @param insertQuery The SQL query for inserting a record to the db
     */
    public void insertRecord(String insertQuery){
        try{
           int insertState = statement.executeUpdate(insertQuery);
           // Navigates to the last element of the result set to print it. 
           resultSet = statement.executeQuery();} 
        catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    /**
     * Deletes a record from the database. 
     * @param deleteQuery the SQL query for deleting a record from the db. 
     */
    public void deleteRecord(String deleteQuery){
        try{
        int deleteState =  statement.executeUpdate(deleteQuery);
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    /**
     * Displays the last element of the database
     */
    public void displayLast(){
        try{
        resultSet = statement.executeQuery();
        resultSet.last();
           System.out.print(resultSet.getInt("AwardID") + " ");
           System.out.print(resultSet.getString("Name")+ " ");
           System.out.print(resultSet.getInt("Year")+ " ");
           System.out.print(resultSet.getString("City")+ " ");
            System.out.print(resultSet.getString("Category")+ " ");
           System.out.println();
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    /**
     * Closes the connection, result set and statement. 
     */
    public void close(){
        try                                                        
          {                                                          
              resultSet.close();                                      
              statement.close();                                      
              connection.close();                                     
          } // end try                                               
          catch ( Exception exception )                              
          {                                                          
             exception.printStackTrace();                            
          } // end catch                 
    }
    
}
