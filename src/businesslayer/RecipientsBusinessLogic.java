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
    
    public RecipientsBusinessLogic(){
        recipientsDao = new RecipientsDaoImpl();
    }
    
    public List<RecipientDTO> getAllRecipients(){
        return recipientsDao.getAllRecipients();
    }
    
    public RecipientDTO getRecipientByAwardID(Integer AwardID){
        return recipientsDao.getRecipientByAwardID(AwardID);
    }
    public RecipientDTO getLastRecipient(){
        return recipientsDao.getLastRecipient();
    }
    
    public void insertRecipient(RecipientDTO recipient){
        recipientsDao.insertRecipient(recipient);
    }
    public void deleteRecipient(RecipientDTO recipient){
        recipientsDao.deleteRecipient(recipient);
    }
    
    public void deleteLastRecipient(){
        recipientsDao.deleteLastRecipient();
    }
    
    public void displayColumnInfo(){
        recipientsDao.displayColumnInfo();
    }
   
}
