/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author WALTER
 */
public class Deuda {
    
    int iddeuda;
    String cliRucDni;
    double totalDeuda;
    double acuenta;
    double saldo;
    String fechaApertura;
    String fechacierre;
    String estado;

    public Deuda() {
    }

    public int getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(int iddeuda) {
        this.iddeuda = iddeuda;
    }

    public String getCliRucDni() {
        return cliRucDni;
    }

    public void setCliRucDni(String cliRucDni) {
        this.cliRucDni = cliRucDni;
    }

    public double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public double getAcuenta() {
        return acuenta;
    }

    public void setAcuenta(double acuenta) {
        this.acuenta = acuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(String fechacierre) {
        this.fechacierre = fechacierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
