package com.jbouchier.pluginsb.item;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class ItemAbility {
    public static final ChatColor BASE = ChatColor.GRAY;
    private final String abilityName;
    private final String description;

    public ItemAbility(@NotNull String abilityID, @NotNull String description) {
        this.abilityName = abilityID;
        this.description = description;
    }

    public @NotNull String getAbilityName() {
        return this.abilityName;
    }

    public @NotNull String getDescription() {
        return this.description;
    }

    public abstract void executeAbility(@NotNull Player player);
}