/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cidades;

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
public class CidadesDAO {
    
    private Connection con = null;

    public CidadesDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public List<CidadesVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CidadesVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM CIDADES";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                CidadesVO cidade = new CidadesVO();
                cidade.setNome(rs.getString("cidade"));
                lista.add(cidade);
            }

        } catch (SQLException ex) {
             System.err.println("Erro ao executar SELECT * " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }
    
    
}
