// Algonquin college of applied arts and technology

/**
 * File name: RecipientsBusinessLogic.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Class that would handle the business logic of this application. 
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
package businesslayer;

import daolayer.*;
import dto.RecipientDTO;
import java.util.List;

/**
 *
 * @author juane
 */
public class RecipientsBusinessLogic {
    
    private RecipientsDAO recipientsDao = null;
    
    /**
     * Business logic constructor
     */
    public RecipientsBusinessLogic(){
        recipientsDao = new RecipientsDaoImpl();
    }
    
    /**
     * Gets all the recipients from the DAO
     * @return the list of recipients
     */
    public List<RecipientDTO> getAllRecipients(){
        return recipientsDao.getAllRecipients();
    }
    
    /**
     * Gets one of the recipients based on the ID
     * @param AwardID The ID of the recipient
     * @return the recipient
     */
    public RecipientDTO getRecipientByAwardID(Integer AwardID){
        return recipientsDao.getRecipientByAwardID(AwardID);
    }
    
    /**
     * Gets the last added recipient  
     * @return the last recipient added
     */
    public RecipientDTO getLastRecipient(){
        return recipientsDao.getLastRecipient();
    }
    
    /**
     * Inserts one recipient to the db 
     * @param recipient the recipient created
     */
    public void insertRecipient(RecipientDTO recipient){
        recipientsDao.insertRecipient(recipient);
    }
    
    /**
     * Deletes one recipient from the db
     * @param recipient the recipient to be deleted 
     */
    public void deleteRecipient(RecipientDTO recipient){
        recipientsDao.deleteRecipient(recipient);
    }
    
    /**
     * Deletes the last recipient from the db
     */
    public void deleteLastRecipient(){
        recipientsDao.deleteLastRecipient();
    }
    
    /**
     * Displays information about the columns of the data
     */
    public void displayColumnInfo(){
        recipientsDao.displayColumnInfo();
    }
   
}
