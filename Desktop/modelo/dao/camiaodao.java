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
import modelo.bean.camiao;

/**
 *
 * @author victor tesoura jr
 */
public class camiaodao {
    private Connection con= null;

    public camiaodao() {
    con=connectionfactory.getConnection();
    }
    public List<camiao> visualizar(){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<camiao> camiaos=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM camiao");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                camiao camiao=new camiao();
                camiao.setCodigo(rs.getInt("nup"));
                camiao.setMatricula(rs.getString("matricula"));
                camiao.setEmpresa(rs.getString("empresa"));
                camiao.setTelefone(rs.getInt("telefone"));
                camiao.setEmail(rs.getString("email"));
                camiao.setTipo(rs.getString("tipo"));
                camiao.setPais(rs.getString("pais"));
                camiao.setPassageiros(rs.getInt("passageiros"));
                camiao.setChegada(rs.getString("chegada"));
                camiaos.add(camiao);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(camiaodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return camiaos;
    }
    public List<camiao> procurar(int codigo){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<camiao> camiaos=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM camiao WHERE nup LIKE ?");
            stmt.setInt(1,codigo);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                camiao camiao=new camiao();
                camiao.setCodigo(rs.getInt("nup"));
                camiao.setMatricula(rs.getString("matricula"));
                camiao.setEmpresa(rs.getString("empresa"));
                camiao.setTelefone(rs.getInt("telefone"));
                camiao.setEmail(rs.getString("email"));
                camiao.setTipo(rs.getString("tipo"));
                camiao.setPais(rs.getString("pais"));
                camiao.setPassageiros(rs.getInt("passageiros"));
                camiao.setChegada(rs.getString("chegada"));
                camiaos.add(camiao);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(camiaodao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return camiaos;
    }
   
    public boolean cancelarchegada(camiao camiao){
        String sql="UPDATE camiao SET passageiros=?,chegada=? WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, camiao.getPassageiros());
            stmt.setString(2, camiao.getChegada());
            stmt.setInt(3, camiao.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public boolean apagar(camiao camiao){
        String sql="DELETE FROM usuario WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, camiao.getCodigo());
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
