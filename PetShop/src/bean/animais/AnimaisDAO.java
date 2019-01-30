/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.animais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import petshop.banco.ConnectionFactory;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.especies.EspeciesVO;
import bean.racas.RacasVO;

/**
 *
 * @author Luiz-PC
 */
public class AnimaisDAO {

    private Connection con;

    public AnimaisDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean inserir(AnimaisVO animal) {

        String sql = "INSERT INTO animais ";
        sql += "(cod_animal, nome_animal, cod_cpf, ";
        sql += "cod_raca, cor_animal, ";
        sql += "nasc_animal, foto_animal, ";
        sql += "sexo_animal, obs_animal, cod_especie) ";
        sql += "VALUES ";
        sql += "('" + animal.getCod() + "', ";
        sql += "'" + animal.getNome() + "', ";
        sql += "'" + animal.getCpf().getCpf() + "', ";
        sql += "'" + animal.getRaca().getCod() + "', ";
        sql += "'" + animal.getCor() + "', ";
        sql += "'" + animal.getDataNasc() + "', ";
        sql += "'" + animal.getFoto() + "', ";
        sql += "'" + animal.getSexoA() + "', ";
        sql += "'" + animal.getObservacao() + "', ";
        sql += "'" + animal.getEspecie().getCod() + "')";

        PreparedStatement stmt = null;
        System.out.println(sql);
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    public List<AnimaisVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AnimaisVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM ANIMAIS";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                AnimaisVO animal = new AnimaisVO();
                animal.setCod(rs.getInt("cod_animal"));
                animal.setNome(rs.getString("nome_animal"));

                RacasVO raca = new RacasVO();
                raca.setCod(rs.getInt("cod_raca"));
                animal.setRaca(raca);

                animal.setCor(rs.getString("cor_animal"));
                animal.setDataNasc(rs.getString("nasc_animal"));
                animal.setFoto(rs.getString("foto_animal"));

                animal.setSexoA(rs.getString("sexo_animal"));
                animal.setObservacao(rs.getString("obs_animal"));

                EspeciesVO especie = new EspeciesVO();
                especie.setCod(rs.getString("cod_especie"));
                animal.setEspecie(especie);
                
                CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
                cpf.setCpf(rs.getString("cod_cpf"));
                animal.setCpf(cpf);

                lista.add(animal);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT * " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    public List<AnimaisVO> selecionar(String tmpBusca, int tmpTipo) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sqlConsulta = "";
        List<AnimaisVO> selecionar = new ArrayList<>();

        if (tmpTipo == 1) {
            sqlConsulta = "SELECT * FROM ANIMAIS WHERE nome_animal LIKE '" + tmpBusca + "'";
        } else if (tmpTipo == 2) {
            sqlConsulta = "select cod_animal from animais where cod_cpf  like '" + tmpBusca + "'";
        }

        try {
            stmt = con.prepareStatement(sqlConsulta);
            rs = stmt.executeQuery();
            if (tmpTipo == 1) {
                while (rs.next()) {
                    AnimaisVO animal = new AnimaisVO();
                    animal.setCod(rs.getInt("cod_animal"));
                    animal.setNome(rs.getString("nome_animal"));

                    RacasVO raca = new RacasVO();
                    raca.setCod(rs.getInt("cod_raca"));
                    animal.setRaca(raca);

                    animal.setCor(rs.getString("cor_animal"));
                    animal.setDataNasc(rs.getString("nasc_animal"));
                    animal.setFoto(rs.getString("foto_animal"));

                    animal.setSexoA(rs.getString("sexo_animal"));
                    animal.setObservacao(rs.getString("obs_animal"));

                    EspeciesVO especie = new EspeciesVO();
                    especie.setCod(rs.getString("cod_especie"));
                    animal.setEspecie(especie);

                    selecionar.add(animal);
                }
            } else if (tmpTipo == 2) {
                while (rs.next()) {
                    AnimaisVO animal = new AnimaisVO();
                    animal.setCod(rs.getInt("cod_animal"));
                    selecionar.add(animal);
                }
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT c/ WHERE" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return selecionar;

    }

    public void atualizar(AnimaisVO animal) {

        String sql = "UPDATE ANIMAIS";
        sql += "SET nome_animal = '" + animal.getNome() + "',";
        sql += "SET cod_raca = '" + animal.getRaca().getCod() + "',";
        sql += "SET cor_animal = '" + animal.getCor() + "',";
        sql += "SET nasc_animal = '" + animal.getDataNasc() + "',";
        sql += "SET foto_animal = '" + animal.getFoto() + "',";
        sql += "SET sexo_animal = '" + animal.getSexoA() + "',";
        sql += "SET obs_animal = '" + animal.getObservacao() + "',";
        sql += "SET cod_especie = '" + animal.getEspecie().getCod() + "' ";
        sql += "WHERE cod_animal = '" + animal.getCod()+ "'";

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

    public void deletar(AnimaisVO animal) {

        String sql = "DELETE FROM ANIMAIS WHERE cod_animal = '" + animal.getCod() + "'";

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
