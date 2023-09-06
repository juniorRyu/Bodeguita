
package CapaDatos;

public class Marca {
    
    private int idmarca;
    private String maNombre;

    public Marca() {
    }

    
    
    public Marca(int idmarca, String maNombre) {
        this.idmarca = idmarca;
        this.maNombre = maNombre;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getMaNombre() {
        return maNombre;
    }

    public void setMaNombre(String maNombre) {
        this.maNombre = maNombre;
    }
   
    

}
