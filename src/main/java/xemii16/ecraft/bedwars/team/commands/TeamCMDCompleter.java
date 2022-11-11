package xemii16.ecraft.bedwars.team.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TeamCMDCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0){
            return List.of(
                    "set",
                    "link",
                    "about",
                    "create",
                    "publish"
            );
        }
        if (args[0].equalsIgnoreCase("set")){
            if (args.length == 1){
                return List.of(
                        "color",
                        "spawn",
                        "bed"
                );
            }
            if (args[1].equalsIgnoreCase("color") && args.length == 2){
                return List.of(
                        "WHITE",
                        "ORANGE",
                        "MAGENTA",
                        "LIGHT_BLUE",
                        "YELLOW",
                        "LIME",
                        "PINK",
                        "GRAY",
                        "PURPLE",
                        "BLUE",
                        "CYAN",
                        "RED",
                        "BLACK"
                );
            }
        }
        if (args[0].equalsIgnoreCase("create")){
            if (args.length == 1){
                return List.of(
                        "<name>"
                );
            }
        }
        if (args[0].equalsIgnoreCase("link")){
            return List.of(
                    "<name>"
            );
        }
        return null;
    }
}
