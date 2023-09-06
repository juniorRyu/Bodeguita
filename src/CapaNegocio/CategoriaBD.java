package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoriaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarCategoria(Categoria ca) {
        sql = "INSERT INTO categoria(idcategoria,caNombre) VALUES(0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ca.getCaNombre());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarCategoria() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idcategoria,caNombre FROM categoria";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idcategoria");
                registros[1] = rs.getString("caNombre");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar categoria...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean modificarCategoria(Categoria ca) {
        sql = "UPDATE categoria SET caNombre=? where idcategoria=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, ca.getCaNombre());

            pst.setInt(2, ca.getIdcategoria());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }

    public boolean eliminarCategoria(int codigo) {
        sql = "delete from categoria where idcategoria='" + codigo + "'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel buscarCategoria(String valor) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idcategoria,caNombre FROM categoria WHERE caNombre LIKE '%" + valor + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idcategoria");
                registros[1] = rs.getString("caNombre");
                

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar categoria...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
