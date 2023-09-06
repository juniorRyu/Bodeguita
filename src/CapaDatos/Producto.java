package CapaDatos;

public class Producto {

    private String pSerie;
    private String pDescripcion;
    private int pStock;
    private double pPrecio;
    private String pFechaVcto;
    private int idcategoria;
    private int idmarca;
    private int idmedida;

    public Producto() {
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public String getpDescripcion() {
        return pDescripcion;
    }

    public void setpDescripcion(String pDescripcion) {
        this.pDescripcion = pDescripcion;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public double getpPrecio() {
        return pPrecio;
    }

    public void setpPrecio(double pPrecio) {
        this.pPrecio = pPrecio;
    }

    public String getpFechaVcto() {
        return pFechaVcto;
    }

    public void setpFechaVcto(String pFechaVcto) {
        this.pFechaVcto = pFechaVcto;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

}
