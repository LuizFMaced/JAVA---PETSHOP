/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.clientes;

import bean.animais.AnimaisVO;
import bean.cpf.CodigoPessoaFisicaVO;
import bean.dependentes.DependentesVO;
import bean.enderecos.EnderecosVO;
import bean.registro_geral.RegistroGeralVO;


/**
 *
 * @author 28233708
 */
public class ClientesVO {
    private int cod, num_resid;
    private String nome, email, tipo, foto, telefone, celular, sexo;
    private RegistroGeralVO rg;
    private CodigoPessoaFisicaVO cpf;
    private EnderecosVO cep;
    private AnimaisVO animal;
    private DependentesVO dependente;

    public ClientesVO() {
    }

    public ClientesVO(int num_resid, String nome, String email, String tipo, String foto, String telefone, String celular, String sexo, RegistroGeralVO rg, CodigoPessoaFisicaVO cpf, EnderecosVO cep, AnimaisVO animal, DependentesVO dependente) {
        this.num_resid = num_resid;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.foto = foto;
        this.telefone = telefone;
        this.celular = celular;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
        this.animal = animal;
        this.dependente = dependente;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public RegistroGeralVO getRg() {
        return rg;
    }

    public void setRg(RegistroGeralVO rg) {
        this.rg = rg;
    }

    public CodigoPessoaFisicaVO getCpf() {
        return cpf;
    }

    public void setCpf(CodigoPessoaFisicaVO cpf) {
        this.cpf = cpf;
    }

    public EnderecosVO getCep() {
        return cep;
    }

    public void setCep(EnderecosVO cep) {
        this.cep = cep;
    }

    public AnimaisVO getAnimal() {
        return animal;
    }

    public void setAnimal(AnimaisVO animal) {
        this.animal = animal;
    }

    public DependentesVO getDependente() {
        return dependente;
    }

    public void setDependente(DependentesVO dependente) {
        this.dependente = dependente;
    }

    @Override
    public String toString() {
        return "NOME: "+getNome()+"\n"+
               "TIPO: "+getTipo()+"\n"+ 
               "CPF: "+getCpf().getCpf()+"\n"+ 
               "P: "+getCpf().getTipo()+"\n"+
               "RG:"+getRg().getRg()+"\n"+ 
               "SEXO: "+getSexo()+"\n"+
               "CEP: "+getCep().getCep()+"\n"+
               "EMAIL: "+getEmail()+"\n"+ 
               //"ENDERECO: "+getCep().getEndereco()+"\n"+
               "N°:  "+getNum_resid()+"\n"+
               //"BAIRRO: "+getCep().getBairro()+"\n"+
               //"ESTADO: "+getCep().getEstado().getNome()+"\n"+
               //"CIDADE: "+getCep().getCidade().getNome()+"\n"+
               "TEL: "+getTelefone()+"\n"+ 
               "CEL: "+getCelular()+"\n"; 
        //To change body of generated methods, choose Tools | Templates.
    }

    
}
   