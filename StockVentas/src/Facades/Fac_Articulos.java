/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import entidades.Articulos;
import entidades.Conexion;
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


public class Fac_Articulos {

    public void Nuevo_Articulo(Articulos P_Articulo) throws SQLException {
        try {
            Conexion CON = new Conexion();
            try (Connection conn = CON.getConnection()) {
                Statement sta = conn.createStatement();
                String SQL = "  INSERT INTO articulos(articulo, precio, marca_id, rubro_id, codigobarra, cantidad)"
                        + " VALUES ( '" + P_Articulo.getArticulo().trim() + "', "+P_Articulo.getPrecio()+", "+P_Articulo.getMarca_id()+", "+P_Articulo.getRubro_id()+", '"+P_Articulo.getCodigobarra()+"', "+P_Articulo.getCantidad()+")";
                int fila = sta.executeUpdate(SQL);
                CON.Close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Metodo facade_Articulos.NuevoArticulo");
        }
        
    }

    public void Eliminar_Articulos(int P_Articulos_id) throws SQLException {
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        try {
            Statement sta = conn.createStatement();
            String SQL = "DELETE FROM articulos WHERE articulo_id = " + P_Articulos_id;
            int fila = sta.executeUpdate(SQL);
            CON.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Elimino Articulo" + e.getMessage());
        }
    }
    
    public void Editar_Articulos(Articulos P_Articulos) throws SQLException {
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        try {
            Statement sta = conn.createStatement();
            String SQL = " UPDATE articulos " +
                     "     SET articulo= '"+P_Articulos.getArticulo()+"'"
                    + "    ,precio= "+P_Articulos.getPrecio()
                    + "    ,marca_id = "+P_Articulos.getMarca_id()
                    +"     ,rubro_id= "+P_Articulos.getRubro_id()
                    +"     ,codigobarra= '"+P_Articulos.getCodigobarra()+"'"
                    + "    ,cantidad="+ P_Articulos.getCantidad()
                    + "  where  articulo_id= "+P_Articulos.getArticulo_id();
            int fila = sta.executeUpdate(SQL);          
            CON.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " No se Modifico " + e.getMessage());
        }
    }

    
    public Articulos ObtenerArticulos(int P_Articulos_id) throws SQLException 
    {
        Articulos obj_Articulos = new Articulos();
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        Statement sta = conn.createStatement();
        String SQL = "Select articulo, precio, marca_id, rubro_id, codigobarra, cantidad "
                + " from articulos "
                + " where articulo_id = " + P_Articulos_id;
        ResultSet fila = conn.createStatement().executeQuery(SQL);
        if (fila.next()) {
            obj_Articulos.setArticulo_id(P_Articulos_id);
            obj_Articulos.setArticulo(fila.getString(1));
            obj_Articulos.setPrecio(fila.getFloat(2));
            obj_Articulos.setMarca_id(fila.getInt(3));
            obj_Articulos.setRubro_id(fila.getInt(4));
            obj_Articulos.setCodigobarra(fila.getString(5));
            obj_Articulos.setCantidad(fila.getInt(6));
        } else {
            return null;
        }
        return obj_Articulos;
    }

    public int ObtenerCantidad(int P_Articulos_id) throws SQLException {
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        Statement sta = conn.createStatement();
        String SQL = "Select  cantidad "
                + " from articulos "
                + " where articulo_id = " + P_Articulos_id;
        ResultSet fila = conn.createStatement().executeQuery(SQL);
        if (fila.next()) {
            return fila.getInt(1);
        }
        return -1;
    }

    public void Buscar_Articulos(String Campo_id, JFormattedTextField Valor_id, JLabel Descripcion) throws SQLException {
        Articulos obj_Articulos = new Articulos();
        if (Campo_id == null || Campo_id.isEmpty()) {
            return;
        }
        if (Valor_id == null || Valor_id.getText().isEmpty()) {
            return;
        } else {
            int valor = Integer.valueOf(Valor_id.getText());
            obj_Articulos = ObtenerArticulos(valor);

            if (obj_Articulos != null) {
                Descripcion.setText(obj_Articulos.getArticulo_id() + " " + obj_Articulos.getArticulo());

            } else {
                Valor_id.setText("");
                Descripcion.setText("");
            }
        }
    }
    
    public boolean Existe_Articulo_Des(String P_Articulos) {
        Conexion CON;
        try {
            CON = new Conexion();
            Connection conn = CON.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select  articulo_id from articulos "
                    + " where upper(trim(articulo)) like  upper(trim('" + P_Articulos + "'))";
System.out.println(SQL);
            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if (fila.next())
                return true;    
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Articulos.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return false;
    }
    
    public java.util.List<Articulos> Listado_Articulos() throws SQLException {
        java.util.List<Articulos> Listado_Articulos = new ArrayList<>();
        Conexion CON = new Conexion();
        Connection conexion_tabla = CON.getConnection();
        Statement sta = conexion_tabla.createStatement();
        String SQL = "Select articulo_id"
                + " from articulos "
                + " order by articulo";
        ResultSet resultado = conexion_tabla.createStatement().executeQuery(SQL);
        while (resultado.next()) {
            Listado_Articulos.add(ObtenerArticulos(resultado.getInt(1)));
        }
        return Listado_Articulos;
    }

    
    
    
    
    public Articulos ObtenerArticulos_CodBarra(String P_Cod_Barra) throws SQLException 
    {
        Articulos obj_Articulos = new Articulos();
        Conexion CON = new Conexion();
        Connection conn = CON.getConnection();
        Statement sta = conn.createStatement();
        String SQL = "Select articulo, precio, marca_id, rubro_id, codigobarra, cantidad , articulo_id "
                + " from articulos "
                + " where codigobarra = " + "'"+P_Cod_Barra+"'";
        ResultSet fila = conn.createStatement().executeQuery(SQL);
        if (fila.next()) {
            obj_Articulos.setArticulo(fila.getString(1)); 
       
           obj_Articulos.setPrecio(fila.getFloat(2));
           obj_Articulos.setMarca_id(fila.getInt(3));
            obj_Articulos.setRubro_id(fila.getInt(4));
            obj_Articulos.setCodigobarra(P_Cod_Barra);
            obj_Articulos.setCantidad(fila.getInt(6));
            obj_Articulos.setArticulo_id(fila.getInt(7));
        } else {
            return null;
        }
        return obj_Articulos;
        
    }
}
