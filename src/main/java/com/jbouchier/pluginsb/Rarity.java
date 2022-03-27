package com.jbouchier.pluginsb;

import org.bukkit.ChatColor;

public enum Rarity {

    LEGENDARY(ChatColor.GOLD),
    EPIC(ChatColor.DARK_PURPLE),
    RARE(ChatColor.BLUE);

    public final ChatColor colour;

    Rarity(ChatColor colour) {
        this.colour = colour;
    }
}