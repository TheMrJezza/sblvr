package me.lavarite.pluginsb.Items.Commands;

import me.lavarite.pluginsb.Items.ItemStorage.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage("LOL IMAGINE DOING THIS!!1!");
        }
        assert sender instanceof Player;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("giveAOTE")) {
            player.getInventory().addItem(AOTE.ASPECT_OF_THE_END);
        }
        if (cmd.getName().equalsIgnoreCase("giveAOTV")){
            player.getInventory().addItem(AOTV.ASPECT_OF_THE_VOID);
        }
        if (cmd.getName().equalsIgnoreCase("giveAOTVM")){
            player.getInventory().addItem(AOTM.MODIFIED_ASPECT_OF_THE_VOID);
        }
        if (cmd.getName().equalsIgnoreCase("giveHYPE")){
            player.getInventory().addItem(HYPE.HYPERION);
        }
        if (cmd.getName().equalsIgnoreCase("giveFRAGS")){
            player.getInventory().addItem(strgDrag.GOLDOR_FRAG, strgDrag.STORM_FRAG, strgDrag.NECRON_FRAG, strgDrag.LORD_FRAG);
        }
        return true;
    }
}
