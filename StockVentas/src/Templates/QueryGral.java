/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Templates;


import entidades.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class QueryGral {

    private static String Tabla;
    private static String Campo_id;
    private static String campo_des;
    private static String valor_id;
    private static String valor_des;

    private static String ColumName1;
    private static String ColumName2;

    private static String filtro = "";

    public QueryGral() {

    }

    public QueryGral(String Tabla, String Campo_id, String campo_des) {
        QueryGral.Tabla = Tabla;
        QueryGral.Campo_id = Campo_id;
        QueryGral.campo_des = campo_des;
    }

    public QueryGral(String Tabla, String Campo_id, String campo_des, String filtro) {
        QueryGral.Tabla = Tabla;
        QueryGral.Campo_id = Campo_id;
        QueryGral.campo_des = campo_des;
        QueryGral.filtro = filtro;
    }

    public String getTabla() {
        return Tabla;
    }

    public void setTabla(String Tabla) {
        this.Tabla = Tabla;
    }

    public String getCampo_id() {
        return Campo_id;
    }

    public void setCampo_id(String Campo_id) {
        this.Campo_id = Campo_id;
    }

    public String getCampo_des() {
        return campo_des;
    }

    public void setCampo_des(String campo_des) {
        this.campo_des = campo_des;
    }

    public String getValor_id() {
        return valor_id;
    }

    public void setValor_id(String aValor_id) {
        valor_id = aValor_id;
    }

    public String getValor_des() {
        return valor_des;
    }

    public void setValor_des(String aValor_des) {
        valor_des = aValor_des;
    }

    public ResultSet PrepararConsulta() throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        Statement sta = conn.createStatement();
        String SQL;
        if (filtro.isEmpty()) {
            SQL = "Select " + getCampo_id() + ", " + getCampo_des()
                    + " from " + getTabla()
                    + " order by " + getCampo_des();
        } else {
            SQL = "Select " + getCampo_id() + ", " + getCampo_des()
                    + " from " + getTabla()
                    + " " + filtro
                    + " order by " + getCampo_des();
        }

        ResultSet fila = conn.createStatement().executeQuery(SQL);
        return fila;
    }

    public String getColumName1() {
        return ColumName1;
    }

    public void setColumName1(String aColumName1) {
        ColumName1 = aColumName1;
    }

    public String getColumName2() {
        return ColumName2;
    }

    public void setColumName2(String aColumName2) {
        ColumName2 = aColumName2;
    }

}
