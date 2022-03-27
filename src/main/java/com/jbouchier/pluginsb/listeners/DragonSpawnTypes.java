package com.jbouchier.pluginsb.listeners;

import com.jbouchier.pluginsb.DragonType;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.concurrent.ThreadLocalRandom;

public class DragonSpawnTypes implements Listener {

    @EventHandler
    public void DragonTypesInit(CreatureSpawnEvent evt) {
        if (evt.getEntity() instanceof EnderDragon dragon) {
            final int random = ThreadLocalRandom.current().nextInt(100);
            DragonType dType = DragonType.ENDER_DRAGON;
            if (random == 0) dType = DragonType.NECROLORD_DRAGON;
            else if (random <= 10) dType = DragonType.NECRON_DRAGON;
            else if (random <= 30) dType = DragonType.STORM_DRAGON;
            else if (random <= 58) dType = DragonType.GOLDOR_DRAGON;
            dragon.setCustomName(dType.DRAGON_NAME);
            dragon.setCustomNameVisible(true);
            AttributeInstance maxHealth = dragon.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (maxHealth != null) {
                maxHealth.setBaseValue(dType.MAX_HEALTH);
                dragon.setHealth(dType.MAX_HEALTH);
            }
        }
    }
}