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
package daolayer;

/**
 *
 * @author juane
 */

import dto.RecipientDTO;
import java.util.List;

public interface RecipientsDAO {
    List<RecipientDTO> getAllRecipients();
    
    RecipientDTO getRecipientByAwardID(Integer AwardID);
    RecipientDTO getLastRecipient();
    void insertRecipient(RecipientDTO recipient);
    void deleteRecipient(RecipientDTO recipient); 
    void deleteLastRecipient();
    void displayColumnInfo();

}
