package com.jbouchier.pluginsb.abilities;

import com.jbouchier.pluginsb.item.ItemAbility;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class InstantTransmission extends ItemAbility {

    private static final PotionEffect[] IT_EFFECTS = {
            new PotionEffect(PotionEffectType.SPEED, 100, 1),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100)
    };
    private static final Sound EFFECT_SOUND = Sound.ENTITY_ENDERMAN_TELEPORT;
    private static final String DESCRIPTION = String.format(
            "Teleport %s%%s blocks %sahead of you and gain %s+50 %sSpeed for %s5 seconds%s.",
            ChatColor.GREEN, BASE, ChatColor.GREEN, ChatColor.WHITE, ChatColor.GREEN, BASE
    );

    private final int distance;

    public InstantTransmission(int distance) {
        super("Instant Transmission", String.format(DESCRIPTION, distance));
        this.distance = distance;
    }

    @Override
    public void executeAbility(@NotNull Player player) {
        Block block = player.getTargetBlock(null, distance);
        if (block.getRelative(BlockFace.UP).getType().isSolid()) {
            block = player.getTargetBlock(null, (int) (block.getLocation().distance(player.getEyeLocation()) - 2));
        }
        double distance = block.getLocation().distance(player.getLocation());
        if (distance > 3) {
            player.teleport(block.getLocation().add(0.5, 1, 0.5).setDirection(player.getLocation().getDirection()));
            player.playSound(block.getLocation(), EFFECT_SOUND, 1, 1);
            for (PotionEffect itEffect : IT_EFFECTS) player.addPotionEffect(itEffect);
        } else player.sendMessage(String.format("%sThere are blocks in the way!", ChatColor.RED));
    }
}