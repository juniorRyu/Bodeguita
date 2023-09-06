package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarProducto(Producto p) {
        sql = "INSERT INTO producto(pSerie,pDescripcion,pStock,pPrecio,pFechaVcto,idcategoria,idmarca,idmedida) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getpSerie());
            pst.setString(2, p.getpDescripcion());
            pst.setDouble(3, p.getpStock());
            pst.setDouble(4, p.getpPrecio());
            pst.setString(5, p.getpFechaVcto());
            pst.setInt(6, p.getIdcategoria());
            pst.setInt(7, p.getIdmarca());
            pst.setInt(8, p.getIdmedida());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarProducto() {
        DefaultTableModel modelo;
        String[] titulos = {"SERIE", "DESCRIPCION", "PRESENTACION", "PRECIO", "STOCK", "FECHA_VCTO", "MARCA", "CATEGORIA"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT pSerie,pDescripcion,mPresentacion,pPrecio,pStock,pFechaVcto,maNombre AS marca,caNombre AS categoria FROM producto AS p "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN categoria AS c ON p.idcategoria=c.idcategoria";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("mPresentacion");
                registros[3] = rs.getString("pPrecio");
                registros[4] = rs.getString("pStock");
                registros[5] = rs.getString("pFechaVcto");
                registros[6] = rs.getString("marca");
                registros[7] = rs.getString("categoria");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar marca...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean modificarProducto(Producto p) {
        sql = "UPDATE producto SET pDescripcion=?,pPrecio=?,pStock=?,pFechaVcto=?,idmarca=?,idcategoria=?,idmedida=? WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, p.getpDescripcion());
            pst.setDouble(2, p.getpPrecio());
            pst.setInt(3, p.getpStock());
            pst.setString(4, p.getpFechaVcto());
            pst.setInt(5, p.getIdmarca());
            pst.setInt(6, p.getIdcategoria());
            pst.setInt(7, p.getIdmedida());
            pst.setString(8, p.getpSerie());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }

    public boolean eliminarProducto(String serie) {
        sql = "DELETE FROM producto WHERE pSerie='" + serie + "'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel buscarProducto(String serie) {
        DefaultTableModel modelo;
        String[] titulos = {"SERIE", "DESCRIPCION", "PRESENTACION", "PRECIO", "STOCK", "FECHA_VCTO", "MARCA", "CATEGORIA"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT pSerie,pDescripcion,mPresentacion,pPrecio,pStock,pFechaVcto,maNombre AS marca,caNombre AS categoria FROM producto AS p "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN categoria AS c ON p.idcategoria=c.idcategoria WHERE pSerie='" + serie + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("mPresentacion");
                registros[3] = rs.getString("pPrecio");
                registros[4] = rs.getString("pStock");
                registros[5] = rs.getString("pFechaVcto");
                registros[6] = rs.getString("marca");
                registros[7] = rs.getString("categoria");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar producto...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean actualizarStockProducto(Producto p) {
        sql = "UPDATE producto SET pStock=? WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, p.getpStock());
            pst.setString(2, p.getpSerie());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }

    public DefaultTableModel reporteProductosMultiple(String descripcion, String marca, String categoria, String presentacion) {
        DefaultTableModel modelo;
        String[] titulos = {"SERIE", "DESCRIPCION", "PRESENTACION", "PRECIO", "STOCK", "FECHA_VCTO", "MARCA", "CATEGORIA"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT pSerie,pDescripcion,mPresentacion,pPrecio,pStock,pFechaVcto,caNombre,maNombre FROM producto AS p "
                + "INNER JOIN categoria AS c ON p.idcategoria=c.idcategoria "
                + "INNER JOIN medida AS me ON p.idmedida=me.idmedida "
                + "INNER JOIN marca AS m ON p.idmarca=m.idmarca "
                + "WHERE pDescripcion LIKE '%" + descripcion + "%' OR caNombre='" + categoria + "' OR  maNombre='" + marca + "' OR mPresentacion='" + presentacion + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("mPresentacion");
                registros[3] = rs.getString("pPrecio");
                registros[4] = rs.getString("pStock");
                registros[5] = rs.getString("pFechaVcto");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("caNombre");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar producto...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

}
