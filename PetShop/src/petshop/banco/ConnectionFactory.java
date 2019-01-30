/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Luiz-PC
 */
public class ConnectionFactory {
    
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/teste";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha ao conectar");
            throw new RuntimeException("Erro na conexão"+ex);
        }
    }
    
    public static void closeConnection(Connection con){
        
       if(con != null){
           try {
               con.close();
           } catch (SQLException ex) {
               System.err.println("Erro: ao fechar conexão"+ex);
           }
       }
    }
        
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
       if(stmt != null){
           try {
               stmt.close();
           } catch (SQLException ex) {
              System.err.println("Erro: ao fechar Statement"+ex);
           }
       }
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
       if(rs != null){
           try {
               rs.close();
           } catch (SQLException ex) {
             System.err.println("Erro: ao fechar ResultSet"+ex); 
           }
       }
        closeConnection(con, stmt);
    }
        
}
