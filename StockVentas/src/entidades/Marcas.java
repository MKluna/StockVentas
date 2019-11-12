package entidades;

public class Marcas {
  
  private int marca_id;
  private String marca;

    public Marcas() {
    }

    public Marcas(int marca_id, String marca) {
        this.marca_id = marca_id;
        this.marca = marca;
    }

    /**
     * @return the marca_id
     */
    public int getMarca_id() {
        return marca_id;
    }

    /**
     * @param marca_id the marca_id to set
     */
    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
  
  
}
