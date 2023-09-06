package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleVenta;
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
public class DetalleVentaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleVenta(DetalleVenta dt) {
        sql = "INSERT INTO detalleventa(idventa,pSerie,cant,precio,importe) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dt.getIdventa());
            pst.setString(2, dt.getpSerie());
            pst.setInt(3, dt.getCant());
            pst.setDouble(4, dt.getPrecio());
            pst.setDouble(5, dt.getImporte());
            

            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Detalle de ventas", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public DefaultTableModel buscarDetalleVenta(int idventa) {
        DefaultTableModel modelo;
        String[] titulos = {"ID_VENTA", "SERIE", "DESCRIPCION", "PRESENTACION", "CANT", "PRECIO", "IMPORTE", "MARCA", "CATEGORIA"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,p.pSerie AS serie,pDescripcion,pPresentacion,cant,precio,importe,maNombre,caNombre FROM detalleventa as dv "
                + "INNER JOIN producto as p ON dv.pSerie=p.pSerie "
                + "INNER JOIN marca as m ON p.idmarca=m.idmarca "
                + "INNER JOIN categoria as c ON p.idcategoria=c.idcategoria "
                + "WHERE idventa=" + idventa + "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("serie");
                registros[2] = rs.getString("pDescripcion");
                registros[3] = rs.getString("pPresentacion");
                registros[4] = rs.getString("cant");
                registros[5] = rs.getString("precio");
                registros[6] = rs.getString("importe");
                registros[7] = rs.getString("maNombre");
                registros[8] = rs.getString("caNombre");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar ventas...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
