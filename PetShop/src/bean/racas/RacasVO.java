/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.racas;

/**
 *
 * @author Luiz-PC
 */
public class RacasVO {
    private int cod;
    private String nome, descricao, porte;

    public RacasVO() {
    }

    public RacasVO(int cod, String nome, String descricao, String porte) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.porte = porte;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
    
    @Override
    public String toString(){
        return getNome();
    }
}
