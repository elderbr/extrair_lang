/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elderbr.mc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.elderbr.mc.model.Item;
import com.elderbr.mc.util.Langs;
import com.elderbr.mc.view.ViewHome;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;
import javax.swing.filechooser.FileSystemView;
import org.bukkit.Material;

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
