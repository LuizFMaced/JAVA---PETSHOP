/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.enderecos;

import bean.cidades.CidadesVO;
import bean.uf.UnidadesFederaisVO;

/**
 *
 * @author Luiz-PC
 */
public class EnderecosVO {
    private String cep;
    private String endereco, bairro;
    private CidadesVO cidade;
    private UnidadesFederaisVO estado;

    public EnderecosVO() {
    }

    public EnderecosVO(String cep, String endereco, String bairro, CidadesVO cidade, UnidadesFederaisVO estado) {
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadesVO getCidade() {
        return cidade;
    }

    public void setCidade(CidadesVO cidade) {
        this.cidade = cidade;
    }

    public UnidadesFederaisVO getEstado() {
        return estado;
    }

    public void setEstado(UnidadesFederaisVO estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CEP: "+getCep()+"\n"+
               "ENDERECO: "+getEndereco()+"\n"+
               "BAIRRO: "+getBairro()+"\n"+
               "ESTADO: "+getEstado().getNome()+"\n"+
               "CIDADE: "+getCidade().getNome()+"\n";
    //To change body of generated methods, choose Tools | Templates.
    }
}