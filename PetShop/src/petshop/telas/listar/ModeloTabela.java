/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.telas.listar;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz-PC
 */
public class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public ModeloTabela(ArrayList linhas, String[] colunas){
        setLinhas(linhas);
        setColunas(colunas);
    }
    
    public ArrayList getLinhas(){
        return linhas;
    }
    
    public void setLinhas(ArrayList dados){
        this.linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        this.colunas = nomes;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    
    public String getColumnName(int numColunas){
        return colunas[numColunas];
    }
    
    public Object getValueAt(int numLinhas, int numColunas){
        Object[] linha = (Object[]) getLinhas().get(numLinhas);
        return linha[numColunas];
    }
            
}
