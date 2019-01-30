/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.login;

/**
 *
 * @author 28233708
 */
public class LoginVO {
    private String usuario;
    private String senha;
    private boolean admin;
    
    public LoginVO(){
        usuario = "luiz";
        senha = "root";
        admin = true;
    }
      
    public String getUser(){
        return this.usuario;
    }
    
    public void setUser(String tmpUser){
        this.usuario = tmpUser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public boolean validarLogin(String tmpUser, String tmpSenha){
        if (!"".equals(tmpUser) && !"".equals(tmpSenha)) {
          if(getUser().equals(tmpUser) && getSenha().equals(tmpSenha))
              return true;
            else
                return false;
        }
        return false;
    }
    
        
}
