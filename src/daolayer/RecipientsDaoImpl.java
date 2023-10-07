/**
 * File name: RecipientsDaoImpl.java
 * Student Name:Juan Estrada
 * Student Number:041082636
 * Course & Section #: 23F_CST8288_030
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 * Assignment: Lab 02 
 * Professor: Gustavo Adami 
 * Purpose: Class that implements the RecipientsDAO interface 
 * @author by Juan Estrada
 * @version Date: 02/10/2023
*/
package daolayer;
import java.util.List;
import dto.RecipientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.sql.SQLException;


public class RecipientsDaoImpl implements RecipientsDAO {
    
    
    @Override
    public List<RecipientDTO> getAllRecipients(){
        Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<RecipientDTO> recipients = null;
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement(
                            "SELECT * FROM Recipients");
            resultSet = preparedStatement.executeQuery();
            recipients = new ArrayList<RecipientDTO>();
            while(resultSet.next()){
                    RecipientDTO recipient = new RecipientDTO();
                    recipient.setAwardID(resultSet.getInt("AwardID"));
                    recipient.setName(resultSet.getString("Name"));
                    recipient.setYear(resultSet.getInt("Year"));
                    recipient.setCity(resultSet.getString("City"));
                    recipient.setCategory(resultSet.getString("Category"));
                    recipients.add(recipient);
            }
        } // end of try
        catch(SQLException e){
                e.printStackTrace();
        }
        finally{
                try{ if(resultSet != null){ resultSet.close(); } }
                catch(SQLException ex){System.out.println(ex.getMessage());}
                try{ if(preparedStatement != null){ preparedStatement.close(); }}
                catch(SQLException ex){System.out.println(ex.getMessage());}
                try{ if(con != null){ con.close(); }}
                catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return recipients;
    }
    
    @Override 
    public RecipientDTO getRecipientByAwardID(Integer AwardID){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RecipientDTO recipient = new RecipientDTO();
       
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("SELECT * FROM Recipients "
                    + "WHERE AwardID = ?");
            preparedStatement.setInt(1, AwardID.intValue());
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                recipient = new RecipientDTO();
                recipient.setAwardID(resultSet.getInt("AwardID"));
                recipient.setName(resultSet.getString("Name"));
                recipient.setCity(resultSet.getString("City"));
                recipient.setYear(resultSet.getInt("Year"));
                recipient.setCategory(resultSet.getString("Category"));         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(resultSet != null){ resultSet.close(); 
                } 
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return recipient; 
    }
    
    @Override
    public RecipientDTO getLastRecipient(){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RecipientDTO recipient = new RecipientDTO();
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("SELECT * FROM Recipients ORDER BY AwardID "
                    + "DESC LIMIT 1");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                recipient = new RecipientDTO();
                recipient.setAwardID(resultSet.getInt("AwardID"));
                recipient.setName(resultSet.getString("Name"));
                recipient.setCity(resultSet.getString("City"));
                recipient.setYear(resultSet.getInt("Year"));
                recipient.setCategory(resultSet.getString("Category"));         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(resultSet != null){ resultSet.close(); 
                } 
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return recipient; 
    }
    
    
    
    @Override 
    public void insertRecipient(RecipientDTO recipient){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("INSERT INTO RECIPIENTS "
                   + "(Name,Year,City,Category) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, recipient.getName());
            preparedStatement.setInt(2, recipient.getYear());
            preparedStatement.setString(3, recipient.getCity());
            preparedStatement.setString(4, recipient.getCategory());
            preparedStatement.executeUpdate(); 
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
       
    @Override 
    public void deleteRecipient(RecipientDTO recipient){
        Connection con = null;
        PreparedStatement preparedStatement = null;
    
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("DELETE FROM Recipients "
                    + "WHERE AwardID= ?");
            preparedStatement.setInt(1, recipient.getAwardID());
            preparedStatement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
        }}
    
    @Override 
    public void deleteLastRecipient(){
        Connection con = null;
        PreparedStatement preparedStatement = null;
    
        try{
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("DELETE FROM Recipients ORDER BY AwardID "
                    + "DESC LIMIT 1");
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
        }}
    
    @Override 
    public void displayColumnInfo(){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            preparedStatement = con.prepareStatement("select * from Recipients");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
        
        for(int i = 1; i <= columnCount; i++){
               System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i) + " " + 
                       metaData.getColumnClassName(i));
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            
            try{ 
                if(preparedStatement != null){ preparedStatement.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(resultSet != null) {resultSet.close();}
            } catch(SQLException ex){System.out.println(ex.getMessage());}
            }
        }
    
}
    
    

