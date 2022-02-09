package br.com.desktop.elderbr.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author ElderBR
 */
public class Item {
    private String nome;
    private List<String> list;
    
     public Item() {
        nome = "";
    }    
    
    public Item(String nome) {
        this.nome = nome;
    }
    
    public String parse(Material material){
        this.nome = material.getKey().getKey().replaceAll("_", " ");
        return this.nome;
    }
    
    public static String ToString(Material material){
        return material.getKey().getKey().replaceAll("_", " ");
    }
    
    public String parse(ItemStack item){
        this.nome = item.getType().getKey().getKey().replaceAll("_", " ");
        return this.nome;
    }
    
    public List<String> add(String material){
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(material);
        return list;
    }
    
    public List<String> getList(){
        Collections.sort(list);
        return list;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    

}
