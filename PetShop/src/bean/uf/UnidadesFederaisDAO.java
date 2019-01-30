/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.uf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import petshop.banco.ConnectionFactory;

/**
 *
 * @author 28233708
 */
public class UnidadesFederaisDAO {
    
    private Connection con = null;

    public UnidadesFederaisDAO() {
        con = ConnectionFactory.getConnection();
    }
    
  public List<UnidadesFederaisVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<UnidadesFederaisVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM UF";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                UnidadesFederaisVO estado = new UnidadesFederaisVO();
                estado.setNome(rs.getString("estado"));
                lista.add(estado);
            }

        } catch (SQLException ex) {
             System.err.println("Erro ao executar SELECT * " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }
    
    
    
}
