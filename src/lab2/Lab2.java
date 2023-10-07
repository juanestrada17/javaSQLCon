// Algonquin college of applied arts and technology
package lab2;
import serverConnection.JavaConnection;
/**
 * File name: Lab2.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Main method using the JavaConnection class
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
public class Lab2 {
    
     /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        JavaConnection jconnect = new JavaConnection();
    
        jconnect.connect("src/database.properties");
        
        
        System.out.println("Initial table data: ");
        jconnect.printTable();
        
        System.out.println();
        System.out.println("Column information: ");
        jconnect.displayColumnInfo();
        
        jconnect.insertRecord("INSERT INTO RECIPIENTS "
                   + "(Name,Year,City,Category) VALUES('Marta', '2023', 'Medellin', 'Education')");
        
        
        System.out.println("Newly added record: ");
        jconnect.displayLast();
        System.out.println();
        jconnect.deleteRecord("DELETE FROM Recipients ORDER BY AwardID DESC LIMIT 1");
        
        System.out.println("Final table data: ");
        jconnect.printTable();
        
        jconnect.close();
        
    
    }
}
