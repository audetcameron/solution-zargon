package com.zargon.Classes;

// Utils
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Item> inventory;
    private int currentRoomId;
    private Room currentRoom;

    public Player(

        String name, 
        int currentRoomId,
        List<Item> inventory,
        Room currentRoom
    ) 
    {
        this.name = name;
        this.currentRoomId = currentRoomId;
        this.currentRoom = currentRoom;
        // this.currentRoom = setCurrentRoomFromId(currentRoomId);
        this.inventory = inventory;

    }

    public String getName() {
        return this.name;
    }
    public String setName(String name) {
        return this.name = name;
    }
    // Room
    public int getCurrentRoomId() {
        return this.currentRoomId;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }
    // public Room setCurrentRoomFromId(int roomId) {

    //     this.currentRoomId = roomId;
    // }

    // Inventory
    public List<Item> getInventory() {
        // return this.inventory;
        // for (Item item : inventory) {
        //     System.out.println("Item Name: " + item.getName() + ", Quantity: " + item.getQty());
        // }
        return this.inventory;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public Item getItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().toLowerCase().equals(itemName.toLowerCase())) {
                return item;
            }
        }
        return null; // Item not found
    }

    public String useItem(Item item) {
        // Item item = getItem(itemName);
        String itemName = item.getName();
        if (item != null && item.getQty() > 0) {

            if(this.getCurrentRoom().hasAction("use "+itemName.toLowerCase())){
                System.out.println("Using " + itemName + " in the room: " + this.getCurrentRoom().getName());

            
                this.getCurrentRoom().handlePlayerAction("use "+itemName.toLowerCase(), this);
                
                String actionOutcome = this.getCurrentRoom().getActionOutcome("use " +itemName.toLowerCase());
                System.out.println(actionOutcome);
            }
            //check if the item has a field that matches the itemName
            if(item.hasField(item, "type" )){
                // System.out.println("Item has field type");

            }

            item.setQty(item.getQty() - 1);
            if (item.getQty() == 0) {
                removeItem(item);
            }
            return "You used the " + itemName + ".";
        } else {
            return "You don't have a " + itemName + " to use.";
        }
    }   

    public boolean hasItem(String itemName) {

        for (Item item : inventory) {
            
            if (item.getName().equals(itemName)) {
                // System.out.println("Found " + itemName + " with quantity: " + item.getQty());
                // You could update the quantity here if needed:
                // item.setQuantity(item.getQuantity() + 5);
                //check that the qty is greater than 0
                if (item.getQty() > 0) {
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }
            
        }
        return false;
    }

}