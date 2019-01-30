/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.registro_geral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import petshop.banco.ConnectionFactory;


/**
 *
 * @author Luiz-PC
 */
public class RegistroGeralDAO {
           private Connection con = null;

    public RegistroGeralDAO() {
        con = ConnectionFactory.getConnection();
    }

         public void inserir(RegistroGeralVO rg) {

        String sql = "INSERT INTO RG ";
        sql += "(cod_rg)";
        sql += "VALUES";
        sql += "('" +rg.getRg()+ "')";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT na tabela RG " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
