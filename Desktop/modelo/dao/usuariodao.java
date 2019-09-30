/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import coneccao.connectionfactory;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.usuario;

/**
 *
 * @author victor tesoura jr
 */
public class usuariodao {

    private Connection con = null;

    public usuariodao() {
        con = connectionfactory.getConnection();
    }

    public boolean verificar(int codigo, String tipo) throws UnsupportedEncodingException {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;
        List<usuario> usuarios = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nup=? and tipo=?");
            stmt.setInt(1, codigo);
            stmt.setString(2, tipo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(autoridadedao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return check;
    }

    public void cadastrar(usuario usuario) throws UnsupportedEncodingException {
        String sql = "INSERT INTO usuario (nup,senha,tipo) VALUES (?,SHA1(?),?)";
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getCodigo());
            stmt.setString(2, usuario.getsenha());
            stmt.setString(3, usuario.gettipo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    public List<usuario> visualizarusuario() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setCodigo(rs.getInt("nup"));
                usuario.settipo(rs.getString("tipo"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return usuarios;
    }

    public List<usuario> visualizarcontrole() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM controle");
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setCodigo(rs.getInt("nup"));
                usuario.setsenha(rs.getString("data"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return usuarios;
    }

    public boolean editar(usuario usuario) {
        String sql = "UPDATE usuario SET senha=SHA1(?) WHERE nup=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getsenha());
            stmt.setInt(2, usuario.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public List<usuario> procurar(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nup LIKE ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setCodigo(rs.getInt("nup"));
                usuario.settipo(rs.getString("tipo"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return usuarios;
    }
}
