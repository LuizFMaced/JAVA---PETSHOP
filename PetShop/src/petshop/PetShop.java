/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ //29-09 19:49
package petshop;


import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
//import petshop.login.LoginView;



/**
 *
 * @author 28233708
 */
public class PetShop {

    /**
     * @param args the command line arguments
     */

 //
    public static void main(String[] args) {
    try{
         Properties props = new Properties();
            props.put("logoString", "Petshop");
          McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
    }catch(Exception erro){
        erro.getStackTrace();
    }    
       /*LoginView log = new LoginView();
        log.setVisible(true);*/
        
      PetShopView obj = new PetShopView();
        obj.setVisible(true);

   }
    
}
