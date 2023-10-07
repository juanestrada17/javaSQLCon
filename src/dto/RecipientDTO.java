// Algonquin college of applied arts and technology
package dto;

/**
 * File name: RecipientDTO.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Recipient class to create Recipient objects 
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
public class RecipientDTO {
    
    private Integer AwardID;
    private String Name; 
    private Integer Year; 
    private String City;
    private String Category; 
    /**
     * Constructor of the RecipientDTO
     */
    public RecipientDTO(){
    
    }
    
    /**
     * Gets the ID
     * @return the AwardID
     */
    public Integer getAwardID(){
        return AwardID; 
    }

    /**
     * Sets the ID
     * @param AwardID the new AwardID 
     */
    public void setAwardID(Integer AwardID) {
        this.AwardID = AwardID;
    }
    
    /**
     * Gets the name
     * @return the Name
     */
    public String getName() {
        return Name;
    }
    
    /**
     * Sets the name
     * @param Name the Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
    /**
     * Gets the city
     * @return the City
     */
    public String getCity() {
        return City;
    }
    
    /**
     * Sets the city 
     * @param City the City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * Gets the Year
     * @return the Year
     */
    public Integer getYear() {
        return Year;
    }

    /**
     * Sets the Year
     * @param Year the Year
     */
    public void setYear(Integer Year) {
        this.Year = Year;
    }
    
    /**
     * Gets the Category
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * Sets the Category
     * @param Category the category
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }
}
