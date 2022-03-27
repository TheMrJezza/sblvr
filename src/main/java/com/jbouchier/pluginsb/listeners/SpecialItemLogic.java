package com.jbouchier.pluginsb.listeners;

import com.jbouchier.pluginsb.item.AbilityItem;
import com.jbouchier.pluginsb.item.ItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpecialItemLogic implements Listener {

    private final ItemManager itemManager;

    public SpecialItemLogic(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @EventHandler
    public void onAbilityUse(PlayerInteractEvent evt) {
        if (evt.getAction() != Action.RIGHT_CLICK_AIR && evt.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (itemManager.findBaseItem(evt.getItem()) instanceof AbilityItem item) {
            if (item.getAbilities().length < 1) return;
            if (evt.getPlayer().isSneaking()) {
                if (item.getAbilities().length < 2) return;
                item.getAbilities()[1].executeAbility(evt.getPlayer());
            } else item.getAbilities()[0].executeAbility(evt.getPlayer());
        }
    }
}