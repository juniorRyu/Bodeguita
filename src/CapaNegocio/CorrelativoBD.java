package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Correlativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CorrelativoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarCorrelativo(Correlativo co) {
        sql = "INSERT INTO correlativo(idcorrelativo,coSerie,coNumeracion,coDocumento) VALUES(0,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, co.getCoSerie());
            pst.setString(2, co.getCoNumeracion());
            pst.setString(3, co.getCoDocumento());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarCorrelativo() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "SERIE", "NUMERACIÓN", "DOCUMENTO"};
        String[] registros = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idcorrelativo,coSerie,coNumeracion,coDocumento FROM correlativo";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idcorrelativo");
                registros[1] = rs.getString("coSerie");
                registros[2] = rs.getString("coNumeracion");
                registros[3] = rs.getString("coDocumento");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar correlativo...", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }

    }

    public boolean eliminarCorrelativo(int codigo) {
        sql = "delete from correlativo where idcorrelativo='" + codigo + "'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean modificarCorrelativo(Correlativo c) {
        sql = "UPDATE correlativo SET coSerie=?,coNumeracion=?,coDocumento=? where idcorrelativo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCoSerie());
            pst.setString(2, c.getCoNumeracion());
            pst.setString(3, c.getCoDocumento());
            pst.setInt(4, c.getCoCodigo());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Correlativo> sacarNro(String documento) {
        List<Correlativo> lista = new ArrayList<>();
        sql = "SELECT idcorrelativo,coSerie,coNumeracion,coDocumento FROM correlativo WHERE coDocumento='" + documento + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Correlativo objeto_correlativo = new Correlativo();
                objeto_correlativo.setCoSerie(rs.getString(2));
                objeto_correlativo.setCoNumeracion(rs.getString(3));
                objeto_correlativo.setCoDocumento(rs.getString(4));

                lista.add(objeto_correlativo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al sacar correlativo");
            e.printStackTrace();

        }
        return lista;
    }

    public boolean actualizarCorrelativo(Correlativo c) {
        sql = "UPDATE correlativo SET coNumeracion=? WHERE coDocumento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, c.getCoNumeracion());
            pst.setString(2, c.getCoDocumento());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
