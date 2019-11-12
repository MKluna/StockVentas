/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;


import entidades.Conexion;
import entidades.Rubros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Huguito Barros
 */
public class Fac_Rubros {
    
    
    
    //AGREGAR RUBRO
    public void NuevoRubros (Rubros P_Rubros)throws SQLException {
        
        try {
            
            Conexion CON = new Conexion();
            
            try (Connection conn = CON.getConnection())
              {
                Statement sta = conn.createStatement();
                
                String SQL = " INSERT INTO rubros(rubro) "
                        + " VALUES ( '" + P_Rubros.getRubro() + "')";
                int fila = sta.executeUpdate(SQL);
               }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
}
    
 
    public void Eliminar_Rubros(int P_Rubros_id) throws SQLException {
            
        Conexion CON = new Conexion();
        
        Connection conn = CON.getConnection();

        try {
            Statement sta = conn.createStatement();
            String SQL = "DELETE FROM rubros WHERE rubro_id = " + P_Rubros_id;
            int fila = sta.executeUpdate(SQL);
            CON.Close();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Elimino Rubros" + e.getMessage());
        }
    }
    
    
    
    //ESDITAMOS UNA MARCA 
    public void EditarRubro(Rubros P_Rubros) throws SQLException {
        
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        try {
            
            Statement sta = conn.createStatement();
            String SQL = " UPDATE rubros set rubro= '" + P_Rubros.getRubro() + "'"
                    + " WHERE rubro_id = " + P_Rubros.getRubro_id();
            
            int fila = sta.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            CON.Close();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " No se Modifico " + e.getMessage());
        }
    }  

    public Rubros ObtenerRubros(int P_Rubro_id) throws SQLException {
        
        Rubros obj_Rubros = new Rubros();        
        Conexion CON = new Conexion();        
        Connection conn = CON.getConnection();
        Statement sta = conn.createStatement();
        String SQL = "Select  rubro"
                + " from Rubros "
                + " where rubro_id = " + P_Rubro_id;
        ResultSet fila = conn.createStatement().executeQuery(SQL);        
        if (fila.next()) {
            obj_Rubros.setRubro_id(P_Rubro_id);
            obj_Rubros.setRubro(fila.getString(1));
            
        } else 
        {
            return null;
        }
        return obj_Rubros;
    }    
    
     //BUSCAMOS UN RUBRO
    
    public void BuscarRubros(String Campo_id, JFormattedTextField Valor_id, JLabel Descripcion) throws SQLException {        
        Rubros obj_Rubro = new Rubros();        
        if (Campo_id == null || Campo_id.isEmpty()) {
            return;
        }
        if (Valor_id == null || Valor_id.getText().isEmpty()) 
        {
            return;
        } 
          else 
            {
            int valor = Integer.valueOf(Valor_id.getText());
            obj_Rubro = ObtenerRubros(valor);
            
                if (obj_Rubro != null) 
                {
                Descripcion.setText(obj_Rubro.getRubro_id() + " " + obj_Rubro.getRubro());
                
                } else 
                     {
                       Valor_id.setText("");
                       Descripcion.setText("");
                     }
            
            }
    }
    

     //COMPROBAMOS SI YA EXISTE UN RUBRO
    
    public boolean ExisteRubro_Des(String P_Rubro) {
        Conexion CON;
        try {
            CON = new Conexion();
            
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select  rubro from rubros "
                    + " where upper(trim(rubro)) like trim('" + P_Rubro + "')";

            ResultSet fila = conn.createStatement().executeQuery(SQL);
            return fila.next();
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String ExisteRubro_Id(int pRubro_id) {
        Conexion CON;
        try {
            CON = new Conexion();
            
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select  upper(rubro) from rubros "
                    + " where rubro_id = "+pRubro_id;

            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if (fila.next())
                return fila.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    //MOSTRAMOS LA LISTA DE MARCAS
    
      public java.util.List<Rubros> Listado_Rubros() throws SQLException {
          
        java.util.List<Rubros> Listado_Rubros = new ArrayList<>();        
        Conexion CON = new Conexion();        
        Connection conexion_tabla = CON.getConnection();
        Statement sta = conexion_tabla.createStatement();        
        String SQL = "Select rubro_id"
                + " from rubros "
                + " order by rubro";        
        ResultSet resultado = conexion_tabla.createStatement().executeQuery(SQL);
        while (resultado.next()) {                       
            Listado_Rubros.add(ObtenerRubros(resultado.getInt(1)));            
        }
        return Listado_Rubros;
    }  
    
}

