package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarUsuario(Usuario u) {
        sql = "INSERT INTO usuario(uDni,uNombre,uApellidos,uDireccion,uCelular,uTipo,uClave) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuDni());
            pst.setString(2, u.getuNombre());
            pst.setString(3, u.getuApellidos());
            pst.setString(4, u.getuDireccion());
            pst.setString(5, u.getuCelular());
            pst.setString(6, u.getuTipo());
            pst.setString(7, u.getuClave());

            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel reportarUsuario() {
        DefaultTableModel modelo;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CELULAR", "TIPO"};
        String[] registros = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uCelular,uTipo FROM usuario";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uCelular");
                registros[5] = rs.getString("uTipo");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario...", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean modificarUsuario(Usuario u) {
        sql = "UPDATE usuario SET uNombre=?,uApellidos=?,uDireccion=?,uCelular=?,uTipo=?,uClave=? where uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuNombre());
            pst.setString(2, u.getuApellidos());
            pst.setString(3, u.getuDireccion());
            pst.setString(4, u.getuCelular());
            pst.setString(5, u.getuTipo());
            pst.setString(6, u.getuClave());
            pst.setString(7, u.getuDni());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return true;
    }

    public boolean eliminarUsuario(String dni) {
        sql = "delete from usuario where uDni='" + dni + "'";
        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public List<Usuario> login(String dni, String clave) {
        List<Usuario> lista = new ArrayList<>();
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uTipo FROM usuario WHERE uDni='" + dni + "' AND uClave='" + clave + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Usuario objeto_usuario = new Usuario();
                objeto_usuario.setuDni(rs.getString(1));
                objeto_usuario.setuNombre(rs.getString(2));
                objeto_usuario.setuApellidos(rs.getString(3));
                objeto_usuario.setuDireccion(rs.getString(4));
                objeto_usuario.setuTipo(rs.getString(5));

                lista.add(objeto_usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en el login", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public DefaultTableModel buscarUsuario(String apellidos) {
        DefaultTableModel modelo;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CELULAR", "TIPO", "CLAVE"};
        String[] registros = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uCelular,uTipo,uClave FROM usuario WHERE uApellidos LIKE '%" + apellidos + "%' OR uNombre LIKE '%" + apellidos + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uCelular");
                registros[5] = rs.getString("uTipo");
                registros[6] = rs.getString("uClave");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
