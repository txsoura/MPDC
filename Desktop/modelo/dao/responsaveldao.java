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
import modelo.bean.responsavel;

/**
 *
 * @author victor tesoura jr
 */
public class responsaveldao {
    private Connection con= null;

    public responsaveldao() {
    con=connectionfactory.getConnection();
    }
    public List<responsavel> visualizar(){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<responsavel> responsavels=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM responsavel");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                responsavel responsavel=new responsavel();
                responsavel.setCodigo(rs.getInt("nup"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setTelefone(rs.getInt("telefone"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setEndereco(rs.getString("endereco"));
                responsavels.add(responsavel);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(responsaveldao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return responsavels;
    }
    public List<responsavel> procurar(int codigo){
        Connection con=connectionfactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<responsavel> responsavels=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT * FROM responsavel WHERE nup LIKE ?");
            stmt.setInt(1,codigo);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                responsavel responsavel=new responsavel();
                responsavel.setCodigo(rs.getInt("nup"));
                responsavel.setNome(rs.getString("nome"));
                responsavel.setTelefone(rs.getInt("telefone"));
                responsavel.setEmail(rs.getString("email"));
                responsavel.setEndereco(rs.getString("endereco"));
                responsavels.add(responsavel);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(responsaveldao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionfactory.closeconnection(con,stmt,rs);
        }
        return responsavels;
    }
   
    public boolean apagar(responsavel responsavel){
        String sql="DELETE FROM usuario WHERE nup=?";
        PreparedStatement stmt=null;
        
        try {
            stmt=con.prepareStatement(sql);
            stmt.setInt(1, responsavel.getCodigo());
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
