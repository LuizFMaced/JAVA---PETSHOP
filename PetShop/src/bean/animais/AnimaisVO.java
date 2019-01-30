/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.animais;

import bean.racas.RacasVO;
import bean.clientes.ClientesVO;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.dependentes.DependentesVO;
import bean.especies.EspeciesVO;

/**
 *
 * @author Luiz-PC
 */
public class AnimaisVO {

    private int cod;
    private String nome, foto, dataNasc, cor, observacao, sexoA;
    private RacasVO raca;
    private EspeciesVO especie;
    private CodigoPessoaFisicaVO cpf;

    public AnimaisVO() {
    }

    
    public AnimaisVO(String nome, String foto, String dataNasc, String cor, String observacao, String sexoA, RacasVO raca, EspeciesVO especie, CodigoPessoaFisicaVO cpf) {
        this.nome = nome;
        this.foto = foto;
        this.dataNasc = dataNasc;
        this.cor = cor;
        this.observacao = observacao;
        this.sexoA = sexoA;
        this.raca = raca;
        this.especie = especie;
        this.cpf = cpf;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSexoA() {
        return sexoA;
    }

    public void setSexoA(String sexoA) {
        this.sexoA = sexoA;
    }

    public RacasVO getRaca() {
        return raca;
    }

    public void setRaca(RacasVO raca) {
        this.raca = raca;
    }

    public EspeciesVO getEspecie() {
        return especie;
    }

    public void setEspecie(EspeciesVO especie) {
        this.especie = especie;
    }

    public CodigoPessoaFisicaVO getCpf() {
        return cpf;
    }

    public void setCpf(CodigoPessoaFisicaVO cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ESPÉCIE: " + getEspecie().getDescricao() + "\n"
                + "NOME: " + getNome() + "\n"
                + "NASC: " + getDataNasc() + "\n"
                + "SEXO: " + getSexoA() + "\n"
                + "RAÇA: " + getRaca().getNome() + "\n"
                + "COR: " + getCor() + "\n"
                + "OBS: " + getObservacao();
        //To change body of generated methods, choose Tools | Templates.
    }

}
