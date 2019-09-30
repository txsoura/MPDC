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
import modelo.bean.autoridade;

/**
 *
 * @author victor tesoura jr
 */
public class autoridadedao {

    private Connection con = null;

    public autoridadedao() {
        con = connectionfactory.getConnection();
    }

    public boolean verificar(int codigo, String senha) throws UnsupportedEncodingException {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;
        List<autoridade> autoridades = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nup=? and senha=SHA1(?) and tipo=?");
            stmt.setInt(1, codigo);
            stmt.setString(2, senha);
            stmt.setString(3, "at");
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

    public int num() throws Exception {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int nr = 0, cod;
        try {

            // Statements allow to issue SQL queries to the database
            stmt = con.prepareStatement("SELECT * FROM usuario ORDER BY nup DESC limit 1");
            rs = stmt.executeQuery();
            while (rs.next()) {
                nr = rs.getInt("nup");
            }
        } catch (Exception e) {
        }
        cod = nr + 1;
        return cod;
    }

    public boolean cadastrar(autoridade autoridade) throws Exception {
        String sql = "INSERT INTO autoridade (nup,nome,telefone,email,endereco,cargo) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        int c = num();
        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, num());
            stmt.setString(2, autoridade.getNome());
            stmt.setInt(3, autoridade.getTelefone());
            stmt.setString(4, autoridade.getEmail());
            stmt.setString(5, autoridade.getEndereco());
            stmt.setString(6, autoridade.getCargo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }

    }

    public List<autoridade> visualizar() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<autoridade> autoridades = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM autoridade");
            rs = stmt.executeQuery();

            while (rs.next()) {
                autoridade autoridade = new autoridade();
                autoridade.setCodigo(rs.getInt("nup"));
                autoridade.setNome(rs.getString("nome"));
                autoridade.setTelefone(rs.getInt("telefone"));
                autoridade.setEmail(rs.getString("email"));
                autoridade.setEndereco(rs.getString("endereco"));
                autoridade.setCargo(rs.getString("cargo"));
                autoridades.add(autoridade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(autoridadedao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return autoridades;
    }

    public List<autoridade> usuario() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<autoridade> autoridades = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM autoridade");
            rs = stmt.executeQuery();

            while (rs.next()) {
                autoridade autoridade = new autoridade();
                autoridade.setCodigo(rs.getInt("nup"));
                autoridades.add(autoridade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(autoridadedao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return autoridades;
    }

    public boolean editar(autoridade autoridade) throws UnsupportedEncodingException {
        String sql = "UPDATE autoridade SET nome=?, telefone=?, email=?, endereco=?,cargo=? WHERE nup=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, autoridade.getNome());
            stmt.setInt(2, autoridade.getTelefone());
            stmt.setString(3, autoridade.getEmail());
            stmt.setString(4, autoridade.getEndereco());
            stmt.setString(5, autoridade.getCargo());
            stmt.setInt(6, autoridade.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public List<autoridade> procurar(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<autoridade> autoridades = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM autoridade WHERE nup LIKE ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                autoridade autoridade = new autoridade();
                autoridade.setCodigo(rs.getInt("nup"));
                autoridade.setNome(rs.getString("nome"));
                autoridade.setTelefone(rs.getInt("telefone"));
                autoridade.setEmail(rs.getString("email"));
                autoridade.setEndereco(rs.getString("endereco"));
                autoridade.setCargo(rs.getString("cargo"));
                autoridades.add(autoridade);
            }

        } catch (SQLException ex) {
            Logger.getLogger(autoridadedao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return autoridades;
    }

    public boolean despedido(autoridade autoridade) {
        String sql = "UPDATE usuario SET tipo=? WHERE nup=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, autoridade.getCargo());
            stmt.setInt(2, autoridade.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

}
