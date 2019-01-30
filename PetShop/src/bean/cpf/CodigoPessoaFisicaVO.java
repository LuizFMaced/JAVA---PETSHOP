/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.cpf;

/**
 *
 * @author Luiz-PC
 */
public class CodigoPessoaFisicaVO {
    private String cpf;
    private String tipo;

    public CodigoPessoaFisicaVO() {
    }

    public CodigoPessoaFisicaVO(String cpf, String tipo) {
        this.cpf = cpf;
        this.tipo = tipo; 
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
