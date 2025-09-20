package com.zargon.Classes;
// Utils
import java.util.Scanner;



public class Game {
    private boolean isRunning;
    public Player player;

    public Game(Player player) {
        this.player = player;

        // System.out.println(player.getName());
        // System.out.println(player.getCurrentRoomId());
        isRunning = true;
        
        // player.getCurrentRoomId();
        
    }

    public void start() {

        // System.out.println("Welcome to Zagon! \n" + //
        //                "=====+===============================================================================================\n" + //
        //                 "++=+++==============================================================================================\n" + //
        //                 "++++++=======================================--=====================================================\n" + //
        //                 "=======================================---------====================================================\n" + //
        //                 "=================================---------------------==============================================\n" + //
        //                 "================================---------------==+++++===--=========================================\n" + //
        //                 "=================================-----------=+*++======+++==-=======================================\n" + //
        //                 "===============================------------**+-------::::-=*+----===----============================\n" + //
        //                 "=============================-==----------**+==-----::...::-*+---=------=-==========================\n" + //
        //                 "=========================--==------------*#++==-=----::.::-:-#=------------=========================\n" + //
        //                 "========================--==-------------#**+=++**----::::---+*----------------=====================\n" + //
        //                 "===================----====--------------%***+++*#=--:::----:-*+---------------=====================\n" + //
        //                 "================--------==---------------*#*******=#%#+===++*%#+-----------------===================\n" + //
        //                 "==============----------------------------##++*##=*@@@@%+-+@@#*--------------------=================\n" + //
        //                 "===============-------------------=--------*#**+=--+***==*%**=*+---------------------===============\n" + //
        //                 "===================-------------+###*+=-----+*%%#*++*++-###+***-----------------------=-============\n" + //
        //                 "=============----=-----------==*%%%##**+-----+%%#%%@%*===-=+*=-------------------------=--=-========\n" + //
        //                 "=============-------------=*##########**###++##%*+*@#*=====*+-----------------------------=-========\n" + //
        //                 "=============-----------+####**+++***##+#%%@%%#%#*+**##*****=---------------------------------======\n" + //
        //                 "=============----------*%##**+++==-=+*##*%%@%%##%%#+++++++*+-==-------------------------------======\n" + //
        //                 "=============---------*%###**+++-:-=+*###%%#%%#%%@@@#*=--=#%%*+*+------------------------------=====\n" + //
        //                 "=============------=*#%#####**+++++***####%####%@@%%%%#*##%#+=++#=------------------------------====\n" + //
        //                 "============-------+%######*********###%#%%%###%%%@@%%@%#+++*%%#*-----------------------------======\n" + //
        //                 "===========---------=##**#****##########*%%%#######%%%+=+*#%#*=*#+------------------------------====\n" + //
        //                 "=========-=-----------+%#*++*###########%%#####%%####+*#@@*%#***%+---------==+===----------------===\n" + //
        //                 "==========-----------+%@@%%#*****#*##%%@%%%%####%%*===#%#**%%####------+*##%%%####*+=------------===\n" + //
        //                 "=========----------=*%@@@%%%%%%%%%%%%%%##%%%%####%%=-=+++*%*+%##*---=*#%%%%%%%#######*+----------===\n" + //
        //                 "=========---------+#%%%@%**#@@@%%@@%########%%%#####++#%@###=####--+%%%%%%%%%%%%%%##*+*#+---------==\n" + //
        //                 "=-======--------+%%%%%@%*+#%@@%%%%@@#########%%%%##%##****#*-*#*%=#%%%%%%%%%%%%%%%%%##*+#*---------=\n" + //
        //                 "--=-===--------=%*==-*%+=*%@@@%%@%##%###*###*%#%%%######*#%*-+#*#%@%%@%%%%%%%%%%%%%%%##*=*#=--------\n" + //
        //                 "===--=---------*=---=#+=#@@%@@%#%@@%%%##*#%%#%%###%%#%%%%##*-=%##@%%@%%%%%%%%%%%%%%#%%##+=*#=------=\n" + //
        //                 "==-----------------+*+=*#%%@@@%%##%%%%#*#%%#**+****%%%%%%##=-=%##%@@%%%%%%%%%%%%%###%%%##+=*#-----==\n" + //
        //                 "==--=-----------=+**==***%%%@#%%%%###%##%##**+*%%*##%%%%%@+---%##%@%%%%%%%%%%%%%%#####%%##*+#*----==\n" + //
        //                 "==--=----------**++=+*#-+%=**-###%#%%%#%%%#*#%%#@%###%%%%#=---%###%%%%%%%%%%%%%%%%#####%##*+*%=-----\n" + //
        //                 "-==-----------=%*+=****--=----#%##*##%%#**#%#%@*+%%*##%@#----=%####%%%%%%%%%%%%%%%######%##+*#*-----\n" + //
        //                 "===----------=#**###*#+-------+%%#*##%###%%%=-*#-+@%%##+----=%###%%##%%%@%%%%%%%%%%%####%%##**#=----\n" + //
        //                 "--===-=-----=+##*##*#*---------+#######%%%%#=-----*##+------=%%%%%%#%%%%%%%%%%%%%##%#####%##*#%+----\n" + //
        //                 "--===---=--*%%%#####%=-------=+==+++*%%###%#=--====---------=@@%%%%%%%%#%%%%%%%%%%%%#####%####%*----\n" + //
        //                 "-===-------#%%%#####%%*-----*%####*-+%%%%%%%**######*=------+@%@%%%%%%####%%#**%%%@%%####%%#*##*----\n" + //
        //                 "======-----#%%%%%%%%%%+----=%**##%%%%%%###%%%%#%#%%###=-----+%%@@%%%%%%%%%#%#+=%**##%%##%%%#####----\n" + //
        //                 "====-------=%%%###%%%#=-----*#***#%%%%###%%%#%%#%%%%#*#-----+%%@@@%@%%%%%%%%#+*#####%%##%%%#####----\n" + //
        //                 "------====--#%%####%#--------+@%**#%%%#%%%%%#%%#####*#*-----=%%%@@@%@@%%%%%%##%*####%%%#%%%###%*----\n" + //
        //                 "--==--------#%%#%%%%*-------+%%%@#*#@%%%%@@%@%%####*%*-------#%%@@%%%%%@@%%%%%####%%%%%#%%###%%+----\n" + //
        //                 "-===-=+*+=--#%%%#%%%+------=%%%%%%#*%%%%*+@@@@%##%#%%#-------*%%@@%%%%%%@%%%#####%%%%%##%%###%%=----\n" + //
        //                 "====*%#*#%+=%%%%%%%%+------#%%%%%%%#%%%%##%%%%%%%%%%%%=------=%%%@%%%%%%%%%@@%%%%%@%%%##%%###%#-----\n" + //
        //                 "====%##%%%#+%%%%%%%%+------%%%%%%@%%%%%%#######%%%%@%%#+------*%%%%%%%%%%%%%%%%%%%%%%%#%%####%+-----\n" + //
        //                 "====*%%%%%%%##*****#=--=+==*%**##%%%%%@@%#####%%%%@@####*------#%%%%%%%%%%%%%%%%%%%%#%#%###%%*---===\n" + //
        //                 "====-=++*%%###*+*+=+**=#**#**#***%%%%#%%%##%%%%%%%%*###**#=----=%%%%%%%%%%%%%%%%%%%%%%%%##%%#=-----=\n" + //
        //                 "======---*%##**+*++**%#+*##++#++#@@%%###%%#%%%##%%%+-+##++**----=%%%%%%%%%%%%%%%%%#%%%###%%%=-------\n" + //
        //                 "=======--*%#*#+**+*%%*+*%*--*#+*#%@@%###%%%%####%%%+---*#++**=---=#%%%%%%%%%%%%%%%%%####%%#=---==---\n" + //
        //                 "==========#%##*#+*%%*+#%#+=-#*=**+@%%########%%#%=*=----+#*=+*+---=*%%#%%%%%%%%%%%%###%%%*=-=--==-==\n" + //
        //                 "=========-=+#%%%##%###%*+***#++#==@%%@%#####%%%%#--------=*#+=**----=*%%###%%#%####%%%%*=---=====--=\n" + //
        //                 "=========----=*##%##%%#**++****#--*%%*%####%%%+%*----------*#+=+*=----=*##%%####%%%%#*=--==--===-===\n" + //
        //                 "=========-===---###%%####**+++*#=--**-#%%##%#*-*+-----------+#+=+**=-----=++*****+==---=====--==--==\n" + //
        //                 "========--===-=*##%%++######*+++**=----*%###==-==------------*#+==***+------------=-=========----=-=\n" + //
        //                 "===============#%%%+---+*#*###++++**=---*%%#-----------------=#*+=+**#=--==-==--====-=========-=====\n" + //
        //                 "==============-=+++--=--=#%####*++++**=--*%+-------------==--+%*+*#++*#=--=-========================\n" + //
        //                 "===============--------*###%%%###*++++**+-+=-----------=====-=#%#%#++*%=-=-=========================\n" + //
        //                 "===================--=+%#**#%%%%##***+++**+=------------====-+#**####%*--===========================\n" + //
        //                 "==================---+%*%%##%%%%**#*##*+++**+=----=----====--=#***##%%+-============================\n" + //
        //                 "==================***###%#*+*##=--+*####*+++**+=--===-====-+#%%#***%%%*=============================\n" + //
        //                 "================-*%%@@#%@#####+----=+*####*+++**+=--======-#%%%%###%%%%%*-==========================\n" + //
        //                 "================*%%#%%%@%##%@#=-=-=---+#####*+++**+=-======%%%%%%%###%%%+-==========================\n" + //
        //                 "==============+%%%%%%#%%%%%@@@#==-===--=+*###**+++***=--==#%%%%####%%%%%+-==========================\n" + //
        //                 "===============*%#%%%%%%%%%%%%+-========-=+*####**++***=-=#%%%%####%%%%%*-==========================\n" + //
        //                 "===============-*%%%##%%%%%%@*-===========-=+*####**+++**-==%%%%%%%@%%#%+===========================\n" + //
        //                 "================#@%@%##%%@%%%*================+*####*+++**=-#%%%%%%%@+==============================\n" + //
        //                 "===============+%%%%%%%%%*##*=================-=+*####**+*#=+%%%%%%%%===============================\n" + //
        //                 "===============%%%%%%%@#==========================+*#####++##%%%##%%*===============================\n" + //
        //                 "==============#%%%%%%%#==============================++*###*%%%%%%%%+===============================\n" + //
        //                 "=======+=====*%%%#%%%%====================================+#%%%%#%%%*===============================\n" + //
        //                 "======++=++++%%%%%%%@*=====++===+++========================%%%%%%%%%+===============================\n" + //
        //                 "+++++++******%%%%%%%%++++++++*+++++++++++++===============+#%%###*##%*+===+++++=====================\n" + //
        //                 "=+++++***####%%#%#%#%****************+****+*++++++++++++++####%%#*#*###*++++++++====================\n" + //
        //                 "+++++****###%%#####%#%####****************************####%###%%#%#***#####**+++++++++==============\n" + //
        //                 "===++++**###%%#%#%###########*************************#######%%%%%%%%#**###%%#*+++++============+===\n" + //
        //                 "====+++++***#%####%##%####***++++++++++++++++++++*****************##%%##**####%%+++++++=========++==\n" + //
        //                 "=======+++++*#%#%%#%##%###*++++++==+========+++++++===++++++++++++++*######*##*+++++================\n" + //
        //                 "==============+***********++++++==============================++==+++====++++=======================\n" + //
        //                 "=================================================================================+==================\n" + //
        //                 "================================================================================++=++===============\n" + //
        //                 "====================================================================================================\n" + //
        //                 ""); //insert intro and ascii art
        gameLoop();
    }

    private void gameLoop() {
        // GameMap gameMap = new GameMap();
        // Start Game
        
        // Room currentRoom = gameMap.getRoom("Starting Room");
        //          // Example of moving the player
        //     System.out.println("Current location: " + currentRoom.getName());
        //     System.out.println(currentRoom.getDescription());
        //     System.out.println(currentRoom.getExitString());

        //     // Simulate moving north
        //     if (currentRoom.getExit("north") != null) {
        //         currentRoom = currentRoom.getExit("north");
        //         System.out.println("\nYou move north.");
        //         System.out.println("Current location: " + currentRoom.getName());
        //         System.out.println(currentRoom.getDescription());
        //         System.out.println(currentRoom.getExitString());
        //     } else {
        //         System.out.println("You cannot go that way.");
        //     }

        // System.out.println("Greetings, what is your name, adventurer?");
        // String player_name = scanner.nextLine();
        // player.setName(player_name);
        // System.out.println("Welcome, " + player.getName() + "! Your adventure begins now.");
        
        // Rooms
        // Room ship_control = new Room(0, "ship_control", "You have just arrived to the Zargon space center. You are in the control room of your spaceship. The main console is flickering with warning lights of low power. Your exit is to the east [go east]. I suggest you take your belongings with you. --[look], [grab item] replace item with the name of the item --", new java.util.HashMap<String, Room>(), new java.util.ArrayList<String>());
        // Room landing_area;
        // ship_control.setExit("east", landing_area = new Room(1, "landing_area", "You are in an open room, stacks of storage boxes hug the walls. Workers are moving about and a security guard is checking credentials for access to the space station. You can return to your ship or proceed east.", new java.util.HashMap<String, Room>(), new java.util.ArrayList<String>()));
        // landing_area.setExit("west", ship_control);


        // System.out.println(player.getCurrentRoom().getDescription());
//npcs
    //     List<NPC> npcsInRoom = player.getCurrentRoom().getNPCs();
    // if (!npcsInRoom.isEmpty()) {
    //     System.out.println("You see the following people here:");
    //     for (NPC npc : npcsInRoom) {
    //         System.out.println("- " + npc.getName());
    //     }
    // }
// Inside your command parsing loop in Game.java
// if (command.startsWith("talk to")) {
//     String npcName = command.substring(7).trim();
//     for (NPC npc : player.getCurrentRoom().getNPCs()) {
//         if (npc.getName().equalsIgnoreCase(npcName)) {
//             npc.engageTrade(player);
//             return;
//         }
//     }
//     System.out.println("You don't see anyone by that name here.");
// }

// npc.getSellItems().displayInventory()
// player.getCurrency()
        Scanner scanner = new Scanner(System.in);
        //wip set current room based on player currentRoomId
        System.out.println(this.player.getCurrentRoom().getDescription());

        while (isRunning) {
            // System.out.println(this.player);
            // System.out.println(currentRoom.getRoomId());
            System.out.print("> ");
            String input = scanner.nextLine();

            processInput(input, this.player, this.player.getCurrentRoom(), scanner);
        }
        scanner.close();
    }

    private void processInput(String input, Player player, Room currentRoom, Scanner scanner) {
        //update room
        // System.out.println( player.getCurrentRoomId() );
        // System.out.println( player );
        // System.out.println( currentRoom );

        switch (input.toLowerCase().trim()) {
            case "go east":
            case "e":
            case "east":
               
                // Move player to the east if possible
                if (currentRoom.getExit("east") != null) {
                    // set player's current room to the new room
                    player.setCurrentRoom(currentRoom.getExit("east"));
                    // update currentRoom variable to reflect the change
                    // currentRoom = currentRoom.getExit("east");
                    System.out.println("\nYou move east to the " + this.player.getCurrentRoom().getName() + "." );
                    System.out.println(this.player.getCurrentRoom().getDescription());
                    System.out.println(this.player.getCurrentRoom().getExitString());
                } else {
                    System.out.println("You cannot go that way.");
                }

                break;
            case "go north":
            case "north":
            case "n":
         
                // Move player to the north if possible
                if (currentRoom.getExit("north") != null) {
                    // set player's current room to the new room
                    player.setCurrentRoom(currentRoom.getExit("north"));
                    // update currentRoom variable to reflect the change
                    // currentRoom = currentRoom.getExit("north");
                    System.out.println("\nYou move north to the " + this.player.getCurrentRoom().getName() + "." );
                    System.out.println(this.player.getCurrentRoom().getDescription());
                    System.out.println(this.player.getCurrentRoom().getExitString());
                } else {
                    System.out.println("You cannot go that way.");
                }

                break;                

            case "go south":
            case "south":
            case "s":
                // Move player to the south if possible
                if (currentRoom.getExit("south") != null) {
                    // set player's current room to the new room
                    player.setCurrentRoom(currentRoom.getExit("south"));

                    System.out.println("\nYou move south to the " + this.player.getCurrentRoom().getName() + "." );
                    System.out.println(this.player.getCurrentRoom().getDescription());
                    System.out.println(this.player.getCurrentRoom().getExitString());
                } else {
                    System.out.println("You cannot go that way.");
                }      
                break;

            case "go west":
            case "west":
            case "w":
                // Move player to the west if possible
                if (currentRoom.getExit("west") != null) {
                    // set player's current room to the new room
                    player.setCurrentRoom(currentRoom.getExit("west"));

                    System.out.println("\nYou move west to the " + this.player.getCurrentRoom().getName() + "." );
                    System.out.println(this.player.getCurrentRoom().getDescription());
                    System.out.println(this.player.getCurrentRoom().getExitString());
                } else {
                    System.out.println("You cannot go that way.");
                }      
                break;

            
            
            //helpful commands
            case "where am i":
                System.out.println("You are in: " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
                break;

            case "show exits":
            case "showexits":
            case "exits":
                for( String direction : currentRoom.getExits().keySet() ) {
                    System.out.println("Direction: [ " + direction + " ] leads to " + currentRoom.getExits().get(direction).getName() );
                }
                // System.out.println("Exits: " + currentRoom.getExits());
                // System.out.println("Exits: " + currentRoom.getExitDescriptions());
                break;

            case "inventory":
            case "show inventory":
            case "inv":

                if(player.getInventory().isEmpty()){
                    System.out.println("Your inventory is empty.");
                    break;
                }
                // System.out.println("You check your inventory. You have the following items:");
                for (Item item : player.getInventory()) {
                    System.out.println("Item Name: " + item.getName() + ", Quantity: " + item.getQty() + " Item value: " + item.getValue() );
                }
                break;
            
            case "actions":
                System.out.println("Available actions in this room:");
                for (String action : currentRoom.getActions().keySet()) {
                    System.out.println("- " + action);
                }
                break;

            case "use item":
            case "use":
                System.out.println("Which item would you like to use? (type the exact name)");
                String itemNameToUse = scanner.nextLine();
                Item itemToUse = player.getItem(itemNameToUse);
                if(itemToUse != null){
                    player.useItem(itemToUse);
                }else{
                    System.out.println("You don't have an item named '" + itemNameToUse + "'.");
                }
                // if (itemToUse != null) {
                //     System.out.println("You use the " + itemToUse.getName() + ".");
                //     // Implement item usage logic here
                //     currentRoom.getActionOutcome("use " + itemToUse.getName());
                // } else {
                //     System.out.println("You don't have an item named '" + itemNameToUse + "'.");
                // }
                break;

            case "look":
                currentRoom.getItems();
                System.out.println("You look around the room.");
                System.out.println(currentRoom.getDescription());
                System.out.println("Items in the room:");
                for (Item item : currentRoom.getItems()) {
                    System.out.println("- " + item.getName() + " (Qty: " + item.getQty() + ")");
                }
                // System.out.println("NPCs in the room:");
                // for (NPC npc : currentRoom.getNPCs()) {
                //     System.out.println("- " + npc.getName());
                // }
                System.out.println(currentRoom.getExitString());
                // Example usage of ConsoleColors
                // ConsoleColors.printColored(ConsoleColors.RED, "This text is red.");
                // ConsoleColors.printColored(ConsoleColors.GREEN, "This text is green.");
                // ConsoleColors.printColored(ConsoleColors.BLUE, "This text is blue.");
                // ConsoleColors.printColored(ConsoleColors.YELLOW, "This text is yellow.");
                // System.out.println("Looking around!");
                break;
                
            case "take item":
            case "grab item":
            case "take":
            case "grab":
                // Example: take "item name"
                System.out.println("Which item would you like to take? (type the exact name)");
                String itemNameToTake = scanner.nextLine();
                Item itemToTake = currentRoom.getItem(itemNameToTake);
                if (itemToTake != null) {
                    player.addItem(itemToTake);
                    currentRoom.removeItem(itemToTake);
                    System.out.println("You have taken the " + itemToTake.getName() + ".");
                } else {
                    System.out.println("There is no item named '" + itemNameToTake + "' here.");
                }
                break;
            

            case "drop item":
            case "drop":
                // Example: drop "item name"
                System.out.println("Which item would you like to drop? (type the exact name)");
                String itemNameToDrop = scanner.nextLine();
                Item itemToDrop = player.getItem(itemNameToDrop);
                if (itemToDrop != null) {
                    player.removeItem(itemToDrop);
                    currentRoom.addItem(itemToDrop);
                    System.out.println("You have dropped the " + itemToDrop.getName() + ".");
                } else {
                    System.out.println("You don't have an item named '" + itemNameToDrop + "'.");
                }
                break;

                case "help":
                isRunning = true;
                System.out.println("Available commands: look, go [direction], take [item], drop [item], inventory, quit, save");
                break;


            case "quit":
            case "exit":
                isRunning = false;
                System.out.println("Thanks for playing!");
                break;
            case "save":
                isRunning = false;
                System.out.println("WIP save and export code!");
                break;
            // Additional command processing can be added here
            default:
                System.out.println("Unknown command: " + input);
                break;
        }
    }

}
