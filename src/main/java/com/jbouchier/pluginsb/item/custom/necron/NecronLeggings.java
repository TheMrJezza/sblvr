package com.jbouchier.pluginsb.item.custom.necron;

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

public class NecronLeggings extends BaseItem {

    public NecronLeggings(ItemManager itemManager) {
        super(itemManager, "Necron Leggings", ItemType.LEGGINGS, Rarity.LEGENDARY, Material.LEATHER_LEGGINGS);
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
        ShapedRecipe glc = new ShapedRecipe(namespace, getBukkitItem());
        glc.shape("ggg", "g g", "g g");
        glc.setIngredient('g', new RecipeChoice.ExactChoice(itemManager.getItem(NecronFragment.class)));
        return glc;
    }
}
