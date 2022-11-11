package xemii16.ecraft.bedwars.game.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class GameCMDCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0){
            return List.of(
                    "bronze",
                    "iron",
                    "gold",
                    "set"
            );
        }
        if (args[0].equalsIgnoreCase("set")){
            if (args.length == 1){
                return List.of(
                        "world"
                );
            }
        }
        return null;
    }
}
