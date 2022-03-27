package com.jbouchier.pluginsb.item.custom;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.item.BaseItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import com.jbouchier.pluginsb.item.custom.goldor.GoldorFragment;
import com.jbouchier.pluginsb.item.custom.necrolord.NecrolordFragment;
import com.jbouchier.pluginsb.item.custom.necron.NecronFragment;
import com.jbouchier.pluginsb.item.custom.storm.StormFragment;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class DragonCore extends BaseItem {
    public DragonCore(ItemManager itemManager) {
        super(itemManager, "Dragon Core", ItemType.ARTIFACT, Rarity.LEGENDARY, Material.BEACON);
    }

    @Override
    protected void changeItemMeta(ItemMeta meta, List<String> lore) {

    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        ShapedRecipe dcc = new ShapedRecipe(namespace, getBukkitItem());
        dcc.shape(" g ", "sln");
        dcc.setIngredient('g', new RecipeChoice.ExactChoice(itemManager.getItem(GoldorFragment.class)));
        dcc.setIngredient('s', new RecipeChoice.ExactChoice(itemManager.getItem(StormFragment.class)));
        dcc.setIngredient('n', new RecipeChoice.ExactChoice(itemManager.getItem(NecronFragment.class)));
        dcc.setIngredient('l', new RecipeChoice.ExactChoice(itemManager.getItem(NecrolordFragment.class)));
        return dcc;
    }
}
