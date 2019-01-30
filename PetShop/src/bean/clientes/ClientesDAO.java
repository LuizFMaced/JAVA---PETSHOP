/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.animais.AnimaisVO;
import bean.cidades.CidadesVO;
import petshop.banco.ConnectionFactory;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.dependentes.DependentesVO;
import bean.enderecos.EnderecosVO;
import bean.registro_geral.RegistroGeralVO;
import bean.uf.UnidadesFederaisDAO;
import bean.uf.UnidadesFederaisVO;

/**
 *
 * @author 28233708
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean inserir(ClientesVO cliente) {

        String sql = "INSERT INTO CLIENTES ";
        sql += "(cod_cliente, nome_cliente, ";
        sql += "cod_animal, cod_dependente, ";
        sql += "cod_cep, num_resid, ";
        sql += "cod_cpf, cod_rg, ";
        sql += "sexo, tpo_cliente, ";
        sql += "foto_cliente, tel_cliente, ";
        sql += "cel_cliente, email_cliente)";
        sql += "VALUES";
        sql += "('" + cliente.getCod() + "', ";
        sql += "'" + cliente.getNome() + "', ";
        sql += "'" + cliente.getAnimal().getCod() + "', ";
        sql += "'" + cliente.getDependente().getCod() + "', ";
        sql += "'" + cliente.getCep().getCep() + "', ";
        sql += "'" + cliente.getNum_resid() + "', ";
        sql += "'" + cliente.getCpf().getCpf() + "', ";
        sql += "'" + cliente.getRg().getRg() + "', ";
        sql += "'" + cliente.getSexo() + "', ";
        sql += "'" + cliente.getTipo() + "', ";
        sql += "'" + cliente.getFoto() + "',";
        sql += "'" + cliente.getTelefone() + "',";
        sql += "'" + cliente.getCelular() + "',";
        sql += "'" + cliente.getEmail() + "')";

        PreparedStatement stmt = null;
        System.out.println(sql);
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT na tabela CLIENTES " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<ClientesVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<ClientesVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM lista_cliente";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ClientesVO cliente = new ClientesVO();
                cliente.setCod(rs.getInt("cod_cliente"));
                cliente.setNome(rs.getString("nome_cliente"));

                EnderecosVO endereco = new EnderecosVO();
                endereco.setCep(rs.getString("cod_cep"));
                endereco.setEndereco(rs.getString("endereco"));
                cliente.setCep(endereco);

                cliente.setNum_resid(rs.getInt("num_resid"));

                CodigoPessoaFisicaVO cpf = new CodigoPessoaFisicaVO();
                cpf.setCpf(rs.getString("cod_cpf"));
                cliente.setCpf(cpf);

                RegistroGeralVO rg = new RegistroGeralVO();
                rg.setRg(rs.getString("cod_rg"));
                cliente.setRg(rg);

                cliente.setSexo(rs.getString("sexo"));
                cliente.setTipo(rs.getString("tpo_cliente"));
                cliente.setTelefone(rs.getString("tel_cliente"));
                cliente.setCelular(rs.getString("cel_cliente"));
                cliente.setEmail(rs.getString("email_cliente"));

                lista.add(cliente);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT * na tabela CLIENTES " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    public List<ClientesVO> selecionar(String cpf) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClientesVO> selecionar = new ArrayList<>();

        String sql = "SELECT * FROM selecionar_cliente WHERE cod_cpf LIKE '" + cpf + "'";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClientesVO cliente = new ClientesVO();
                cliente.setNome(rs.getString("nome_cliente"));

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
                cliente.setCep(endereco);

                cliente.setNum_resid(rs.getInt("num_resid"));

                CodigoPessoaFisicaVO Cpf = new CodigoPessoaFisicaVO();
                Cpf.setCpf(rs.getString("cod_cpf"));
                Cpf.setTipo(rs.getString("tipo_cpf"));
                cliente.setCpf(Cpf);

                RegistroGeralVO rg = new RegistroGeralVO();
                rg.setRg(rs.getString("cod_rg"));
                cliente.setRg(rg);

                cliente.setSexo(rs.getString("sexo"));
                cliente.setTipo(rs.getString("tpo_cliente"));
                cliente.setTelefone(rs.getString("tel_cliente"));
                cliente.setCelular(rs.getString("cel_cliente"));
                cliente.setEmail(rs.getString("email_cliente"));

                selecionar.add(cliente);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT c/ WHERE na tabela CLIENTES " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return selecionar;

    }

    public void atualizar(ClientesVO cliente) {

        String sql = "UPDATE CLIENTES";
        sql += "SET nome_cliente = '" + cliente.getNome() + "',";
        sql += "SET cod_cep = '" + cliente.getCep().getCep() + "',";
        sql += "SET num_resid = '" + cliente.getNum_resid() + "',";
        sql += "SET cod_cpf = '" + cliente.getCpf().getCpf() + "',";
        sql += "SET cod_rg = '" + cliente.getRg().getRg() + "',";
        sql += "SET sexo = '" + cliente.getSexo() + "',";
        sql += "SET tpo_cliente = '" + cliente.getTipo() + "',";
        sql += "SET foto_cliente = '" + cliente.getFoto() + "',";
        sql += "SET tel_cliente = '" + cliente.getTelefone() + "',";
        sql += "SET cel_cliente = '" + cliente.getCelular() + "',";
        sql += "SET email_cliente = '" + cliente.getEmail() + "' ";
        sql += "WHERE cod_cliente = '" + cliente.getCod() + "'";

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

    public void deletar(ClientesVO cliente) {

        String sql = "DELETE FROM CLIENTES WHERE cod_cpf = '" + cliente.getCpf().getCpf() + "'";

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
