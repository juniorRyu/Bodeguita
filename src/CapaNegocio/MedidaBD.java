/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WALTER
 */
public class MedidaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarMedida() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "PRESENTACION", "EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmedida,mPresentacion,mEquivalencia FROM medida";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar medida...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

}
