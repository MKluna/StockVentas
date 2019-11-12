package entidades;


public class Rubros {
  private int rubro_id;
  private String rubro;

    public Rubros() {
    }

    public Rubros(int rubro_id, String rubro) {
        this.rubro_id = rubro_id;
        this.rubro = rubro;
    }

    public int getRubro_id() {
        return rubro_id;
    }

    public void setRubro_id(int rubro_id) {
        this.rubro_id = rubro_id;
    }

    public String getRubro() {
        return rubro;
    }

      public void setRubro(String rubro) {
        this.rubro = rubro;
    }
  
  
}
