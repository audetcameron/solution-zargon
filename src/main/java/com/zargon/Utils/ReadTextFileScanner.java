package com.zargon.Utils;
// $utils
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zargon.Classes.GameMap;
import com.zargon.Classes.Item;
import com.zargon.Classes.Player;
import com.zargon.Classes.Room;
import com.fasterxml.jackson.databind.JsonNode;

public class ReadTextFileScanner {
    private static Player player;
   
    public static Player main(String pathname) {

        String name = "Hero";
        Integer currentRoomId = 0;
        // ArrayList<String> inventory = new ArrayList<>();
        ArrayList<Item> inventory = new ArrayList<>(); 

        try {
            // Read all bytes from the file and convert to a String using UTF-8 encoding
            String jsonString = new String(Files.readAllBytes(Paths.get(pathname)), StandardCharsets.UTF_8);
            // System.out.println("JSON String from file: \n" + jsonString);

            // Optional: Parse the JSON String into a JSON object (using Jackson example)
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // System.out.println("Parsed JSON object: \n" + rootNode.toPrettyString());
            
            JsonNode nameNode = rootNode.get("name");
            if (nameNode != null) {
                name = nameNode.asText();
                // System.out.println("Name: " + name); // Output: Name:
            }
            JsonNode currentRoomIdNode = rootNode.get("currentRoomId");
            if (currentRoomIdNode != null) {
                currentRoomId = currentRoomIdNode.asInt();
                // System.out.println("currentRoomID: " + currentRoomId); 
            }

            // JsonNode inventoryNode = rootNode.get("inventory");
            ArrayNode inventoryNode = (ArrayNode) rootNode.get("inventory"); // Or (ArrayNode) parentNode.path("arrayFieldName")
            // System.out.println("Inventory Node: " + inventoryNode);

           for (JsonNode objectNode : inventoryNode) {
        // Process each objectNode here

        String itemName = objectNode.get("name").asText();
        int itemQty = objectNode.get("qty").asInt();
        int itemValue = objectNode.get("value").asInt();
        Item item = new Item(itemName, itemQty, itemValue);
        inventory.add(item); 
        // Or map it to a POJO:
        // MyObject myObject = objectMapper.treeToValue(objectNode, MyObject.class);
        // System.out.println("Item: " + itemName + ", Qty: " + itemQty);
        // inventory.add(itemName);
    }

    // System.out.println(inventory);
            // System.out.println(inventoryNode.asText());
            // if (inventoryNode != null && inventoryNode.isArray()) {
            //     for (JsonNode itemNode : inventoryNode) {
            //         System.out.println(itemNode.asText());
            //         // inventory.add(itemNode.asText());
            //     }
            // }else {
            //     System.out.println("Inventory node is missing or not an array.");
            // }
            // System.out.println("Inventory: " + inventory);
            GameMap gameMap = new GameMap();
            Room currentRoom = gameMap.getRoom("Ship");
            //WIP need to figure out how to set the current room from the id
            // currentRoom = gameMap.getRoomById(currentRoomId);

            //set up the player
            player = new Player(name, currentRoomId, inventory, currentRoom );

            return player;

        } catch (IOException e) {
            // System.err.println("Error reading the file: " + e.getMessage());
            // e.printStackTrace();
            return null;
        }

    }

}
