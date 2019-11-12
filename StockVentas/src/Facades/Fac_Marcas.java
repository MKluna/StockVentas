/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import entidades.Conexion;
import entidades.Marcas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Fac_Marcas {

    public void NuevaMarca(Marcas pMarca) throws SQLException {
        try {
            Conexion conexion = new Conexion();
            try (Connection conn = conexion.getConnection()) {
                Statement sta = conn.createStatement();
                String SQL = " INSERT INTO marcas( marca) "
                        + " VALUES ( '" + pMarca.getMarca() + "')";
                int fila = sta.executeUpdate(SQL);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "Metodo Fac_Marcas.NuevaMarca");
        }
    }

    public void EliminarMarca(int pMarca_id) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        try {
            Statement sta = conn.createStatement();
            String SQL = "DELETE FROM marcas WHERE marca_id = " + pMarca_id;
            int fila = sta.executeUpdate(SQL);
            conexion.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Elimino Marca" + e.getMessage());
        }
    }

    public void EditarMarca(Marcas pMarca) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        try {   // , , 
            Statement sta = conn.createStatement();
            String SQL = " UPDATE marcas set marca= '" + pMarca.getMarca() + "'"
                    + " WHERE marca_id = " + pMarca.getMarca_id();
            int fila = sta.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            conexion.Close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " No se Modifico " + e.getMessage());
        }
    }

    public Marcas ObtenerMarcas(int pMarca_id) throws SQLException {
        Marcas objmarcas = new Marcas();
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        Statement sta = conn.createStatement();
        String SQL = "Select  marca"
                + " from Marcas "
                + " where marca_id = " + pMarca_id;
        ResultSet fila = conn.createStatement().executeQuery(SQL);
        if (fila.next()) {
            objmarcas.setMarca_id(pMarca_id);
            objmarcas.setMarca(fila.getString(1));
        } else {
            return null;
        }
        return objmarcas;
    }

    public void BuscarMarca(String Campo_id, JFormattedTextField Valor_id, JLabel Descripcion) throws SQLException {
        Marcas objmarcas = new Marcas();
        if (Campo_id == null || Campo_id.isEmpty()) {
            return;
        }
        if (Valor_id == null || Valor_id.getText().isEmpty()) {
            return;
        } else {
            int valor = Integer.valueOf(Valor_id.getText());
            objmarcas = ObtenerMarcas(valor);
            if (objmarcas != null) {
                Descripcion.setText(objmarcas.getMarca_id() + " " + objmarcas.getMarca());
            } else {
                Valor_id.setText("");
                Descripcion.setText("");
            }
        }
    }

    public boolean ExisteMarca(String pMarca) {
        Conexion conexion;
        try {
            conexion = new Conexion();
            Connection conn = conexion.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select  marca from marcas "
                    + " where upper(trim(marca)) like trim('" + pMarca + "')";

            ResultSet fila = conn.createStatement().executeQuery(SQL);
            return fila.next();
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Marcas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String ExisteMarca_Id(int pMarca_id) {
        Conexion conexion;
        try {
            conexion = new Conexion();
            Connection conn = conexion.getConnection();
            Statement sta = conn.createStatement();
            String SQL = "Select  marca from marcas "
                    + " where marca_id = " + pMarca_id;

            ResultSet fila = conn.createStatement().executeQuery(SQL);
            if (fila.next())
              return fila.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Fac_Marcas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public List<Marcas> ListadoMarcas() throws SQLException {
        List<Marcas> ListadoMarcas = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        Statement sta = conn.createStatement();
        String SQL = "Select marca_id"
                + " from marcas "
                + " order by marca";
        ResultSet fila = conn.createStatement().executeQuery(SQL);

        while (fila.next()) {
            ListadoMarcas.add(ObtenerMarcas(fila.getInt(1)));
        }
        return ListadoMarcas;
    }
}
