package xemii16.ecraft.bedwars.team;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {

    private Location spawnLocation;
    private Location bedLocation;

    private String name;
    private String gameName;

    private int maxPlayers;

    private ChatColor chatColor;

    private Material bedMaterial;

    private ArrayList<Player> players;

    public Team(String name, String gameName, Location spawnLocation, Location bedLocation, Material bedMaterial, int maxPlayers, ChatColor chatColor, ArrayList<Player> players) {
        this.spawnLocation = spawnLocation;
        this.bedLocation = bedLocation;
        this.maxPlayers = maxPlayers;
        this.chatColor = chatColor;
        this.players = players;
        this.name = name;
        this.gameName = gameName;
        this.bedMaterial = bedMaterial;
    }

    /* GETTERS AND SETTERS */

    public Material getBedMaterial() {
        return bedMaterial;
    }

    public void setBedMaterial(Material bedMaterial) {
        this.bedMaterial = bedMaterial;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public Location getBedLocation() {
        return bedLocation;
    }

    public void setBedLocation(Location bedLocation) {
        this.bedLocation = bedLocation;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public void setChatColor(ChatColor chatColor) {
        this.chatColor = chatColor;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
