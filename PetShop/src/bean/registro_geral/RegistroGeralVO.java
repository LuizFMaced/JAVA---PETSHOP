/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.registro_geral;

import bean.uf.UnidadesFederaisVO;

/**
 *
 * @author Luiz-PC
 */
public class RegistroGeralVO {
    private String rg;
    private UnidadesFederaisVO uf;

    public RegistroGeralVO() {
    }

    public RegistroGeralVO(String rg, UnidadesFederaisVO uf) {
        this.rg = rg;
        this.uf = uf;
    }

    

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
}
