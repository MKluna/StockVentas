/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;


import entidades.Conexion;
import entidades.Tmp_VentasR;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author timpa
 */
public class Fac_TmpVentasR {
    public void Nuevo_VentasR(Tmp_VentasR pVentaR) throws SQLException {
        try {
            Conexion CON = new Conexion();
            try (Connection conn = CON.getConnection()) {
                Statement sta = conn.createStatement();                               
                String SQL = "INSERT INTO tmp_ventasr(articulos_id, cantidad, precio, subtotal, articulo)"
                        + " VALUES ( "+pVentaR.getArticulos_id()+", "+pVentaR.getCantidad()+", "+pVentaR.getPrecio()+", "+pVentaR.getSubtotal()+", '"+pVentaR.getArticulo()+"')";
                
                int fila = sta.executeUpdate(SQL);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Metodo facade_Tmp_VentasR.Nuevo_VentasR");
        }
    }

    public void Eliminar_Tmp_VentasR(int pVentaR_id) throws SQLException { // borra el articulo de latabla tmp_ventasR
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        try {
            Statement sta = conn.createStatement();
            String SQL = "DELETE FROM tmp_ventasr WHERE articulos_id = " + pVentaR_id;
            int fila = sta.executeUpdate(SQL);
            CON.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Elimino Detalle" + e.getMessage());
        }
    }

    public boolean Existe_Articulo_Id(int pArticulo_id) {
        Conexion CON;
        try {
            CON = new Conexion();
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select articulos_id from tmp_ventasr "
                    + " where articulos_id = " + pArticulo_id;
            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if( fila.next())
              return true;            
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Articulos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }    
    
    public float getTotal(){
        Conexion CON;
        try {
            CON = new Conexion();
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select sum(subtotal) as total from tmp_ventasr ";
                    
            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if( fila.next())
              return fila.getFloat(1);            
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Articulos.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return 0;
    }
    
    public int NuevaVenta(String pCliente){
        Conexion CON;
        try {
            CON = new Conexion();
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select uf_VentasAltas('" + pCliente+"')";
            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if( fila.next())
              return fila.getInt(1);            
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Articulos.class.getName()).log(Level.SEVERE, null, ex);            
            
        }
        
        return -1;
    }    
            
}
