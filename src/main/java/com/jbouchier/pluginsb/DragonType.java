package com.jbouchier.pluginsb;

import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;

public enum DragonType {
    ENDER_DRAGON(ChatColor.DARK_PURPLE, 500),
    NECROLORD_DRAGON(ChatColor.GOLD, 1500),
    STORM_DRAGON(ChatColor.DARK_AQUA, 750),
    GOLDOR_DRAGON(ChatColor.DARK_GREEN, 2000),
    NECRON_DRAGON(ChatColor.RED, 750);

    public final String DRAGON_NAME;
    public final double MAX_HEALTH;

    DragonType(ChatColor colour, double health) {
        this.DRAGON_NAME = "" + colour + ChatColor.BOLD + translate(name());
        this.MAX_HEALTH = health;
    }

    private static String translate(String string) {
        String[] parts = string.toLowerCase().trim().split("_");
        StringBuilder result = new StringBuilder();
        for (String part : parts)
            result.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static DragonType fromDragon(EnderDragon dragon) {
        String name = dragon.getCustomName();
        if (name == null) return null;
        for (DragonType type : values()) if (type.DRAGON_NAME.equals(name)) return type;
        return null;
    }
}
