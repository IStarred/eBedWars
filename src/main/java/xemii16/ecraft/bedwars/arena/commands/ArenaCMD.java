package xemii16.ecraft.bedwars.arena.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.arena.commands.voids.*;

import java.util.HashMap;


public class ArenaCMD implements CommandExecutor {

    public static HashMap<Player, String> playerLinkArena = new HashMap<>();

    ArenaCreate arenaCreate = new ArenaCreate();
    ArenaLink arenaLink = new ArenaLink();
    ArenaDelete arenaDelete = new ArenaDelete();
    ArenaSet arenaSet = new ArenaSet();
    ArenaPublish arenaPublish = new ArenaPublish();
    ArenaAbout arenaAbout = new ArenaAbout();
    ArenaList arenaList = new ArenaList();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){

                arenaCreate.command(player, args);
                arenaLink.command(player, args);
                arenaDelete.command(player, args);
                arenaSet.command(player, args);
                arenaPublish.command(player, args);
                arenaAbout.command(player, args);
                arenaList.command(player, args);
            }
        }
        return true;
    }
}
