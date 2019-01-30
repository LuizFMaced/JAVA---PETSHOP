/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.especies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import petshop.banco.ConnectionFactory;

/**
 *
 * @author Luiz-PC
 */
public class EspeciesDAO {

    private Connection con = null;

    public EspeciesDAO() {
        con = ConnectionFactory.getConnection();
    }

    public List<EspeciesVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EspeciesVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM ESPECIES";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EspeciesVO especie = new EspeciesVO();
                especie.setCod(rs.getString("cod_especie"));
                especie.setDescricao(rs.getString("desc_especie"));
                lista.add(especie);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT * " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

}
