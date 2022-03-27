package com.jbouchier.pluginsb.item.custom.necron;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.item.BaseItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class NecronFragment extends BaseItem {
    public NecronFragment(ItemManager itemManager) {
        super(itemManager, "Necron Fragment", ItemType.ARTIFACT, Rarity.EPIC, Material.RED_DYE);
    }

    protected void changeItemMeta(ItemMeta meta, List<String> lore) {

    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        return null;
    }
}