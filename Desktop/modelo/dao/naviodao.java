/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import coneccao.connectionfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.navio;

/**
 *
 * @author victor tesoura jr
 */
public class naviodao {

    private Connection con = null;

    public naviodao() {
        con = connectionfactory.getConnection();
    }

    public List<navio> visualizar() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<navio> navios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM navio");
            rs = stmt.executeQuery();

            while (rs.next()) {
                navio navio = new navio();
                navio.setCodigo(rs.getInt("nup"));
                navio.setMatricula(rs.getString("matricula"));
                navio.setNome(rs.getString("nome"));
                navio.setTelefone(rs.getInt("telefone"));
                navio.setEmail(rs.getString("email"));
                navio.setTipo(rs.getString("tipo"));
                navio.setPais(rs.getString("pais"));
                navio.setPassageiros(rs.getInt("passageiros"));
                navio.setChegada(rs.getString("chegada"));
                navio.setPartida(rs.getString("partida"));
                navios.add(navio);
            }

        } catch (SQLException ex) {
            Logger.getLogger(naviodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return navios;
    }

    public List<navio> procurar(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<navio> navios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM navio WHERE nup LIKE ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                navio navio = new navio();
                navio.setCodigo(rs.getInt("nup"));
                navio.setMatricula(rs.getString("matricula"));
                navio.setNome(rs.getString("nome"));
                navio.setTelefone(rs.getInt("telefone"));
                navio.setEmail(rs.getString("email"));
                navio.setTipo(rs.getString("tipo"));
                navio.setPais(rs.getString("pais"));
                navio.setPassageiros(rs.getInt("passageiros"));
                navio.setChegada(rs.getString("chegada"));
                navio.setPartida(rs.getString("partida"));
                navios.add(navio);
            }

        } catch (SQLException ex) {
            Logger.getLogger(naviodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return navios;
    }

    public boolean cancelarpartida(navio navio) {
        String sql = "UPDATE navio SET passageiros=?,partida=?,preco=0 WHERE nup=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, navio.getPassageiros());
            stmt.setString(2, navio.getPartida());
            stmt.setInt(3, navio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean cancelarchegada(navio navio) {
        String sql = "UPDATE navio SET passageiros=?,chegada=?,partida=?,preco=0 WHERE nup=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, navio.getPassageiros());
            stmt.setString(2, navio.getChegada());
            stmt.setString(3, navio.getPartida());;
            stmt.setInt(4, navio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean apagar(navio navio) {
        String sql = "DELETE FROM usuario WHERE nup=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, navio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean atracar(navio navio) {
        String sql = "UPDATE mercadoria SET disponivel=? WHERE navio=? and disponivel=0";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, navio.getCodigo());
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
