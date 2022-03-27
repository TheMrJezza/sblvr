package com.jbouchier.pluginsb.item;

import com.jbouchier.pluginsb.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbilityItem extends BaseItem {
    private static final String[] ABILITY_USAGE = {"RIGHT CLICK", "SHIFT RIGHT CLICK", "UNUSED ABILITY"};
    private final ItemAbility[] abilities;

    public AbilityItem(@NotNull ItemManager itemManager, @NotNull String name, String loreName, @NotNull ItemType itemClass, @NotNull Rarity rarity,
                       @NotNull Material material, @NotNull ItemAbility... itemAbilities) {
        super(itemManager, name, loreName, itemClass, rarity, material);
        this.abilities = itemAbilities;
        updateMeta();
    }

    public AbilityItem(@NotNull ItemManager itemManager, @NotNull String name, @NotNull ItemType itemClass, @NotNull Rarity rarity,
                       @NotNull Material material, @NotNull ItemAbility... itemAbilities) {
        this(itemManager, name, null, itemClass, rarity, material, itemAbilities);
    }

    private static List<String> splitLore(String input, int length) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        int line = 0;
        for (String part : input.split(" ")) {
            int size = ChatColor.stripColor(part).length();
            if (size > length) {
                if (line > 0) result.add(ItemAbility.BASE + sb.toString().trim());
                result.add(ItemAbility.BASE + part);
                line = 0;
                sb = new StringBuilder();
            } else {
                if (line + size <= length) {
                    sb.append(part).append(" ");
                    line += size + 1;
                } else {
                    result.add(ItemAbility.BASE + sb.toString().trim());
                    sb = new StringBuilder(part + " ");
                    line = size + 1;
                }
            }
        }
        if (line > 0) result.add(ItemAbility.BASE + sb.toString().trim());
        return result;
    }

    public final @NotNull
    ItemAbility[] getAbilities() {
        return this.abilities.clone();
    }

    @Override
    protected void changeItemMeta(ItemMeta meta, List<String> lore) {
        short i = 0;
        for (ItemAbility ability : abilities) {
            lore.add(String.format("%sAbility: %s %s%s%s", ChatColor.GOLD,
                    ability.getAbilityName(), ChatColor.RED, ChatColor.BOLD, ABILITY_USAGE[i]));
            lore.addAll(splitLore(ability.getDescription(), 35));
            lore.add("");
            if (i < 2) i++;
        }
    }
}