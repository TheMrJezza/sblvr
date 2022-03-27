package com.jbouchier.pluginsb.listeners;

import com.jbouchier.pluginsb.DragonType;
import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.custom.AspectOfTheEnd;
import com.jbouchier.pluginsb.item.custom.goldor.GoldorFragment;
import com.jbouchier.pluginsb.item.custom.necrolord.NecrolordFragment;
import com.jbouchier.pluginsb.item.custom.necron.NecronFragment;
import com.jbouchier.pluginsb.item.custom.storm.StormFragment;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class DragonDeathDrops implements Listener {

    private final ItemManager itemManager;

    public DragonDeathDrops(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @EventHandler
    public void dragDeath(EntityDeathEvent evt) {
        if (evt.getEntity() instanceof EnderDragon drag) {
            DragonType dragonType = DragonType.fromDragon(drag);
            if (dragonType == null) return;
            int random = ThreadLocalRandom.current().nextInt(100);
            if (random >= 5) return;
            ItemStack drop;
            switch (dragonType) {
                case ENDER_DRAGON -> {
                    if (random >= 3) return;
                    drop = itemManager.getItem(AspectOfTheEnd.class);
                }
                case NECROLORD_DRAGON -> {
                    if (random >= 3) return;
                    drop = itemManager.getItem(NecrolordFragment.class);
                }
                case STORM_DRAGON -> drop = itemManager.getItem(StormFragment.class);
                case GOLDOR_DRAGON -> drop = itemManager.getItem(GoldorFragment.class);
                default -> drop = itemManager.getItem(NecronFragment.class);
            }
            drag.getWorld().dropItem(drag.getLocation(), drop);
        }
    }
}
