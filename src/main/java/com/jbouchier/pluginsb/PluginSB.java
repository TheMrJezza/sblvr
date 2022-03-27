package com.jbouchier.pluginsb;

import com.jbouchier.pluginsb.item.ItemManager;
import com.jbouchier.pluginsb.item.custom.AspectOfTheEnd;
import com.jbouchier.pluginsb.item.custom.AspectOfTheVoid;
import com.jbouchier.pluginsb.item.custom.Hyperion;
import com.jbouchier.pluginsb.item.custom.ModifiedAspectOfTheVoid;
import com.jbouchier.pluginsb.item.custom.goldor.GoldorFragment;
import com.jbouchier.pluginsb.item.custom.necrolord.NecrolordFragment;
import com.jbouchier.pluginsb.item.custom.necron.NecronFragment;
import com.jbouchier.pluginsb.item.custom.storm.StormFragment;
import com.jbouchier.pluginsb.listeners.DragonDeathDrops;
import com.jbouchier.pluginsb.listeners.DragonSpawnTypes;
import com.jbouchier.pluginsb.listeners.SpecialItemLogic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class PluginSB extends JavaPlugin {

    private final ItemManager im = new ItemManager(this);

    @Override
    public void onEnable() {
        getLogger().info("Sup fucker");
        bulkRegister(new SpecialItemLogic(im), new DragonSpawnTypes(), new DragonDeathDrops(im));
        // assignExecutor(new ItemCommands(), "giveAOTE", "giveAOTE", "giveAOTVM", "giveHYPE", "giveFRAGS");
    }

    private void bulkRegister(Listener... listeners) {
        for (Listener l : listeners) getServer().getPluginManager().registerEvents(l, this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender cs, @NotNull Command cmd,
                             @NotNull String alias, @NotNull String[] args) {
        if (cs instanceof Player player) {
            Inventory inventory = player.getInventory();
            if (cmd.getName().equalsIgnoreCase("giveFRAGS")) {
                ItemStack[] frags = {
                        im.getItem(GoldorFragment.class), im.getItem(StormFragment.class),
                        im.getItem(NecrolordFragment.class), im.getItem(NecronFragment.class)
                };
                for (ItemStack frag : frags) {
                    if (inventory.firstEmpty() < 0) player.getWorld().dropItem(player.getLocation(), frag);
                    else inventory.addItem(frag);
                }
                return true;
            }
            ItemStack item;
            if (cmd.getName().equalsIgnoreCase("giveAOTE")) {
                item = im.getItem(AspectOfTheEnd.class);
            } else if (cmd.getName().equalsIgnoreCase("giveAOTV")) {
                item = im.getItem(AspectOfTheVoid.class);
            } else if (cmd.getName().equalsIgnoreCase("giveAOTVM")) {
                item = im.getItem(ModifiedAspectOfTheVoid.class);
            } else item = im.getItem(Hyperion.class);
            inventory.addItem(item);
        } else cs.sendMessage("LOL IMAGINE DOING THIS!!1!");
        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Soz i brb need go comit die");
    }
}