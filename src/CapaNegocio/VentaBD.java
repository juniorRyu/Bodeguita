package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public int registrarVenta(Venta v) {
        int idventa = 0;
        sql = "INSERT INTO venta(idventa,vFecha,vDocumento,vCorrelativo,vTotalPagar,vPago,vVuelto,vFormaPago,vMoneda,cliRucDni,uDni,estado) VALUES(0,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, v.getvFecha());
            pst.setString(2, v.getvDocumento());
            pst.setString(3, v.getvCorrelativo());
            pst.setDouble(4, v.getvTotalPagar());
            pst.setDouble(5, v.getvPago());
            pst.setDouble(6, v.getvVuelto());
            pst.setString(7, v.getFormaPago());
            pst.setString(8, v.getvMoneda());
            pst.setString(9, v.getCliRucDni());
            pst.setString(10, v.getuDni());
            pst.setString(11, v.getEstado());

            pst.executeUpdate();

            ResultSet resultado = (ResultSet) pst.getGeneratedKeys();
            if (resultado.next()) {
                idventa = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar venta", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
        return idventa;
    }

    public DefaultTableModel reportarVenta() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "FORMAPAGO", "MONEDA", "CLIENTE", "VENDEDOR"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor FROM venta AS v "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "INNER JOIN cliente AS c ON v.cliRucDni=c.cliRucDni";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("cliente");
                registros[8] = rs.getString("vendedor");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public DefaultTableModel buscarVenta(String nroDocumento, String fecha, String documento) {
        DefaultTableModel modelo;
        String[] titulos = {"ID_VENTA", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "FORMAPAGO", "MONEDA", "SERIE", "DESCRIPCION", "CANT", "PRECIO", "IMPORTE", "DNI_CLIENTE", "CLIENTE", "VENDEDOR", "TELEFONO"};
        String[] registros = new String[16];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT v.idventa AS id_venta,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,dv.pSerie AS serie,pDescripcion,cant,precio,importe,c.cRucDni AS dni_cliente,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor,cliCelular FROM venta AS v "
                + "INNER JOIN detalleventa AS dv ON v.idventa=dv.idventa "
                + "INNER JOIN producto AS p ON dv.pSerie=p.pSerie "
                + "INNER JOIN cliente AS c ON v.cliRucDni=c.cliRucDni "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "WHERE vCorrelativo='" + nroDocumento + "' AND vFecha='" + fecha + "' AND vDocumento='" + documento + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("id_venta");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("serie");
                registros[8] = rs.getString("pDescripcion");
                registros[9] = rs.getString("cant");
                registros[10] = rs.getString("precio");
                registros[11] = rs.getString("importe");
                registros[12] = rs.getString("dni_cliente");
                registros[13] = rs.getString("cliente");
                registros[14] = rs.getString("vendedor");
                registros[15] = rs.getString("cliCelular");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean actualizarEstadoVenta(Venta v) {
        sql = "UPDATE venta SET vFormaPago=? WHERE idventa=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, v.getFormaPago());
            pst.setInt(2, v.getIdventa());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarVentaFecha(String fechaInicio, String fechaFinal) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "FORMAPAGO", "MONEDA", "CLIENTE", "VENDEDOR"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor FROM venta AS v "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "INNER JOIN cliente AS c ON v.cliRucDni=c.cliRucDni "
                + "WHERE vFecha BETWEEN '" + fechaInicio + "' AND '" + fechaFinal + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("cliente");
                registros[8] = rs.getString("vendedor");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public DefaultTableModel reportarVentaEstado(String estado) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "FORMAPAGO", "MONEDA", "CLIENTE", "VENDEDOR"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor FROM venta AS v "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "INNER JOIN cliente AS c ON v.cDni=c.cDni "
                + "WHERE vFormaPago = '" + estado + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("cliente");
                registros[8] = rs.getString("vendedor");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public DefaultTableModel buscarVentaDocumento(String documento) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "FORMAPAGO", "MONEDA", "CLIENTE", "VENDEDOR"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor FROM venta AS v "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "INNER JOIN cliente AS c ON v.cliRucDni=c.cliRucDni "
                + "WHERE vDocumento = '" + documento + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("cliente");
                registros[8] = rs.getString("vendedor");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public DefaultTableModel buscarVentaTipo(String tipo_venta) {
        DefaultTableModel modelo;
        String[] titulos = {"ID_VENTA", "CORRELATIVO", "DOCUMENTO", "FECHA", "TOTAL", "TIPO", "ESTADO", "CLIENTE", "VENDEDOR"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,vCorrelativo,vDocumento,vFecha,vTotalPagar,vFormaPago,vMoneda,cliDatos AS cliente,CONCAT(uApellidos,' ',uNombre) AS vendedor FROM venta AS v "
                + "INNER JOIN usuario AS u ON v.uDni=u.uDni "
                + "INNER JOIN cliente AS c ON v.cliRucDni=c.cliRucDni "
                + "WHERE tipo='" + tipo_venta + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("vCorrelativo");
                registros[2] = rs.getString("vDocumento");
                registros[3] = rs.getString("vFecha");
                registros[4] = rs.getString("vTotalPagar");
                registros[5] = rs.getString("vFormaPago");
                registros[6] = rs.getString("vMoneda");
                registros[7] = rs.getString("cliente");
                registros[8] = rs.getString("vendedor");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
