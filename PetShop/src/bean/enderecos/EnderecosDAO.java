/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.enderecos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import petshop.banco.ConnectionFactory;
import bean.cidades.CidadesVO;
import bean.uf.UnidadesFederaisVO;
import javax.swing.JOptionPane;

/**
 *
 * @author 28233708
 */
public class EnderecosDAO {

    private Connection con = null;

    public EnderecosDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(EnderecosVO endereco) {

        String sql = "INSERT INTO enderecos ";
        sql += "(cod_cep, endereco, cidade, estado, bairro)";
        sql += "VALUES";
        sql += "('" + endereco.getCep() + "',";
        sql += "'" + endereco.getEndereco() + "',";
        sql += "'" + endereco.getCidade().getNome() + "',";
        sql += "'" + endereco.getEstado().getNome() + "',";
        sql += "'" + endereco.getBairro() + "')";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao executar INSERT na tabela ENDERECOS " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    public List<EnderecosVO> listarTodos() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EnderecosVO> lista = new ArrayList<>();

        String sql = "SELECT * FROM ENDERECOS";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                EnderecosVO endereco = new EnderecosVO();

                endereco.setCep(rs.getString("cod_cep"));
                endereco.setEndereco(rs.getString("endereco"));

                CidadesVO cidade = new CidadesVO();
                cidade.setNome(rs.getString("cidade"));
                endereco.setCidade(cidade);

                UnidadesFederaisVO estado = new UnidadesFederaisVO();
                estado.setNome(rs.getString("estado"));
                endereco.setEstado(estado);

                endereco.setBairro(rs.getString("bairro"));

                lista.add(endereco);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT * " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    public List<EnderecosVO> selecionar(String tmpBusca, int tmpTipo) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sqlConsulta = "";
        List<EnderecosVO> selecionar = new ArrayList<>();

        switch (tmpTipo) {
            case 1:
                //seleciona por cliente/dependente
                sqlConsulta = "SELECT * FROM ENDERECOS"
                        + " WHERE cod_cep LIKE '" + tmpBusca + "'";
                break;
            case 2:
                //alimenta a comboboxs
                sqlConsulta = "select distinct c.cidade\n"
                        + "from enderecos e\n"
                        + "inner join cidades c on e.cidade=c.cidade\n"
                        + "inner join uf u on e.estado=u.estado\n"
                        + "where u.estado like '" + tmpBusca + "'";
                break;
            default:
                break;
        }

        try {
            stmt = con.prepareStatement(sqlConsulta);
            rs = stmt.executeQuery();
            if (tmpTipo == 1) {
                while (rs.next()) {
                    EnderecosVO endereco = new EnderecosVO();

                    endereco.setCep(rs.getString("cod_cep"));
                    endereco.setEndereco(rs.getString("endereco"));

                    CidadesVO cidade = new CidadesVO();
                    cidade.setNome(rs.getString("cidade"));
                    endereco.setCidade(cidade);

                    UnidadesFederaisVO estado = new UnidadesFederaisVO();
                    estado.setNome(rs.getString("estado"));
                    endereco.setEstado(estado);

                    endereco.setBairro(rs.getString("bairro"));

                    selecionar.add(endereco);
                }
            } else if (tmpTipo == 2) {
                while (rs.next()) {
                    EnderecosVO endereco = new EnderecosVO();
                    CidadesVO cidade = new CidadesVO();
                    cidade.setNome(rs.getString("cidade"));
                    endereco.setCidade(cidade);
                    selecionar.add(endereco);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT c/ WHERE" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return selecionar;

    }

    public boolean existeCep(String tmpBusca) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select cod_cep from enderecos where cod_cep like '" + tmpBusca + "'";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //JOptionPane.showMessageDialog(null, rs.getString("cod_cep"));
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao executar SELECT c/ WHERE CEP " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public void atualizar(EnderecosVO endereco) {

        String sql = "UPDATE ENDERECOS";
        sql += "SET endereco = '" + endereco.getEndereco() + "',";
        sql += "SET cidade = '" + endereco.getCidade().getNome() + "',";
        sql += "SET estado = '" + endereco.getEstado().getNome() + "',";
        sql += "SET bairro = '" + endereco.getBairro() + "',";
        sql += "WHERE cod_cep = '" + endereco.getCep() + "'";

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

    public void deletar(EnderecosVO endereco) {

        String sql = "DELETE FROM ENDERECOS WHERE cod_cep = '" + endereco.getCep() + "'";

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
