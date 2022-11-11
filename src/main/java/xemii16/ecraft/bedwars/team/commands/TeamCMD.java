package xemii16.ecraft.bedwars.team.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.team.commands.voids.*;

import java.util.HashMap;

public class TeamCMD implements CommandExecutor {
    TeamCreate teamCreate = new TeamCreate();
    TeamLink teamLink = new TeamLink();
    TeamSet teamSet = new TeamSet();
    TeamPublish teamPublish = new TeamPublish();
    TeamAbout teamAbout = new TeamAbout();

    public static HashMap<Player, String> playerLinkTeam = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (player.isOp()){
                teamCreate.command(player, args);
                teamLink.command(player, args);
                teamSet.command(player, args);
                teamPublish.command(player, args);
                teamAbout.command(player, args);
            }
        }

        return true;
    }
}
