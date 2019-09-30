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
import modelo.bean.mercadoria;

/**
 *
 * @author victor tesoura jr
 */
public class mercadoriadao {

    private Connection con = null;

    public mercadoriadao() {
        con = connectionfactory.getConnection();
    }

    public List<mercadoria> visualizarcaminho() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE disponivel=0");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> visualizaratracado() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE disponivel=1");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> visualizararmazem() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE disponivel=2");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> visualizardespachada() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE disponivel=3");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadoria.setPartida(rs.getString("partida"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> visualizarapreendida() {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE disponivel=4");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> procurarcaminho(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE codigo=? and disponivel=0");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> procuraratracado(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE codigo=? and disponivel=1");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> procurararmazem(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE codigo=? and disponivel=2");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> procurardespachada(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE codigo=? and disponivel=3");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadoria.setPartida(rs.getString("partida"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public List<mercadoria> procurarapreendida(int codigo) {
        Connection con = connectionfactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mercadoria> mercadorias = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM mercadoria WHERE codigo=? and disponivel=4");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mercadoria mercadoria = new mercadoria();
                mercadoria.setCodigo(rs.getInt("codigo"));
                mercadoria.setNavio(rs.getInt("navio"));
                mercadoria.setSituacao(rs.getString("situacao"));
                mercadoria.setTipo(rs.getString("tipo"));
                mercadoria.setQuantidade(rs.getInt("quantidade"));
                mercadoria.setResponsavel(rs.getInt("responsavel"));
                mercadoria.setChegada(rs.getString("chegada"));
                mercadorias.add(mercadoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mercadoriadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionfactory.closeconnection(con, stmt, rs);
        }
        return mercadorias;
    }

    public boolean editarresponsavel(mercadoria mercadoria) throws UnsupportedEncodingException {
        String sql = "UPDATE mercadoria SET responsavel=? WHERE codigo=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mercadoria.getResponsavel());
            stmt.setInt(2, mercadoria.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean cancelarpartida(mercadoria mercadoria) {
        String sql = "UPDATE mercadoria SET partida=?,preco=0 WHERE codigo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mercadoria.getPartida());
            stmt.setInt(2, mercadoria.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean cancelarchegada(mercadoria mercadoria) {
        String sql = "UPDATE mercadoria SET disponivel=1,chegada=?,partida=?,preco=0 WHERE codigo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mercadoria.getChegada());
            stmt.setString(2, mercadoria.getPartida());
            stmt.setInt(3, mercadoria.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean apagar(mercadoria mercadoria) {
        String sql = "DELETE FROM mercadoria WHERE codigo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mercadoria.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            connectionfactory.closeconnection(con, stmt);
        }
    }

    public boolean apreender(mercadoria mercadoria) throws UnsupportedEncodingException {
        String sql = "UPDATE mercadoria SET disponivel=? WHERE codigo=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, 4);
            stmt.setInt(2, mercadoria.getCodigo());
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
