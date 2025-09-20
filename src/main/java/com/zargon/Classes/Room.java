package com.zargon.Classes;
// Utils
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;  

public class Room {
    private int id;
    private String name;
    protected String description;
    protected String detailedDescription;
    private Map<String, Room> exits; // Stores directions and the Room objects they lead to
    private Map<String, String> actions; // Stores action keywords and descriptions/outcomes
    private List<Item> items;
    private List<NPC> npcs;

    public Room(
        int id,
        String name, 
        String description
        ) {
        this.id = id;
        this.name = name;
        this.description = description;
        
        this.exits = new HashMap<>();
        this.items = new ArrayList<Item>();
        this.actions = new HashMap<>();
        this.npcs = new ArrayList<>();
    }

    // ID
    public int getRoomId() {
        return this.id;
    }
    public int setRoomId(int id) {
        return this.id = id;
    }

    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Exits
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    //getExit
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    // getExitString not sure if im going to use this to concat more info to a detail string
    public String getExitString() {
        StringBuilder exitInfo = new StringBuilder("Exits: ");
        for (String direction : exits.keySet()) {
            exitInfo.append(direction).append(" ");
        }
        return exitInfo.toString().trim();
    }

    // getExitDescriptions
    public String getExitDescriptions() {
        StringBuilder sb = new StringBuilder("Exits: ");
        for (String direction : exits.keySet()) {
            sb.append(direction).append(" ");
        }
        return sb.toString().trim();
    }

    // getExits
    public Map<String, Room> getExits() {
        return exits;
    }

    //Add Edit
    public void addExit(String direction, Room neighborRoom) {
        exits.put(direction.toLowerCase(), neighborRoom);
    }

    // Actions
    public void handlePlayerAction( String keyword, Player player) {

    }

    public void addAction(String keyword, String outcome) {
        actions.put(keyword.toLowerCase(), outcome);
    }

    public String getActionOutcome(String keyword) {
        // System.out.println("Getting action outcome for keyword: " + keyword);
        // System.out.println(this.getActions());
        return actions.get(keyword.toLowerCase());
    }
    public boolean hasAction(String keyword) {
        return actions.containsKey(keyword.toLowerCase());
    }
    public Map<String, String> getActions() {
        return actions;
    }

    public String getActionDescriptions() {
        StringBuilder sb = new StringBuilder("Available actions: ");
        for (String action : actions.keySet()) {
            sb.append(action).append(" ");
        }
        return sb.toString().trim();
    }

    // Room Items
    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null; // Item not found
    }   
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public void handleRoomLogic(Player player) {
        // Default behavior: does nothing.
        // This is where subclassing comes in.
    }

    // NPCs
    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNPCs() {
        return npcs;
    }

}