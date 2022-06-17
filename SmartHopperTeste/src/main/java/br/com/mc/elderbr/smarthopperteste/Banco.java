/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mc.elderbr.smarthopperteste;

import intefarces.Dados;
import intefarces.Querys;

/**
 *
 * @author User
 */
public class Banco {

    private Dados obj;        

    public Banco(Dados obj) {
        this.obj = obj;
    }
    
    public void setObjecto(Dados dados){
        this.obj = dados;
    }

    public void salvar(Querys query) {
        query.insert(obj);
    }
    
    public Object buscar(Querys query){
        return query.select(obj);
    }
    
    public void delete(Querys query){
        query.delete(obj);
    }

}
