package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MarcaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarMarca(Marca m) {
        boolean rpta = false;
        sql = "INSERT INTO marca(idmarca,maNombre) VALUES(0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getMaNombre());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar MarcaBD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }

        return rpta;
    }

    public DefaultTableModel reportarMarca() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[3];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idmarca,maNombre FROM marca";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmarca");
                registros[1] = rs.getString("maNombre");

                tabla_temporal.addRow(registros);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar marcaBD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return tabla_temporal;

    }

    public boolean modificarMarca(Marca m) {
        boolean rpta = false;
        sql = "UPDATE marca SET maNombre=? where idmarca=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, m.getMaNombre());
            pst.setInt(2, m.getIdmarca());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarMarca(int codigo) {
        boolean rpta = false;
        
        sql = "DELETE FROMA marca WHERE idmarca='" + codigo + "'";
        try {
            Statement st = cn.createStatement();

            rpta = st.executeUpdate(sql) == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarMarca(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmarca,maNombre FROM marca WHERE maNombre LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmarca");
                registros[1] = rs.getString("maNombre");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar marca...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
