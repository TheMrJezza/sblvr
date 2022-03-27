package com.jbouchier.pluginsb.item;

import com.jbouchier.pluginsb.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseItem {

    protected final ItemManager itemManager;
    private final String name;
    private final ItemType itemClass;
    private final Rarity rarity;
    private final ItemStack bukkitItem;
    private final List<String> lore = new ArrayList<>();

    public BaseItem(ItemManager itemManager, String name, String loreName, ItemType itemClass, Rarity rarity, Material material) {
        this.itemManager = itemManager;
        this.name = name;
        this.itemClass = itemClass;
        this.rarity = rarity;
        this.bukkitItem = new ItemStack(material);

        ItemMeta meta = bukkitItem.getItemMeta();
        if (meta == null) return;

        meta.setUnbreakable(true);
        meta.setDisplayName(rarity.colour + name);

        lore.add("");
        if (loreName == null) loreName = name;
        String splitter = "A";
        switch (Character.toLowerCase(loreName.charAt(0))) {
            case 'a', 'e', 'i', 'o', 'u' -> splitter += "n ";
            default -> splitter += " ";
        }

        lore.add(ChatColor.WHITE + splitter + loreName);
        lore.add("");
        lore.add("" + rarity.colour + ChatColor.BOLD + rarity.name() + " " + itemClass.name());
        meta.setLore(lore);
        bukkitItem.setItemMeta(meta);
        itemManager.registerItem(this);

        if (this instanceof AbilityItem) return;
        updateMeta();
    }

    public BaseItem(ItemManager itemManager, String name, ItemType itemClass, Rarity rarity, Material material) {
        this(itemManager, name, null, itemClass, rarity, material);
    }


    public List<String> getLore() {
        return new ArrayList<>(lore);
    }

    public final String getName() {
        return this.name;
    }

    public final Rarity getRarity() {
        return this.rarity;
    }

    public final ItemType getItemType() {
        return this.itemClass;
    }

    public final ItemStack getBukkitItem() {
        return this.bukkitItem;
    }

    protected final void updateMeta() {
        ItemMeta meta = bukkitItem.getItemMeta();
        if (meta == null) return;
        List<String> toAdd = new ArrayList<>();
        changeItemMeta(meta, toAdd);
        int i = lore.size() - 1;
        //lore.add(i++, "");
        for (String line : toAdd) lore.add(i++, line);
        meta.setLore(lore);
        bukkitItem.setItemMeta(meta);
    }

    protected abstract void changeItemMeta(ItemMeta meta, List<String> lore);

    protected abstract ShapedRecipe getRecipe(NamespacedKey namespace);
}