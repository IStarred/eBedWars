package xemii16.ecraft.bedwars.arena;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
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

    private BossBar bossBar;


    private int id;

    private int playersPerTeam;

    private int numberOfTeams;

    private boolean Active;

    public static HashMap<String, Arena> ArenaHashMap = new HashMap<>();
    public Arena(String ArenaName, int id, boolean Active, ArrayList<Player> Players, Location LobbySpawn, Game game, int playersPerTeam, int numberOfTeams, BossBar bossBar){
        this.ArenaName = ArenaName;
        this.id = id;
        this.Players = Players;
        this.LobbySpawn = LobbySpawn;
        this.Active = Active;
        this.game = game;
        this.playersPerTeam = playersPerTeam;
        this.numberOfTeams = numberOfTeams;
        this.bossBar = bossBar;

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
        int secondsTotal = seconds[0];
        final double[] secondsDouble = {time};
        final double[] progress = {secondsDouble[0] / secondsTotal};
        bossBar.setColor(BarColor.GREEN);
        bossBar.setTitle("Гра починається!");
        new BukkitRunnable(){
            @Override
            public void run(){
                for (Player players : Players){
                    players.sendTitle(ChatColor.BOLD + "" + ChatColor.GOLD + "" + seconds[0]--, ChatColor.GRAY + "Приготуйтеся!", 0, 20, 0);
                    players.playSound(players.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
                if (seconds[0] <= 5){
                    this.cancel();
                }
                bossBar.setProgress(progress[0]);
                secondsDouble[0]--;
            }
        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, 20L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (seconds[0] <= 5){
                    for (Player players : Players){
                        players.sendTitle(ChatColor.BOLD + "" + ChatColor.GOLD + "" + seconds[0]--, ChatColor.GRAY + "Приготуйтеся!", 0, 20, 0);
                        players.playSound(players.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
                    if (seconds[0] == 0){
                        this.cancel();

                    }
                }
            }
        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, 20L);
    }


    /* GETTERS AND SETTERS */

    public BossBar getBossBar() {
        return bossBar;
    }

    public void setBossBar(BossBar bossBar) {
        this.bossBar = bossBar;
    }

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
