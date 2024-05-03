/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;
import java.sql.*;
/**
 *
 * @author Ryan
 */
public class ConectaSQL {
    private final static String url = "jdbc:mysql://localhost:3306/IngressosDB";
    private final static String username = "root";
    private final static String password = "";
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    

    public static void main(String args[]){
            ConectaSQL b = new  ConectaSQL();
        b.openDB();
        b.closeDB();


    }


    public void openDB(){
        try{
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("\nConexão estabelicida com sucesso\n");
        } catch (SQLException e){
            System.out.println("\nNão foi possivel estabelecer conexão" + e + "\n");
            System.exit(1);
        }

    }

    public void closeDB(){
        try{
            con.close();
        }catch (SQLException e){
            System.out.println("\nNão foi possivel fechar a conexão" + e + "\n");
            System.exit(1);
        }
    }
}
