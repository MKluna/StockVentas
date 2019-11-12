/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Huguito Barros
 */
public class Articulos {
     private int articulo_id;
     private String articulo;
     private float precio;
     private String codigobarra;
     private int marca_id;
     private int rubro_id;
     private int Cantidad;

     
     
    public Articulos() {
    }

     
    
     
    public Articulos(int articulo_id, String articulo, float precio, String codigobarra, int marca_id, int rubro_id) {
        this.articulo_id = articulo_id;
        this.articulo = articulo;
        this.precio = precio;
        this.codigobarra = codigobarra;
        this.marca_id = marca_id;
        this.rubro_id = rubro_id;
    }

    public int getArticulo_id() {
        return articulo_id;
    }

    public void setArticulo_id(int articulo_id) {
        this.articulo_id = articulo_id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public int getRubro_id() {
        return rubro_id;
    }

    public void setRubro_id(int rubro_id) {
        this.rubro_id = rubro_id;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
     
     
     
    

    
}
