package CapaDatos;

public class Venta {

    private int idventa;
    private String vFecha;
    private String vDocumento;
    private String vCorrelativo;
    private double vTotalPagar;
    private double vPago;
    private double vVuelto;
    private String FormaPago;
    private String vMoneda;
    private String cliRucDni;
    private String uDni;
    private String estado;

    public Venta() {
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getvFecha() {
        return vFecha;
    }

    public void setvFecha(String vFecha) {
        this.vFecha = vFecha;
    }

    public String getvDocumento() {
        return vDocumento;
    }

    public void setvDocumento(String vDocumento) {
        this.vDocumento = vDocumento;
    }

    public String getvCorrelativo() {
        return vCorrelativo;
    }

    public void setvCorrelativo(String vCorrelativo) {
        this.vCorrelativo = vCorrelativo;
    }

    public double getvTotalPagar() {
        return vTotalPagar;
    }

    public void setvTotalPagar(double vTotalPagar) {
        this.vTotalPagar = vTotalPagar;
    }

    public double getvPago() {
        return vPago;
    }

    public void setvPago(double vPago) {
        this.vPago = vPago;
    }

    public double getvVuelto() {
        return vVuelto;
    }

    public void setvVuelto(double vVuelto) {
        this.vVuelto = vVuelto;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public String getvMoneda() {
        return vMoneda;
    }

    public void setvMoneda(String vMoneda) {
        this.vMoneda = vMoneda;
    }

    public String getCliRucDni() {
        return cliRucDni;
    }

    public void setCliRucDni(String cliRucDni) {
        this.cliRucDni = cliRucDni;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

}
