/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cpf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import petshop.banco.ConnectionFactory;


/**
 *
 * @author Luiz-PC
 */
public class CodigoPessoaFisicaDAO {
        private Connection con = null;

    public CodigoPessoaFisicaDAO() {
        con = ConnectionFactory.getConnection();
    }

         public void inserir(CodigoPessoaFisicaVO cpf) {

        String sql = "INSERT INTO CPF ";
        sql += "(cod_cpf, tipo_cpf)";
        sql += "VALUES";
        sql += "('" + cpf.getCpf() + "', ";
        sql += "'" +cpf.getTipo()+ "')";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT na tabela CPF " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
