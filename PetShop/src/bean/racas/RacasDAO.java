/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.racas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import petshop.banco.ConnectionFactory;

/**
 *
 * @author 28233708
 */
public class RacasDAO {

    private Connection con;

    public RacasDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void inserir(RacasVO raca) {

        String sql = "INSERT INTO racas ";
        sql += "(cod_raca, nome_raca, ";
        sql += "desc_raca, porte_raca)";
        sql += "VALUES";
        sql += "('" + raca.getCod() + "',";
        sql += "'" + raca.getNome() + "',";
        sql += "'" + raca.getDescricao() + "',";
        sql += "'" + raca.getPorte() + "')";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<RacasVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<RacasVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM RACAS";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RacasVO raca = new RacasVO();

                raca.setCod(rs.getInt("cod_raca"));
                raca.setNome(rs.getString("nome_raca"));
                raca.setDescricao(rs.getString("desc_raca"));
                raca.setPorte(rs.getString("porte_raca"));
                lista.add(raca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RacasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    public List<RacasVO> selecionar(String tmpBusca, int tmpTipo) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sqlConsulta = "";

        List<RacasVO> selecionar = new ArrayList<>();

        if (tmpTipo == 1) {
            sqlConsulta = "SELECT * FROM RACAS WHERE raca_nome LIKE " + tmpBusca + "";
        } else if (tmpTipo == 2) {
            sqlConsulta = "select r.nome_raca\n"
                    + "from racas r\n"
                    + "inner join especies e \n"
                    + "on r.cod_especie=e.cod_especie\n"
                    + "where e.desc_especie like '" + tmpBusca + "'";

            try {
                stmt = con.prepareStatement(sqlConsulta);
                rs = stmt.executeQuery();

                if (tmpTipo == 1) {
                    while (rs.next()) {
                        RacasVO raca = new RacasVO();

                        raca.setCod(rs.getInt("cod_raca"));
                        raca.setNome(rs.getString("nome_raca"));
                        raca.setDescricao(rs.getString("desc_raca"));
                        raca.setPorte(rs.getString("porte_raca"));

                        selecionar.add(raca);
                    }
                } else if (tmpTipo == 2) {
                    while (rs.next()) {
                        RacasVO raca = new RacasVO();
                        
                        raca.setNome(rs.getString("nome_raca"));
                        selecionar.add(raca);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(RacasDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
            }
        }

        return selecionar;

    }

    public void atualizar(RacasVO raca) {

        String sql = "UPDATE RACA ";
        sql += "SET nome_raca = '" + raca.getNome() + "',";
        sql += "SET desc_raca = '" + raca.getDescricao() + "',";
        sql += "SET porte_raca = '" + raca.getPorte() + "'";
        sql += "WHERE cod_raca = '" + raca.getCod() + "'";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao executar o UPDATE " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deletar(RacasVO raca) {

        String sql = "DELETE FROM RACAS WHERE cod_raca = '" + raca.getCod() + "'";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao executar o DELETE " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
