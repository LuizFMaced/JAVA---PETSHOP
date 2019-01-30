/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.dependentes;

import bean.cidades.CidadesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import petshop.banco.ConnectionFactory;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.enderecos.EnderecosVO;
import bean.registro_geral.RegistroGeralVO;
import bean.uf.UnidadesFederaisVO;

/**
 *
 * @author Luiz-PC
 */
public class DependentesDAO {

    private Connection con = null;

    public DependentesDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DependentesVO dependente) {

        String sql = "INSERT INTO dependentes ";
        sql += "(cod_dependente, nome_dependente,";
        sql += "cod_cep, cod_rg, cod_cpf, cel_dependente, ";
        sql += "email_dependente, foto_dependente, ";
        sql += "num_resid, sexo )";
        sql += "VALUES";
        sql += "('" + dependente.getCod() + "',";
        sql += "'" + dependente.getNome() + "',";
        sql += "'" + dependente.getCep().getCep() + "',";
        sql += "'" + dependente.getRg().getRg() + "',";
        sql += "'" + dependente.getCpf().getCpf() + "',";
        sql += "'" + dependente.getCelular() + "',";
        sql += "'" + dependente.getEmail() + "',";
        sql += "'" + dependente.getFoto() + "',";
        sql += "'" + dependente.getNum_resid() + "',";
        sql += "'" + dependente.getSexo() + "')";

        PreparedStatement stmt = null;
        System.out.println(sql);
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT na tabela DEPENDENTES " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    public List<DependentesVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<DependentesVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM DEPENDENTES";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DependentesVO dependente = new DependentesVO();
                dependente.setCod(rs.getInt("cod_dependente"));
                dependente.setNome(rs.getString("nome_dependente"));

                CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
                cpf.setCpf(rs.getString("cod_cpf"));
                dependente.setCpf(cpf);

                RegistroGeralVO rg = new RegistroGeralVO();
                rg.setRg(rs.getString("cod_rg"));
                dependente.setRg(rg);

                EnderecosVO endereco = new EnderecosVO();
                endereco.setCep(rs.getString("cod_cep"));
                dependente.setCep(endereco);

                dependente.setSexo(rs.getString("sexo"));

                lista.add(dependente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DependentesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    public List<DependentesVO> selecionar(String tmpBusca, int tmpTipo) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sqlConsulta = "";
        List<DependentesVO> selecionar = new ArrayList<>();

        if (tmpTipo == 1) {
            sqlConsulta = "SELECT * FROM DEPENDENTES WHERE COD_CPF LIKE '" + tmpBusca + "'";
        } else if (tmpTipo == 2) {
            sqlConsulta = "select cod_dependente from dependentes where cod_cpf like '" + tmpBusca + "'";
        } else if (tmpTipo == 3) {
            sqlConsulta = "SELECT d.cod_cpf,"
                    + "       p.tipo_cpf,"
                    + "       r.cod_rg,"
                    + "       d.nome_dependente,"
                    + "       d.sexo,"
                    + "       d.cod_cep,"
                    + "       e.estado,"
                    + "       e.cidade,"
                    + "       e.endereco,"
                    + "       e.bairro,"
                    + "       d.num_resid,"
                    + "       d.email_dependente,"
                    + "       d.cel_dependente"
                    + "INNER JOIN cpf AS p ON d.cod_cpf = p.cod_cpf"
                    + "INNER JOIN rg AS r ON d.cod_rg = r.cod_rg"
                    + "INNER JOIN enderecos AS e ON d.cod_cep = e.cod_cep"
                    + "WHERE d.cod_cpf LIKE '" + tmpBusca + "'";
        }
        try {
            stmt = con.prepareStatement(sqlConsulta);
            rs = stmt.executeQuery();
            if (tmpTipo == 1) {
                while (rs.next()) {
                    DependentesVO dependente = new DependentesVO();
                    dependente.setCod(rs.getInt("cod_dependente"));
                    dependente.setNome(rs.getString("nome_dependente"));

                    CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
                    cpf.setCpf(rs.getString("cod_cpf"));
                    dependente.setCpf(cpf);

                    RegistroGeralVO rg = new RegistroGeralVO();
                    rg.setRg(rs.getString("cod_rg"));
                    dependente.setRg(rg);

                    EnderecosVO endereco = new EnderecosVO();
                    endereco.setCep(rs.getString("cod_cep"));
                    dependente.setCep(endereco);

                    dependente.setSexo(rs.getString("sexo"));

                    selecionar.add(dependente);
                }
            } else if (tmpTipo == 2) {
                while (rs.next()) {
                    DependentesVO dependente = new DependentesVO();
                    dependente.setCod(rs.getInt("cod_dependente"));
                    selecionar.add(dependente);
                }
            } else if (tmpTipo == 3) {
                while (rs.next()) {
                    DependentesVO dependente = new DependentesVO();
                    dependente.setNome(rs.getString("nome_dependente"));

                    CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
                    cpf.setCpf(rs.getString("cod_cpf"));
                    cpf.setTipo(rs.getString("tipo_cpf"));
                    dependente.setCpf(cpf);

                    RegistroGeralVO rg = new RegistroGeralVO();
                    rg.setRg(rs.getString("cod_rg"));
                    dependente.setRg(rg);

                    EnderecosVO endereco = new EnderecosVO();
                    endereco.setCep(rs.getString("cod_cep"));
                    endereco.setEndereco(rs.getString("endereco"));
                    endereco.setBairro(rs.getString("bairro"));
                    
                    UnidadesFederaisVO uf = new UnidadesFederaisVO();
                    uf.setNome(rs.getString("estado"));
                    endereco.setEstado(uf);

                    CidadesVO cidade = new CidadesVO();
                    cidade.setNome(rs.getString("cidade"));
                    endereco.setCidade(cidade);
                    
                    dependente.setCep(endereco);
                    dependente.setSexo(rs.getString("sexo"));
                    selecionar.add(dependente);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DependentesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return selecionar;
    }

}
