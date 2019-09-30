/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import coneccao.connectionfactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.comboio;

/**
 *
 * @author victor tesoura jr
 */
public class comboiodao {
    private Connection con = null;

    public comboiodao() {
    con=connectionfactory.getConnection();
    }
    public List<comboio> visualizar(){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<comboio> comboios=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM comboio");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                comboio comboio=new comboio();
                comboio.setCodigo(rs.getInt("nup"));
                comboio.setMatricula(rs.getString("matricula"));
                comboio.setEmpresa(rs.getString("empresa"));
                comboio.setTelefone(rs.getInt("telefone"));
                comboio.setEmail(rs.getString("email"));
                comboio.setTipo(rs.getString("tipo"));
                comboio.setPais(rs.getString("pais"));
                comboio.setPassageiros(rs.getInt("passageiros"));
                comboio.setChegada(rs.getString("chegada"));
                comboio.setPartida(rs.getString("partida"));
                comboios.add(comboio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(comboiodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return comboios;
    }
    public List<comboio> procurar(int codigo){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<comboio> comboios=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM comboio WHERE nup LIKE ?");
            stmt.setInt(1,codigo);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                comboio comboio=new comboio();
                comboio.setCodigo(rs.getInt("nup"));
                comboio.setMatricula(rs.getString("matricula"));
                comboio.setEmpresa(rs.getString("empresa"));
                comboio.setTelefone(rs.getInt("telefone"));
                comboio.setEmail(rs.getString("email"));
                comboio.setTipo(rs.getString("tipo"));
                comboio.setPais(rs.getString("pais"));
                comboio.setPassageiros(rs.getInt("passageiros"));
                comboio.setChegada(rs.getString("chegada"));
                comboio.setPartida(rs.getString("partida"));
                comboios.add(comboio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(comboiodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return comboios;
    }
    
    public boolean cancelarpartida(comboio comboio){
        String sql="UPDATE comboio SET passageiros=?,partida=?,preco=0 WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, comboio.getPassageiros());
            stmt.setString(2, comboio.getPartida());
            stmt.setInt(3, comboio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public boolean cancelarchegada(comboio comboio){
        String sql="UPDATE comboio SET passageiros=?,chegada=?,partida=?,preco=0 WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, comboio.getPassageiros());
            stmt.setString(2, comboio.getChegada());
            stmt.setString(3, comboio.getPartida());
            stmt.setInt(4, comboio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public boolean apagar(comboio comboio){
        String sql="DELETE FROM usuario WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, comboio.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    
}
