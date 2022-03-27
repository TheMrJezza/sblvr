package com.jbouchier.pluginsb.item.custom;

import com.jbouchier.pluginsb.Rarity;
import com.jbouchier.pluginsb.abilities.EtherTransmission;
import com.jbouchier.pluginsb.abilities.InstantTransmission;
import com.jbouchier.pluginsb.item.AbilityItem;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.ItemType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class ModifiedAspectOfTheVoid extends AbilityItem {

    // DAMAGE + 120
    // STRENGTH + 100

    public ModifiedAspectOfTheVoid(ItemManager itemManager) {
        super(itemManager, "Aspect Of The Void", "Modified Aspect Of The Void", ItemType.SWORD, Rarity.EPIC, Material.DIAMOND_SHOVEL,
                new InstantTransmission(10), new EtherTransmission(60));
    }

    @Override
    protected ShapedRecipe getRecipe(NamespacedKey namespace) {
        return null;
    }
}