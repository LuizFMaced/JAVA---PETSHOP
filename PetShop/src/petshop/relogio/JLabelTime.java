/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.relogio;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author JHUNIOR
 */
public class JLabelTime extends JLabel {  
    //declarando os componentes da janela  
     
      
    //declarando variáveis  
    int hh,mm,ss,pmAm; //*
    Calendar hora; //*Hora  
    DecimalFormat formato; //*  
      
      
    /* abrindo o método construtor da classe  
     * Esse trecho do código [ou da clase] será o resposável pela CONSTRUÇÃO da interface gráfica na memória,   
     * por isso tem esse nome.  
     * o construtor deve ser público e ter o mesmo nome da classe,   
     * lembrando que java é case sensitive, então o nome do construtor deve ser identico ao da classe.  
     */   
      
    public JLabelTime() {  
         
          
        //definindo tamanho e layout da janela  
          
        setSize (100,55);   
        setLayout(new FlowLayout()); //falaremos mais tarde sobre layouts  
                  
        //definindo operação padrão para o botão fechar  
        
          
          
        new JLabel("");//configurando o label inicial  
          
        Timer time = new Timer(1000,ativar);  
        time.start();     
          
    }  
      
    private void HORAS(){  
        hora = Calendar.getInstance();  
        hh = hora.get(Calendar.HOUR_OF_DAY);  
        mm = hora.get(Calendar.MINUTE);  
        ss = hora.get(Calendar.SECOND);  
        pmAm = hora.get(Calendar.AM_PM);
        
        //if(pmAm != Calendar.AM && pmAm != Calendar.PM) 
         setText(formatar(hh)+":"+formatar(mm)+":"+formatar(ss));// Aqui você Monta o moledo do RELÓGIO
       // else
         //setText(formatar(hh)+":"+formatar(mm)+":"+formatar(ss)+" "+(pmAm==Calendar.AM?"am":"pm"));  
              
    }  
  
    private String formatar(int num){  
        formato = new DecimalFormat("00");  
        return formato.format(num);  
    }  
      
    ActionListener ativar = (  
        new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                HORAS();  
            }  
          
        }  
    );
}    
    
          