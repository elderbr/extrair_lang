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
    
    public void a(){
         try {
            list = new ArrayList<>();
            for (Material material : Material.values()) {
                item = new Item();
                if (material.isItem() && !material.isAir()) {
                    item.parse(material);
                    if (!item.toString().contains("spawn egg")) {
                        list.add(material.getKey().getKey()+": "+item.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro >> " + e.getMessage());
        }

        Collections.sort(list);

        try (BufferedWriter w = Files.newBufferedWriter(new File("C:\\Users\\elder\\Documents\\Minecraft\\lang", "item.yml").toPath(), StandardCharsets.UTF_8)) {
            int row = 1;
            for (String item : list) {
                w.write(item);
                w.newLine();
                w.flush();
                System.out.println("item >> " + item);
                row++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os itens!");
        }

    }

}
