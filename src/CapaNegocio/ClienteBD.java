package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Cliente;
import CapaDatos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WALTER
 */
public class ClienteBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarCliente(Cliente c) {
        sql = "INSERT INTO cliente(cliRucDni,cliDatos,cliDireccion,cliCelular,cliCorreo) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCliRucDni());
            pst.setString(2, c.getCliDatos());
            pst.setString(3, c.getCliDireccion());
            pst.setString(4, c.getCliCelular());
            pst.setString(5, c.getCliCorreo());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarCliente() {
        DefaultTableModel modelo;
        String[] titulos = {"DNI", "DATOS", "DIRECCIÓN", "CELULAR", "CORREO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT cliRucDni,cliDatos,cliDireccion,cliCelular,cliCorreo FROM cliente";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("cliRucDni");
                registros[1] = rs.getString("cliDatos");
                registros[2] = rs.getString("cliDireccion");
                registros[3] = rs.getString("cliCelular");
                registros[4] = rs.getString("cliCorreo");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar cliente...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean modificarCliente(Cliente c) {
        sql = "UPDATE cliente SET cliDatos=?,cliDireccion=?,cliCelular=?,cliCorreo=? where cliRucDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCliDatos());
            pst.setString(2, c.getCliDireccion());
            pst.setString(3, c.getCliCelular());
            pst.setString(4, c.getCliCorreo());
            pst.setString(5, c.getCliRucDni());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }

    public boolean eliminarCliente(String dni) {
        sql = "delete from cliente where cliRucDni='" + dni + "'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel buscarCliente(String dni) {
        DefaultTableModel modelo;
        String[] titulos = {"DNI", "DATOS", "DIRECCIÓN", "CELULAR", "CORREO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT cliRucDni,cliDatos,cliDireccion,cliCelular,cliCorreo FROM cliente WHERE cliRucDni='" + dni + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                registros[0] = rs.getString("cliRucDni");
                registros[1] = rs.getString("cliDatos");
                registros[2] = rs.getString("cliDireccion");
                registros[3] = rs.getString("cliCelular");
                registros[4] = rs.getString("cliCorreo");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar cliente...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

}
