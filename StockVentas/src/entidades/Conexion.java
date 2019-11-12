/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Conexion {

    String driver = "org.postgresql.Driver";
    String connectString;
    String user = "postgres";
    String password = "12345678";
    private static Connection conexion;

   public Conexion() throws SQLException {
        this.connectString = "jdbc:postgresql://localhost:5432/stock";
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(connectString, user, password);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection() {
        return conexion;
    }
    
    public void Close() throws SQLException {
        conexion.close();
    }
    
    public int getUsuaio_id(String pCuil){
        
        return -1;
    }

}
