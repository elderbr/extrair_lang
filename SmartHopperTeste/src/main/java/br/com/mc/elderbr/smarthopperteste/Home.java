package br.com.mc.elderbr.smarthopperteste;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

/**
 *
 * @author User
 */
public class Home{

    public static void main(String[] args) {
        new Home();
    }

    public Home() {

        for(Material material : Material.values()){
            ItemStack itemStack = new ItemStack(material);
            if(itemStack!=null && itemStack.getType().isItem()){
                System.out.println("item >> "+ itemStack.getType().getKey().getKey());
            }
        }

    }

}
