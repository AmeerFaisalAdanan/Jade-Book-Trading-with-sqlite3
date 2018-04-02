package jade_book_trading;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ameer Faisal
 */
public class SQLiteJDBCDriverConnection {
     /**
     * Connect to a sample database
     */
    public void DatabaseManagement() throws SQLException
    {
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
    
