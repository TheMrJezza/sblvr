package com.jbouchier.pluginsb.abilities;

import com.jbouchier.pluginsb.item.ItemAbility;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class WitherImpact extends ItemAbility {

    private static final PotionEffect[] ABILITY_EFFECTS = {
            new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5),
            new PotionEffect(PotionEffectType.REGENERATION, 100, 3),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3)
    };

    private static final String DESCRIPTION = String.format(
            "Teleport %s%%s blocks %sahead of you. Then implode dealing enormous damage to nearby enemies." +
            " Also applies the wither shield scroll ability reducing damage taken and granting an absorption" +
            " shield for %s5 seconds%s.",
            ChatColor.GREEN, BASE, ChatColor.YELLOW, BASE
    );
    private final int distance;

    public WitherImpact(int distance) {
        super("Ether Transmission", String.format(DESCRIPTION, distance));
        this.distance = distance;
    }

    @Override
    public void executeAbility(@NotNull Player player) {
        Location destination = player.getTargetBlock(null, distance).getLocation();
        if (player.getWorld().getBlockAt(destination.clone().add(0, 1, 0)).getType().isSolid())
            destination = player.getTargetBlock(null, (int) (destination.distance(player.getEyeLocation()) - 2))
                    .getLocation();
        destination.add(0.5, 1, 0.5).setDirection(player.getLocation().getDirection());
        final double distance = player.getLocation().distance(destination);
        if (distance <= 3) {
            player.sendMessage("§cThere are blocks in the way!");
            player.playSound(player.getLocation(), Sound.BLOCK_BREWING_STAND_BREW, 1, 1);
        } else if (distance > 3) {
            player.teleport(destination);
            player.setFallDistance(-Float.MAX_VALUE);
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        }
        for (PotionEffect itEffect : ABILITY_EFFECTS) player.addPotionEffect(itEffect);
        player.setNoDamageTicks(20);
        player.spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 3);
        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.5f, 1f);
        player.getNearbyEntities(8, 8, 8).stream().filter(Damageable.class::isInstance).forEach(e ->
                ((Damageable) e).damage(e instanceof EnderDragon ? 50 : 20)
        );
    }
}