/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.especies;

/**
 *
 * @author Luiz-PC
 */
public class EspeciesVO {
    
    private String cod;
    private String descricao;

    public EspeciesVO(String descricao) {
        this.descricao = descricao;
    }

    
    
    public EspeciesVO() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
