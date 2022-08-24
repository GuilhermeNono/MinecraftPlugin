package me.miningplugin.mining.Listeners;

import me.miningplugin.mining.Mining;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class BreakBlockListener implements Listener {

    private final Mining instance;

    public BreakBlockListener(Mining instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Material materialBlock = block.getType();

        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemStack = new ItemStack(Material.IRON_ORE, 1);

        long timeInSeconds = 2L;

        long timeInTicks = 20 * timeInSeconds;

        if(materialBlock.equals(Material.IRON_ORE) && itemInMainHand.equals(new ItemStack(Material.IRON_PICKAXE))){
            e.setCancelled(true);
            player.getInventory().addItem(itemStack);
            block.setType(Material.BEDROCK);
            new BukkitRunnable() {
                @Override
                public void run() {
                    block.setType(Material.IRON_ORE);
                }
            }.runTaskLater(instance, timeInTicks);

        }



    }
}
