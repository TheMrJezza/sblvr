package com.jbouchier.pluginsb.item.custom.storm;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.item.BaseItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class StormFragment extends BaseItem {
    public StormFragment(ItemManager itemManager) {
        super(itemManager, "Storm Fragment", ItemType.ARTIFACT, Rarity.EPIC, Material.BLUE_DYE);
    }

    protected void changeItemMeta(ItemMeta meta, List<String> lore) {

    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        return null;
    }
}