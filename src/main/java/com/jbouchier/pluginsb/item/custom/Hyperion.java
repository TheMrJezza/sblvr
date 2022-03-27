package com.jbouchier.pluginsb.item.custom;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.abilities.WitherImpact;
import com.jbouchier.pluginsb.item.AbilityItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Hyperion extends AbilityItem {

    public Hyperion(ItemManager itemManager) {
        super(itemManager, "Hyperion", ItemType.SWORD, Rarity.LEGENDARY, Material.IRON_SWORD, new WitherImpact(10));
    }

    @Override
    public ShapedRecipe getRecipe(NamespacedKey namespace) {
        ShapedRecipe hyper = new ShapedRecipe(namespace, getBukkitItem());
        hyper.shape(" e ", " v ", " m ");
        hyper.setIngredient('e', new RecipeChoice.ExactChoice(itemManager.getItem(AspectOfTheEnd.class)));
        hyper.setIngredient('v', new RecipeChoice.ExactChoice(itemManager.getItem(AspectOfTheVoid.class)));
        hyper.setIngredient('m', new RecipeChoice.ExactChoice(itemManager.getItem(ModifiedAspectOfTheVoid.class)));
        return hyper;
    }
}