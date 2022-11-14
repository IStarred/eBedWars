package xemii16.ecraft.bedwars.arena;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xemii16.ecraft.bedwars.Plugin;
import xemii16.ecraft.bedwars.game.Game;

import java.util.ArrayList;
import java.util.HashMap;


public class Arena {

    public static String prefix = ChatColor.BOLD + "" + ChatColor.AQUA + "[eCraft]";
    private String ArenaName;
    private ArrayList<Player> Players;
    private Location LobbySpawn;

    private Game game;


    private int id;

    private int playersPerTeam;

    private int numberOfTeams;

    private boolean Active;

    public static HashMap<String, Arena> ArenaHashMap = new HashMap<>();
    public Arena(String ArenaName, int id, boolean Active, ArrayList<Player> Players, Location LobbySpawn, Game game, int playersPerTeam, int numberOfTeams){
        this.ArenaName = ArenaName;
        this.id = id;
        this.Players = Players;
        this.LobbySpawn = LobbySpawn;
        this.Active = Active;
        this.game = game;
        this.playersPerTeam = playersPerTeam;
        this.numberOfTeams = numberOfTeams;

    }

    public void joinPlayer(Player player){
        Players.add(player);
        player.teleport(LobbySpawn);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        player.sendTitle("Вітаю на арені" + getArenaName(), "Гарної гри!", 20, 40, 20);
        for (Player players : Players){
            players.sendMessage("Гравець" + player.getDisplayName() + "приєднався до гри");

        }
    }

    public void leavePlayer(Player player){
        Players.remove(player);
        for (Player players : Players){
            players.sendMessage("Гравець" + player.getDisplayName() + "покинув цю гру");

        }

    }

    public void startTimer (int time, Arena arena){
        final int[] seconds = {time};
        new BukkitRunnable(){
            @Override
            public void run(){
                for (Player players : Players){
                    players.sendMessage("Гра почнеться через " + seconds[0]-- + "секунд");
                }
                if (seconds[0] <= 0){
                    this.cancel();
                    getGame().startGame(arena);
                }
            }
        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, 20L);
    }


    /* GETTERS AND SETTERS */

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayersPerTeam() {
        return playersPerTeam;
    }

    public void setPlayersPerTeam(int playersPerTeam) {
        this.playersPerTeam = playersPerTeam;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }


    public Location getLobbySpawn() {
        return LobbySpawn;
    }

    public void setLobbySpawn(Location lobbySpawn) {
        LobbySpawn = lobbySpawn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }
}
