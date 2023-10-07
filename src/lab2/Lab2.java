// Algonquin college of applied arts and technology
package lab2;

import dto.RecipientDTO;
import java.util.List;
import businesslayer.RecipientsBusinessLogic;
/**
 * File name: Lab2.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Driver class of the application
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
public class Lab2 {
    /**
     * Main method
     * @param args arguments 
     */
    public static void main(String[] args) {
        
        RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
        List<RecipientDTO> recipients = null;
        RecipientDTO recipient = null; 
        
        // Prints all elements 
        recipients = logic.getAllRecipients(); 
        System.out.println("Printing all: ");
        
        // method to print all records
        printAll(recipients);
        System.out.println();
        // Column information 
        System.out.println("Displaying column info: ");
        logic.displayColumnInfo();
        System.out.println();
        
       // Inserts one element
       RecipientDTO newRecipient =  new RecipientDTO();
       newRecipient.setName("Marta");
       newRecipient.setYear(2023);
       newRecipient.setCity("Medellin");
       newRecipient.setCategory("Business");
       logic.insertRecipient(newRecipient);
       
       // Prints the last recipient
       System.out.println("New Inserted Recipient: ");
       recipient = logic.getLastRecipient();
       printLast(recipient);
        
        // Delete element 
        System.out.println();
        logic.deleteLastRecipient();
        // prints last element
        System.out.println("Deleted last Recipient, and printing all: ");
        recipients = logic.getAllRecipients();
        printAll(recipients);
    }
    
    /**
     * Prints all recipients
     * @param recipients All recipients. 
     */
    public static void printAll(List<RecipientDTO> recipients){
        String finalName = "";
        for(RecipientDTO reci: recipients){
           String nameParts[] = reci.getName().split(";");
           if(nameParts.length == 2){
                    finalName = nameParts[1] + " " + nameParts[0];
                } else{
                    finalName = nameParts[0];
                }
           String eachRecipient = String.format("%s. %s, %s, %s, %s ",
                reci.getAwardID().toString(),
                finalName,
                reci.getCity(), 
                reci.getYear().toString(),
                reci.getCategory());
                System.out.println(eachRecipient);
              
       }
    }
    /**
     * Prints the last recipient
     * @param recipient the recipient object
     */
    public static void printLast(RecipientDTO recipient){
       String lastRecipient = String.format("%s. %s, %s, %s, %s ",
                recipient.getAwardID().toString(),
                recipient.getName(),
                recipient.getCity(),
                recipient.getYear().toString(),
                recipient.getCategory());
                System.out.println(lastRecipient);
    }
    
    
    
}
