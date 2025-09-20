package com.zargon.Classes.Rooms;
import java.util.List;
import java.util.Map;

// Classes
import com.zargon.Classes.Player;
import com.zargon.Classes.Item;
import com.zargon.Classes.Room;
import com.zargon.Classes.Items.AncientArtifact;

public class Ship extends Room {
    private boolean hasUsedCargoKeycard;

    public Ship(int id, String name, String description) {
        super(id, name, description);
        this.hasUsedCargoKeycard = false;
        this.detailedDescription = "You are in the cargo hold of an ancient spaceship. The walls are lined with strange, glowing symbols, and the air is thick with the scent of ozone. In the center of the room stands a pedestal with an unlit altar.";
        // this.setDescription(detailedDescription);
    }

    // @Override
    // public String getActionOutcome(String keyword) {
    //     return actions.get(keyword.toLowerCase());
    // }

    @Override
    public void handlePlayerAction(String action, Player player) {
        String lowerAction = action.toLowerCase();
        // if (lowerAction.equals("use cargo keycard") || lowerAction.equals("use keycard")) {
        if (lowerAction.equals("use cargo keycard")) {
            
            if (player.hasItem("Cargo Keycard") && !hasUsedCargoKeycard) {
                // System.out.println("You use the ship cargo keycard. The door opens, revealing a hidden compartment! Inside, you find an ancient artifact. You take it with you. \n [This could be used in the market to gain a lot of credits.]");
                this.hasUsedCargoKeycard = true;
                // A special action changes the room's exits
                // Exit secretExit = new Exit("north", getSecretRoom());
                // Item cargoKeycard = new Item("Cargo Keycard", 1, 50);
                // Item cargoKeycard = player.getItem("Cargo Keycard");
                // Remove the keycard from the player's inventory and add a new item
                // player.removeItem(cargoKeycard);
                // player.addItem(new Item("Ancient Artifact", 1, 1000));
                player.addItem(new AncientArtifact("Ancient Artifact", 1, 1000, "An ancient artifact of great value, covered in mysterious symbols and emanating a faint glow. Clearly not on the cargo manifest, someone must be trying to smuggle this."));
                // System.out.println("Ancite Artifact added to inventory.");
                // this.getExits().add(secretExit);
            } else if (hasUsedCargoKeycard) {
                System.out.println("You hve already used the cargo keycard here.");
            } else {
                System.out.println("You don't have a Cargo Keycard to use.");
            }

        } else {
            System.out.println("I can't find a use for the cargo keycard here.");
        }

    }   

    // Handle room logic on load or when player enters
    @Override
    public void handleRoomLogic(Player player) {
        // // Check if the player has the 'Torch' and the altar isn't lit yet
        // if (player.hasItem("Cargo Keycard") && !hasCargoKeycard) {
        //     System.out.println("You use the ship keycard, and a secret container door opens!");
        //     this.hasCargoKeycard = true;
        //     // A special action changes the room's exits
        //     // Exit secretExit = new Exit("north", getSecretRoom());
        //     // Item cargoKeycard = new Item("Cargo Keycard", 1, 50);
        //     Item cargoKeycard = player.getItem("Cargo Keycard");
        //     // Remove the keycard from the player's inventory and add a new item
        //     player.removeItem(cargoKeycard);
        //     player.addItem(new Item("Ancient Artifact", 1, 1000));

            
        //     // this.getExits().add(secretExit);
        // } else if (hasCargoKeycard) {
        //     this.setDescription("The altar is now lit, and the secret passage to the north is open.");
        // }
    }
}
