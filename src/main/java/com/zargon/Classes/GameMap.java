package com.zargon.Classes;

    import java.util.HashMap;
    import java.util.Map;

import com.zargon.Classes.Rooms.Ship;

    public class GameMap {
        private Map<String, Room> allRooms; // Stores all rooms, accessible by name

        public GameMap() {
            allRooms = new HashMap<>();
            createRooms();
        }

        private void createRooms() {
            // Create rooms
            Room ship = new Ship(0, "Ship", "You have just arrived to the Zargon space center. You are in the control room of your spaceship. The main console is flickering with warning lights of low power. Your exit is to the east [go east]. I suggest you take your belongings with you. --[look], [grab item] replace item with the name of the item --");
            Room landingArea = new Room(1 ,"Landing Area", "You are in an open room, stacks of storage boxes hug the walls. Workers are moving about and a security guard is checking credentials for access to the space station. You can return to your ship or proceed east.");
            Room tubeChambers = new Room(2, "Tube Chambers", "The hallways are dim, stacks of storage line the walls. A shadowy figure lurks in the darkness. To the east is the rec rooms. to the west, back to the landing area");
            Room recRoomSouth = new Room(3, "Rec Room South", "The southern recroom holds activites for fitness and activites. Sparing equipment and a climbing wall. To the east are the tube chambers and the landing area. To the Nornh is the northern rec room. There is  a locked door to the notrh east leading to the overseer office and only he is allowed to use this enterance. Staff entrance is at the observation deck.");

            // Add rooms to the map
            allRooms.put("Ship", ship);
            allRooms.put("Landing Area", landingArea);
            allRooms.put("Tube Chambers", tubeChambers);
            allRooms.put("Rec Room South", recRoomSouth);

            // Add items to rooms
            //Ship items
            Item passport = new Item("Passport", 1, 0);
            Item keycard = new Item("q174547 keycard", 2, 50);
            Item cargoKeycard = new Item("Cargo Keycard", 1, 50);

            ship.getItems().add(passport);
            ship.getItems().add(keycard);
            ship.getItems().add(cargoKeycard);
            ship.addAction("use cargo keycard", "You use the ship cargo keycard. The door opens, revealing a hidden compartment! Inside, you find an ancient artifact. You take it with you. \n" +
                                "[This could be used in the market to gain a lot of credits.] \n" + 
                                "Ancient Artifact added to inventory.");

            //Landing Area items
            Item medkit = new Item("Medkit", 1, 100);
            landingArea.getItems().add(medkit);
            //Tube Chambers items
            Item flashlight = new Item("Flashlight", 1, 25);
            tubeChambers.getItems().add(flashlight);
            //Rec Room South items
            Item energyBar = new Item("Energy Bar", 1, 10);
            recRoomSouth.getItems().add(energyBar);

            // Connect rooms
            ship.setExit("east", landingArea);

            landingArea.setExit("west", ship);
            landingArea.setExit("east", tubeChambers);
            // landingArea.setExit("south", recRoomSouth);

            tubeChambers.setExit("west", landingArea);

            recRoomSouth.setExit("east", recRoomSouth);
        }

        public Room getRoom(String roomName) {
            return allRooms.get(roomName);
        }
    }