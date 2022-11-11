package xemii16.ecraft.bedwars.arena.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class ArenaCMDCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0){
            return List.of(
                    "about",
                    "create",
                    "delete",
                    "link",
                    "list",
                    "publish",
                    "set"
            );
        }
        if (args[0].equalsIgnoreCase("about")){
            if (args.length == 1){
                return List.of(
                        "<name>"
                );
            }
        }
        if (args[0].equalsIgnoreCase("create")){
            if (args.length == 1){
                return List.of(
                        "<name>"
                );
            }
            if (args.length == 2){
                return List.of(
                        "<id>"
                );
            }
        }
        if (args[0].equalsIgnoreCase("delete")){
            if (args.length == 1){
                return List.of(
                        "<name>"
                );
            }
        }
        if (args[0].equalsIgnoreCase("link")){
            if (args.length == 1){
                return List.of(
                        "<name>"
                );
            }
        }
        if (args[0].equalsIgnoreCase("set")){
            if (args.length == 1){
                return List.of(
                        "lobby",
                        "players"
                );
            }
            if (args[1].equalsIgnoreCase("players")){
                if (args.length == 2){
                    return List.of(
                            "<PlayersPerTeam>"
                    );
                }
                if (args.length == 3){
                    return List.of(
                            "<NumberOfTeams>"
                    );
                }
            }
        }
        return null;
    }
}
