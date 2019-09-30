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
import modelo.bean.noticia;

/**
 *
 * @author victor tesoura jr
 */
public class noticiadao {
    private Connection con= null;

    public noticiadao() {
    con=connectionfactory.getConnection();
    }
    public boolean cadastrar(noticia noticia){
        String sql="INSERT INTO noticia (titulo, descricao,escritor) VALUES (?,?,?)";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setString(1, noticia.getTitulo());
            stmt.setString(2, noticia.getDescricao());
            stmt.setString(3, noticia.getEscritor());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public List<noticia> visualizar(){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<noticia> noticias=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM noticia");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                noticia noticia=new noticia();
                noticia.setCodigo(rs.getInt("codigo"));
                noticia.setTitulo(rs.getString("titulo"));
                noticia.setDescricao(rs.getString("descricao"));
                noticia.setEscritor(rs.getString("escritor"));
                noticias.add(noticia);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(noticiadao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return noticias;
    }
    public boolean editar(noticia noticia){
        String sql="UPDATE noticia SET titulo=?, descricao=? WHERE codigo=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setString(1, noticia.getTitulo());
            stmt.setString(2, noticia.getDescricao());
            stmt.setInt(3, noticia.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public boolean apagar(noticia noticia){
        String sql="DELETE FROM noticia WHERE codigo=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, noticia.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro"+ex);
            return false;
        }finally{
            connectionfactory.closeconnection(con,stmt);
        }
    }
    public List<noticia> procurar(int codigo){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<noticia> noticias=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM noticia WHERE codigo LIKE ?");
            stmt.setInt(1, codigo);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                noticia noticia=new noticia();
                noticia.setCodigo(rs.getInt("codigo"));
                noticia.setTitulo(rs.getString("titulo"));
                noticia.setDescricao(rs.getString("descricao"));
                noticia.setEscritor(rs.getString("escritor"));
                noticias.add(noticia);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(noticiadao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return noticias;
    }
}
