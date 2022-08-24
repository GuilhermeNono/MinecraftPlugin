package me.miningplugin.mining;

import me.miningplugin.mining.Listeners.BreakBlockListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mining extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin iniciado");
        getServer().getPluginManager().registerEvents(new BreakBlockListener(this), this);
    }

}
