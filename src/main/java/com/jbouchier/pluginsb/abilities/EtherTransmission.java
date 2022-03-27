package com.jbouchier.pluginsb.abilities;

import com.jbouchier.pluginsb.item.ItemAbility;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class EtherTransmission extends ItemAbility {

    private static final PotionEffect[] IT_EFFECTS = {
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100)
    };
    private static final String DESCRIPTION = String.format(
            "Teleport to your targeted block, up to %s%%s blocks %saway.",
            ChatColor.GREEN, BASE
    );

    private final int distance;

    public EtherTransmission(int distance) {
        super("Ether Transmission", String.format(DESCRIPTION, distance));
        this.distance = distance;
    }

    @Override
    public void executeAbility(@NotNull Player player) {
        // Location dest = player.getTargetBlock(null, distance + 1).getLocation().add(0, 0, -2); <- Original Logic.
        Location dest = player.getTargetBlock(null, distance + 1).getLocation();
        if (player.getWorld().getBlockAt(dest.clone().add(0, 1, 0)).getType().isSolid())
            dest = player.getTargetBlock(null, (int) (dest.distance(player.getEyeLocation()) - 2)).getLocation();
        dest.add(0.5, 1, 0.5);
        dest.setDirection(player.getLocation().getDirection());
        player.sendMessage(ChatColor.GREEN + "Whosh!");
        player.teleport(dest);
        player.setFallDistance(-Float.MAX_VALUE);
        for (PotionEffect itEffect : IT_EFFECTS) player.addPotionEffect(itEffect);
    }
}