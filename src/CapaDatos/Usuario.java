
package CapaDatos;

public class Usuario {
    
    private String uDni;
    private String uNombre;
    private String uApellidos;
    private String uDireccion;
    private String uCelular;
    private String uTipo;
    private String uClave;

    public Usuario() {
    }

    public Usuario(String uDni, String uNombre, String uApellidos, String uDireccion, String uCelular, String uTipo, String uClave) {
        this.uDni = uDni;
        this.uNombre = uNombre;
        this.uApellidos = uApellidos;
        this.uDireccion = uDireccion;
        this.uCelular = uCelular;
        this.uTipo = uTipo;
        this.uClave = uClave;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getuNombre() {
        return uNombre;
    }

    public void setuNombre(String uNombre) {
        this.uNombre = uNombre;
    }

    public String getuApellidos() {
        return uApellidos;
    }

    public void setuApellidos(String uApellidos) {
        this.uApellidos = uApellidos;
    }

    public String getuDireccion() {
        return uDireccion;
    }

    public void setuDireccion(String uDireccion) {
        this.uDireccion = uDireccion;
    }

    public String getuCelular() {
        return uCelular;
    }

    public void setuCelular(String uCelular) {
        this.uCelular = uCelular;
    }

    public String getuTipo() {
        return uTipo;
    }

    public void setuTipo(String uTipo) {
        this.uTipo = uTipo;
    }

    public String getuClave() {
        return uClave;
    }

    public void setuClave(String uClave) {
        this.uClave = uClave;
    }

    

    
    
}
