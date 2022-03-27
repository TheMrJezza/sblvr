package com.jbouchier.pluginsb.item.custom;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.abilities.InstantTransmission;
import com.jbouchier.pluginsb.item.AbilityItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class AspectOfTheEnd extends AbilityItem {
    // DAMAGE + 100
    // STRENGTH + 100

    public AspectOfTheEnd(ItemManager itemManager) {
        super(itemManager, "Aspect Of The End", ItemType.SWORD, Rarity.RARE, Material.DIAMOND_SWORD,
                new InstantTransmission(5));
    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        return null;
    }
}
