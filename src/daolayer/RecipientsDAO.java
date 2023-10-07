// Algonquin college of applied arts and technology
package daolayer;

/**
 * File name: RecipientsDAO.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: DAO interface class that contains the methods to be used.  
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/

import dto.RecipientDTO;
import java.util.List;

public interface RecipientsDAO {
    
    /**
     * gets all recipients
     * @return a list of recipients
     */
    List<RecipientDTO> getAllRecipients();
    /**
     * Gets a recipient based on the id
     * @param AwardID the id of the recipient
     * @return the recipient 
     */
    RecipientDTO getRecipientByAwardID(Integer AwardID);
    
    /**
     * gets the last recipient
     * @return the last recipient
     */
    RecipientDTO getLastRecipient();
    /**
     * inserts a recipient
     * @param recipient the recipient object
     */
    void insertRecipient(RecipientDTO recipient);
    /**
     * Deletes a recipient
     * @param recipient the recipient object
     */
    void deleteRecipient(RecipientDTO recipient); 
    /**
     * Deletes the last recipient 
     */
    void deleteLastRecipient();
    /**
     * Displays information about the columns 
     */
    void displayColumnInfo();

}
