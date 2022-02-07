/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elderbr.mc;

import java.util.List;
import com.elderbr.mc.model.Item;
import com.elderbr.mc.view.ViewHome;

/**
 *
 * @author elder
 */
public class LangHome {

    private Item item;
    private List<String> list;

    public static void main(String[] args) {
        new LangHome();
    }

    public LangHome() {
        
        ViewHome home = new ViewHome();
        home.setVisible(true);  
        
       
    } 

}
