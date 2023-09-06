/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Cliente;
import CapaDatos.Deuda;
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
public class DeudaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDeuda(Deuda d) {
        sql = "INSERT INTO deuda(iddeuda,cliRucDni,totalDeuda,acuenta,saldo,fechaApertura,fechacierre,estado) VALUES(0,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, d.getCliRucDni());
            pst.setDouble(2, d.getTotalDeuda());
            pst.setDouble(3, d.getAcuenta());
            pst.setDouble(4, d.getSaldo());
            pst.setString(5, d.getFechaApertura());
            pst.setString(6, d.getFechacierre());
            pst.setString(7, d.getEstado());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarDeuda() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "RUC_DNI", "CLIENTE", "TOTAL_DEUDA", "ACUENTA", "SALDO", "FECHA_APERTURA", "FECHA_CIERRE", "ESTADO"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT iddeuda,c.cliRucDni AS dni_ruc,cliDatos,totalDeuda,acuenta,saldo,fechaApertura,fechacierre,estado FROM deuda AS d "
                + "INNER JOIN cliente AS c ON d.cliRucDni=c.cliRucDni";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("iddeuda");
                registros[1] = rs.getString("dni_ruc");
                registros[2] = rs.getString("cliDatos");
                registros[3] = rs.getString("totalDeuda");
                registros[4] = rs.getString("acuenta");
                registros[5] = rs.getString("saldo");
                registros[6] = rs.getString("fechaApertura");
                registros[7] = rs.getString("fechacierre");
                registros[8] = rs.getString("estado");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar cliente...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public DefaultTableModel buscarDeuda(String cliRucDni, String estado) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "CLIENTE", "TOTAL|DEUDA", "ACUENTA", "SALDO", "FECHA|APERTURA", "FECHA|CIERRE", "ESTADO"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT iddeuda,cliDatos,totalDeuda,acuenta,saldo,fechaApertura,fechacierre,estado FROM deuda AS d "
                + "INNER JOIN cliente AS c ON d.cliRucDni=c.cliRucDni "
                + "WHERE d.cliRucDni='" + cliRucDni + "' AND estado='" + estado + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("iddeuda");
                registros[1] = rs.getString("cliDatos");
                registros[2] = rs.getString("totalDeuda");
                registros[3] = rs.getString("acuenta");
                registros[4] = rs.getString("saldo");
                registros[5] = rs.getString("fechaApertura");
                registros[6] = rs.getString("fechacierre");
                registros[7] = rs.getString("estado");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar cliente...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean actualizarDeuda(Deuda d) {
        sql = "UPDATE deuda SET totalDeuda=?,acuenta=?,saldo=?,fechacierre=?,estado=? where iddeuda=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setDouble(1, d.getTotalDeuda());
            pst.setDouble(2, d.getAcuenta());
            pst.setDouble(3, d.getSaldo());
            pst.setString(4, d.getFechacierre());
            pst.setString(5, d.getEstado());
            pst.setInt(6, d.getIddeuda());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al actualizar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
