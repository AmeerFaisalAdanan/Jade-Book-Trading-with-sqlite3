/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade_book_trading;

//import SQLiteJDBCDriverConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Ameer Faisal
 */
public class Jade_book_trading {

    /**
     * @param args the command line arguments
     */
    
    //checking database
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        SQLiteJDBCDriverConnection SQL = new SQLiteJDBCDriverConnection();
            
            
            Connection conn = null;
            String url = "jdbc:sqlite:C://sqlite/db/bookstore1.db";
            
            String sql1 = "CREATE TABLE IF NOT EXISTS catalogues (\n"
                    + " sellerName text NOT NULL,\n"
                    + " bookTitle text NOT NULL,\n"
                    + " bookPrice integer NOT NULL\n"
                    + " );";
            
            String sql2 = "CREATE TABLE IF NOT EXISTS buyers (\n"
                    + " buyerName text NOT NULL,\n"
                    + " bookTitle text NOT NULL,\n"
                    + " bookPrice integer NOT NULL,\n"
                    + " sellerName text NOT NULL \n"
                    + " );";
            
            String drop_table_cat = "DROP TABLE IF EXISTS catalogues ";
            String drop_table_buy = "DROP TABLE IF EXISTS buyers";
           
            
            conn = DriverManager.getConnection(url);
            System.out.println("Database Operation. Connect Successfully");
            try(Statement st = conn.createStatement())
            {
                //dropping all database
                
                st.execute(drop_table_cat);
                System.out.println("Database Operation. Table Catalogue Dropped");
                st.execute(drop_table_buy);
                System.out.println("Database Operation. Table Buyer Dropped");
                st.execute(sql1);
                System.out.println("Database Operation. Table Catalogue Created");
                st.execute(sql2);
                System.out.println("Database Operation. Table Buyer Created");
                
            }
            catch(SQLException e)
            {
                System.out.println("Database Operation"+e.getMessage());
            }
        }
        
    }
    
