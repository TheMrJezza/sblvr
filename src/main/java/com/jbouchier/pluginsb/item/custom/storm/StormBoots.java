package com.jbouchier.pluginsb.item.custom.storm;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.item.BaseItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;

public class StormBoots extends BaseItem {

    public StormBoots(ItemManager itemManager) {
        super(itemManager, "Storm Boots", ItemType.BOOTS, Rarity.LEGENDARY, Material.LEATHER_BOOTS);
    }

    @Override
    protected void changeItemMeta(ItemMeta meta, List<String> lore) {

        if (meta instanceof LeatherArmorMeta lmeta)
            lmeta.setColor(Color.fromBGR(0, 102, 0));

        lore.add("§7Damage: §c+260");
        lore.add("§7Strength: §c+150");
        lore.add("§7Intelligence: §a+350");
        lore.add("§7Ferocity: §a+30");
        lore.add("");
    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        ShapedRecipe gbc = new ShapedRecipe(namespace, getBukkitItem());
        gbc.shape("j j", "j j");
        gbc.setIngredient('j', new RecipeChoice.ExactChoice(itemManager.getItem(StormFragment.class)));
        return gbc;
    }
}