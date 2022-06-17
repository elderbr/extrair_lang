package br.com.mc.elderbr.smarthopperteste;

import intefarces.Global;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author User
 */
public class Item extends Traducao {

    private int cdItem;
    private String dsItem;
    private List<Item> listItem;

    public Item() {
    }

    public Item(ItemStack itemStack) {
        dsItem = itemStack.getType().getKey().getKey().toLowerCase().replaceAll("_", " ");
    }

    public int getCdItem() {
        return cdItem;
    }

    public void setCdItem(int cdItem) {
        this.cdItem = cdItem;
    }

    public String getDsItem() {
        return dsItem;
    }

    public void setDsItem(String dsItem) {
        this.dsItem = dsItem;
    }   

    public List<Item> getListItemStack() {
        listItem = new ArrayList<>();
        for (Material m : Material.values()) {
            try {
                ItemStack itemStack = new ItemStack(m);
                if (itemStack != null && !m.isAir()) {
                    Item itens = new Item(itemStack);
                    listItem.add(itens);
                    Global.ITEM_NAME.add(itens.getDsItem());
                    System.out.println("item >> " + itens.getDsItem());
                }
            } catch (Exception e) {}
        }
        return listItem;
    }
}
