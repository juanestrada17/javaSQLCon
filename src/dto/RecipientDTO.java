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
    
    public RecipientDTO(){
    
    }

    public Integer getAwardID(){
        return AwardID; 
    }

    public void setAwardID(Integer AwardID) {
        this.AwardID = AwardID;
    }
   
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    
    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer Year) {
        this.Year = Year;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
}
