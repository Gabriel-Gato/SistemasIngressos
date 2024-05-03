/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autenticacao {
     private static final String url = "jdbc:mysql://localhost:3306/IngressosDB"; 
     private static final   String usuario = "root"; 
     private static final    String senhaDB = ""; 
     
     
     public boolean autenticarUsuario(String email, String senha){
         String query = "SELECT * FROM clientes WHERE email = ? AND senha = ? ";
         
       try (Connection conexao = DriverManager.getConnection(url, usuario, senhaDB);
                PreparedStatement statement = conexao.prepareStatement(query)) {
            
            statement.setString(1, email);
            statement.setString(2, senha);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); 
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            return false;
        }
    }
   }

