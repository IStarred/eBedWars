package xemii16.ecraft.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xemii16.ecraft.bedwars.arena.commands.ArenaCMDCompleter;
import xemii16.ecraft.bedwars.arena.commands.JoinGUI;
import xemii16.ecraft.bedwars.arena.events.InventoryClickListener;
import xemii16.ecraft.bedwars.game.commands.GameCMD;
import xemii16.ecraft.bedwars.arena.commands.ArenaCMD;
import xemii16.ecraft.bedwars.game.commands.GameCMDCompleter;
import xemii16.ecraft.bedwars.team.commands.TeamCMD;
import xemii16.ecraft.bedwars.team.commands.TeamCMDCompleter;

public final class Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("arena").setExecutor(new ArenaCMD());
        getCommand("game").setExecutor(new GameCMD());
        getCommand("team").setExecutor(new TeamCMD());
        getCommand("menu").setExecutor(new JoinGUI());

        getCommand("arena").setTabCompleter(new ArenaCMDCompleter());
        getCommand("team").setTabCompleter(new TeamCMDCompleter());
        getCommand("game").setTabCompleter(new GameCMDCompleter());
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
