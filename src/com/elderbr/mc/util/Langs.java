/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elderbr.mc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author elder
 */
public class Langs extends DefaultComboBoxModel<String>{

    private String sistema;
    
    private File fileLangList = new File("C:\\Users\\elder\\AppData\\Roaming\\.minecraft\\assets\\virtual\\legacy\\lang");
    private List<String> listLang;
    
    public Langs() {                
        
        // Pegando a lista de langs
        if(fileLangList.exists()){
            listLang = new ArrayList<>();
            for(File files : fileLangList.listFiles()){
                listLang.add(files.getName().replaceAll(".lang", "").trim().toLowerCase());
            }
        }       
        
    }    

    @Override
    public String getElementAt(int index) {
        return listLang.get(index);
    }

    @Override
    public int getSize() {
        return listLang.size();
    }
    
}
