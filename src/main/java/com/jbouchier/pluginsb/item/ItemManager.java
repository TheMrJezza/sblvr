package com.jbouchier.pluginsb.item;

import com.jbouchier.pluginsb.PluginSB;
import com.jbouchier.pluginsb.item.custom.*;
import com.jbouchier.pluginsb.item.custom.goldor.*;
import com.jbouchier.pluginsb.item.custom.necrolord.*;
import com.jbouchier.pluginsb.item.custom.necron.*;
import com.jbouchier.pluginsb.item.custom.storm.*;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Objects;

public class ItemManager {

    private final HashSet<BaseItem> itemStore = new HashSet<>();

    // TODO Implement item creation via json files.
    /* private final Path itemPath = plugin.getDataFolder().toPath().resolve("Items"); */

    private final PluginSB plugin;

    public ItemManager(PluginSB plugin) {
        this.plugin = plugin;

        // Add items here.
        new GoldorFragment(this);
        new StormFragment(this);
        new NecrolordFragment(this);
        new NecronFragment(this);
        new DragonCore(this);
        new GoldorBoots(this);
        new GoldorChestplate(this);
        new GoldorHelmet(this);
        new GoldorLeggings(this);
        new StormBoots(this);
        new StormChestplate(this);
        new StormHelmet(this);
        new StormLeggings(this);
        new NecrolordBoots(this);
        new NecrolordChestplate(this);
        new NecrolordHelmet(this);
        new NecrolordLeggings(this);
        new NecronBoots(this);
        new NecronChestplate(this);
        new NecronHelmet(this);
        new NecronLeggings(this);
        new AspectOfTheEnd(this);
        new ModifiedAspectOfTheVoid(this);
        new AspectOfTheVoid(this);
        new Hyperion(this);

        buildRecipes();
        /*try {
            reloadItems();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /*public void reloadItems() throws IOException {
        if (Files.exists(itemPath)) {
            Files.list(itemPath).filter(p -> p.endsWith(".json")).forEach(this::tryLoad);
        } else {
            Files.createDirectories(itemPath);
        }
    }

    private void tryLoad(Path jsonPath) {

    }*/

    public BaseItem findBaseItem(ItemStack bukkitItem) {
        if (bukkitItem == null || !bukkitItem.hasItemMeta()) return null;
        ItemMeta meta = bukkitItem.getItemMeta();
        assert meta != null;
        if (!meta.hasLore()) return null;
        for (BaseItem bi : itemStore) if (bi.getLore().equals(meta.getLore())) return bi;
        return null;
    }

    public ItemStack getItem(Class<? extends BaseItem> clazz) {
        for (BaseItem bi : itemStore) if (bi.getClass().equals(clazz)) return bi.getBukkitItem();
        return null;
    }

    void registerItem(BaseItem item) {
        itemStore.add(item);
    }

    private void buildRecipes() {
        itemStore.stream().map(i -> i.getRecipe(new NamespacedKey(
                        plugin, "recipe." + i.getName().toLowerCase().replace(" ", "_"))))
                .filter(Objects::nonNull).forEach(recipe -> Bukkit.getServer().addRecipe(recipe));
    }
}