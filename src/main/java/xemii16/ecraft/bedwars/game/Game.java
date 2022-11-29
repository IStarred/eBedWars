package xemii16.ecraft.bedwars.game;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import xemii16.ecraft.bedwars.Plugin;
import xemii16.ecraft.bedwars.arena.Arena;
import xemii16.ecraft.bedwars.team.Team;

import java.util.ArrayList;

import static xemii16.ecraft.bedwars.arena.Arena.ArenaHashMap;

public class Game {

    private Arena arena;

    private ArrayList<Team> teams;

    private final long bronzeSpawnCD = 20L;
    private final long ironSpawnCD = 100L;
    private final long goldSpawnCD = 200L;

    private boolean active;

    private World world;

    private ArrayList<Location> bronzeSpawner;
    private ArrayList<Location> ironSpawner;
    private ArrayList<Location> goldSpawner;

    /* CONSTRUCTOR */

    public Game(ArrayList<Team> teams, boolean active, ArrayList<Location> bronzeSpawner, ArrayList<Location> ironSpawner, ArrayList<Location> goldSpawner, World world) {
        this.teams = teams;
        this.active = active;
        this.bronzeSpawner = bronzeSpawner;
        this.ironSpawner = ironSpawner;
        this.goldSpawner = goldSpawner;
        this.world = world;
    }

    /* ADDERS */

    public void addTeam (String name, String gameName, Location spawnLocation, Location bedLocation, Material bedMaterial, int maxPlayers, ChatColor chatColor){
        teams.add(new Team(name, gameName, spawnLocation, bedLocation, bedMaterial, maxPlayers, chatColor, new ArrayList<>()));
    }

    public void addBronzeSpawn(Location location){
        bronzeSpawner.add(location);
    }
    public void addIronSpawn(Location location){
        ironSpawner.add(location);
    }
    public void addGoldSpawn(Location location){
        goldSpawner.add(location);
    }

    /* STARTERS */

    public void startGame (Arena arena){
        startIronSpawn();
        startGoldSpawn();
        startBronzeSpawn();
        arena.getGame().setActive(true);
        for (Player player : arena.getPlayers()){
            player.getInventory().clear();
            for (Team team : arena.getGame().getTeams()){
                if (team.getPlayers().contains(player)){
                    player.teleport(team.getSpawnLocation());
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }
            }
            for (Team team : arena.getGame().getTeams()){
                if (!team.getPlayers().contains(player)){
                    if (team.getPlayers().size() <= arena.getPlayersPerTeam()){
                        team.getPlayers().add(player);
                        player.teleport(team.getSpawnLocation());
                        player.setHealth(20);
                        player.setFoodLevel(20);
                    }
                }
            }
            for (Team team : arena.getGame().getTeams()){
                Location location = team.getBedLocation();
                Material material = team.getBedMaterial();
                location.getBlock().setType(material);
                Bed bed = (Bed) location.getBlock();
                bed.setPart(Bed.Part.FOOT);
                
            }
        }
    }

    private void startBronzeSpawn (){
        new BukkitRunnable(){
            @Override
            public void run(){
                if (active){
                    for (Location location : bronzeSpawner){
                        location.getWorld().dropItem(location, new ItemStack(Material.BRICK));
                    }
                }
            }

        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, bronzeSpawnCD);
    }
    private void startIronSpawn (){
        new BukkitRunnable(){
            @Override
            public void run(){
                if (active){
                    for (Location location : ironSpawner){
                        location.getWorld().dropItem(location, new ItemStack(Material.IRON_INGOT));
                    }
                }
            }

        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, ironSpawnCD);
    }
    private void startGoldSpawn (){
        new BukkitRunnable(){
            @Override
            public void run(){
                if (active){
                    for (Location location : goldSpawner){
                        location.getWorld().dropItem(location, new ItemStack(Material.GOLD_INGOT));
                    }
                }
            }

        }.runTaskTimer(Plugin.getPlugin(Plugin.class), 0L, goldSpawnCD);
    }

    /* UTILITIES */

    public void onBedBreak(Material material, Player player){
        for (Team team : teams){
            if(team.getBedMaterial().equals(material)){
                if (team.getPlayers().contains(player)){
                    return;
                } else {
                    team.setBedLocation(null);
                }
            }
        }
    }

    public void onPlayerDeath(Player player){
        for (Player players : world.getPlayers()){
            players.sendMessage("Гравець " + player.getDisplayName() + "випадково помер!");
        }
        for (Team team : teams){
            if (team.getPlayers().contains(player)){
                if(team.getBedLocation() != null){
                    player.sendTitle("Відродження через", "", 10, 20, 10);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setGameMode(GameMode.SPECTATOR);
                    player.teleport(new Location(getWorld(), 0, 100, 0));

                    new BukkitRunnable() {

                        int time = 5;
                        @Override
                        public void run() {
                            player.sendTitle(ChatColor.BOLD + "" + time, "", 0, 20, 0);
                            time--;
                            if (time <= 0){
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(Plugin.getPlugin(Plugin.class), 10L, 20L);
                    player.teleport(team.getSpawnLocation());
                }else{
                    for (Player players : world.getPlayers()){
                       players.sendMessage("Гравець " + arena.getPlayers() + " назавжди покінчив з собою :c ");
                    }
                    moveToSpectator(player, team);
                }
            }
        }

    }

    public void moveToSpectator(Player player, Team team){
        team.getPlayers().remove(player);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setGameMode(GameMode.SPECTATOR);

    }


    /* GETTERS AND SETTERS */

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public long getBronzeSpawnCD() {
        return bronzeSpawnCD;
    }

    public long getIronSpawnCD() {
        return ironSpawnCD;
    }

    public long getGoldSpawnCD() {
        return goldSpawnCD;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Location> getBronzeSpawner() {
        return bronzeSpawner;
    }

    public void setBronzeSpawner(ArrayList<Location> bronzeSpawner) {
        this.bronzeSpawner = bronzeSpawner;
    }

    public ArrayList<Location> getIronSpawner() {
        return ironSpawner;
    }

    public void setIronSpawner(ArrayList<Location> ironSpawner) {
        this.ironSpawner = ironSpawner;
    }

    public ArrayList<Location> getGoldSpawner() {
        return goldSpawner;
    }

    public void setGoldSpawner(ArrayList<Location> goldSpawner) {
        this.goldSpawner = goldSpawner;
    }
}
