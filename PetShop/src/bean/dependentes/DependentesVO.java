/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.dependentes;

import bean.animais.AnimaisVO;
import bean.clientes.ClientesVO;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.enderecos.EnderecosVO;
import bean.registro_geral.RegistroGeralVO;

/**
 *
 * @author Luiz-PC
 */
public class DependentesVO {
    private int cod, num_resid;
    private String nome, email, celular, sexo, foto;
    private CodigoPessoaFisicaVO cpf;
    private RegistroGeralVO rg;
    private EnderecosVO cep;
    private ClientesVO cliente;
    private AnimaisVO animal;
    

    public DependentesVO() {
    }

    public DependentesVO(int num_resid, String nome, String email, String celular, String sexo, String foto, CodigoPessoaFisicaVO cpf, RegistroGeralVO rg, EnderecosVO cep, ClientesVO cliente, AnimaisVO animal) {
        this.num_resid = num_resid;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.foto = foto;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.cliente = cliente;
        this.animal = animal;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getNum_resid() {
        return num_resid;
    }

    public void setNum_resid(int num_resid) {
        this.num_resid = num_resid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public CodigoPessoaFisicaVO getCpf() {
        return cpf;
    }

    public void setCpf(CodigoPessoaFisicaVO cpf) {
        this.cpf = cpf;
    }

    public RegistroGeralVO getRg() {
        return rg;
    }

    public void setRg(RegistroGeralVO rg) {
        this.rg = rg;
    }

    public EnderecosVO getCep() {
        return cep;
    }

    public void setCep(EnderecosVO cep) {
        this.cep = cep;
    }

    public ClientesVO getCliente() {
        return cliente;
    }

    public void setCliente(ClientesVO cliente) {
        this.cliente = cliente;
    }

    public AnimaisVO getAnimal() {
        return animal;
    }

    public void setAnimal(AnimaisVO animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "CPF: "+getCpf().getCpf()+"\n"+
               "RG: "+getRg().getRg()+"\n"+  
               "NOME: "+getNome()+"\n"+  
               "CEP: "+getCep().getCep()+"\n"+  
               "SEXO: "+getSexo()+"\n"+  
               //"ENDERECO: "+getCep().getEndereco()+"\n"+  
               "N°: "+getNum_resid()+"\n"+  
               "EMAIL: "+getEmail()+"\n"+  
               "CELULAR: "+getCelular()+"\n";  
        //To change body of generated methods, choose Tools | Templates.
    }
    
}    

 