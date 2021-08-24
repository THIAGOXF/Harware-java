/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class hardware 
{
    public ArrayList<String> hards = new ArrayList(); //create array -hards, type -String
    
    public ArrayList<String> backup = new ArrayList(); //backup array
    
    public void adicionar(String hard) //add value to array
    {
        hards.add(hard.toUpperCase()); //save value to array
        
        JOptionPane.showMessageDialog(null, "O registro " + hard + " foi adicionado com sucesso");
    }
    
    public String listarHards() //list values from array
    {
        String rel = "Items\n\n=================================\n\n";
        
        if(!hards.isEmpty()) //check if is NOT empty
        {
            for(int i = 0; i < hards.size(); i++) //loop
            {
                rel += (i + 1) + " - " + hards.get(i) + "\n";
            }
        }
        else
        {
            rel = "Base vazia"; //out insucess
        }
        return rel; //return values
    }  
    
    public void eliminar() //delete all values
    {
        if(!hards.isEmpty()) //checks if is NOT empty
        {
            if(JOptionPane.showConfirmDialog(null, "Apagar?", "Eliminar base", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION)
            {
                hards.clear(); //deletes values
                JOptionPane.showMessageDialog(null, "Base eliminada com sucesso"); //out sucess
            }
            else
            {
                JOptionPane.showMessageDialog(null, "A base nao foi apagada"); //out canceled
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Base vazia"); //out insucess
        }
    }
    
    public boolean returnVazio()
    {
        return hards.isEmpty();
    }
    
    public int pesquisar(String nome) //search values in list
    {
            boolean flag = false; //variables
            int i = 0;
            int ind = -1;
            
            while(i < hards.size() && !(flag)) //check if values exists && flag(found) is true
            {
                if(hards.get(i).equals(nome.toUpperCase())) //compares to name searched
                {
                    flag = true; //found search, stops loop
                    ind = i;
                }
                
                i++;
            }
            
            return ind;
    }
    
    public void excluir(int i) //delete specific value
    {
        hards.remove(i);    
    }
    
    public void editar(int i, String novoNome) //edit value
    {
        hards.set(i, novoNome);
    }
    
    public void backup()
    {
        if(!hards.isEmpty()) //checks if is NOT empty
        {
            if(JOptionPane.showConfirmDialog(null, "Fazer backup?", "Backup", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION)
            {
                backup = (ArrayList<String>) hards.clone();
                JOptionPane.showMessageDialog(null, "Backup feito com sucesso"); //out sucess
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Operacao cancelada"); //out canceled
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Base vazia"); //out insucess
        }
    }
    
    public void restaurar()
    {
        if(JOptionPane.showConfirmDialog(null, "Restaurar base?", "Restaurar", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION)
        {
            hards = (ArrayList<String>) backup.clone();
            JOptionPane.showMessageDialog(null, "Restauração feita com sucesso"); //out sucess
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Operacao cancelada"); //out canceled
        }
    }

    
    public void ordenar()
    {
        Collections.sort(hards); //a-z
        JOptionPane.showMessageDialog(null, "Ordenado de forma crescente"); //out sucess
    }
    
    public void desordenar()
    {
        Collections.sort(hards, Collections.reverseOrder()); //z-a
        JOptionPane.showMessageDialog(null, "Ordenado de forma decrescente"); //out sucess
    }
    
    public void abrirNotas()
    {
        Runtime abrir = Runtime.getRuntime();
 
        try
        {
            abrir.exec("notepad.exe");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
