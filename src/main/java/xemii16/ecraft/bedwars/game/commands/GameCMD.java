package xemii16.ecraft.bedwars.game.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xemii16.ecraft.bedwars.game.commands.voids.GameBronze;
import xemii16.ecraft.bedwars.game.commands.voids.GameGold;
import xemii16.ecraft.bedwars.game.commands.voids.GameIron;
import xemii16.ecraft.bedwars.game.commands.voids.GameSet;

public class GameCMD implements CommandExecutor {

    GameBronze gameBronze = new GameBronze();
    GameGold gameGold = new GameGold();
    GameIron gameIron = new GameIron();
    GameSet gameSet = new GameSet();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            gameBronze.command(player, args);
            gameGold.command(player, args);
            gameIron.command(player, args);
            gameSet.command(player, args);
        }
        return true;
    }

}
