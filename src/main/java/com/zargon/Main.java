package com.zargon;

import com.zargon.Classes.Game;
import com.zargon.Classes.GameMap;
import com.zargon.Classes.Item;
import com.zargon.Classes.Player;
import com.zargon.Classes.Room;
import com.zargon.Utils.ConsoleColors;
import com.zargon.Utils.ProloguePlayer;
import com.zargon.Utils.ReadTextFileScanner;

// Utils
import java.util.Scanner;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
// Console colors
import com.zargon.Utils.ConsoleColors;


 // Deps
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static Player player;
    public static boolean startNewGame = true;
    public static void main(String[] args) {
        // System.out.println("Welcome to Solution Zargon!");
        ConsoleColors.printColored(ConsoleColors.GREEN,
            "  █████████     ███████    █████       █████  █████ ███████████ █████    ███████    ██████   █████\n"+
            " ███░░░░░███  ███░░░░░███ ░░███       ░░███  ░░███ ░█░░░███░░░█░░███   ███░░░░░███ ░░██████ ░░███ \n"+
            "░███    ░░░  ███     ░░███ ░███        ░███   ░███ ░   ░███  ░  ░███  ███     ░░███ ░███░███ ░███ \n"+
            "░░█████████ ░███      ░███ ░███        ░███   ░███     ░███     ░███ ░███      ░███ ░███░░███░███ \n"+
            " ░░░░░░░░███░███      ░███ ░███        ░███   ░███     ░███     ░███ ░███      ░███ ░███ ░░██████ \n"+
            " ███    ░███░░███     ███  ░███      █ ░███   ░███     ░███     ░███ ░░███     ███  ░███  ░░█████ \n"+
            "░░█████████  ░░░███████░   ███████████ ░░████████      █████    █████ ░░░███████░   █████  ░░█████\n"+
            " ░░░░░░░░░     ░░░░░░░    ░░░░░░░░░░░   ░░░░░░░░      ░░░░░    ░░░░░    ░░░░░░░    ░░░░░    ░░░░░ \n"+
            "                                                                                                  \n"+
            "                                                                                                  \n"+
            "                                                                                                  \n"+
            " ███████████   █████████   ███████████     █████████     ███████    ██████   █████                \n"+
            "░█░░░░░░███   ███░░░░░███ ░░███░░░░░███   ███░░░░░███  ███░░░░░███ ░░██████ ░░███                 \n"+
            "░     ███░   ░███    ░███  ░███    ░███  ███     ░░░  ███     ░░███ ░███░███ ░███                 \n"+
            "     ███     ░███████████  ░██████████  ░███         ░███      ░███ ░███░░███░███                 \n"+
            "    ███      ░███░░░░░███  ░███░░░░░███ ░███    █████░███      ░███ ░███ ░░██████                 \n"+
            "  ████     █ ░███    ░███  ░███    ░███ ░░███  ░░███ ░░███     ███  ░███  ░░█████                 \n"+
            " ███████████ █████   █████ █████   █████ ░░█████████  ░░░███████░   █████  ░░█████                \n"+
            "░░░░░░░░░░░ ░░░░░   ░░░░░ ░░░░░   ░░░░░   ░░░░░░░░░     ░░░░░░░    ░░░░░    ░░░░░                 \n"
        );

        // Get current directory and check for zargon_save.txt
        // String currentDirectory = System.getProperty("user.dir");
        // System.out.println(currentDirectory);
        
        //get current path
        Path currentPath = Paths.get("").toAbsolutePath();
        // System.out.println("Current working directory: " + currentPath.toString());

        // Append zargon_save.txt to current path
        String saveFilePath = currentPath.resolve("zargon_save.txt").toString();
       
        //check for saved file in current path
        File file = new File(saveFilePath);

        GameMap gameMap = new GameMap();

        if (file.exists()) {
            System.out.println("Saved game found in zargon_save.txt, checking Player data.");
            new ReadTextFileScanner();
            player = ReadTextFileScanner.main(saveFilePath);
            if (player != null) {
                startNewGame = false;
            // load game
                System.out.println("Welcome back, " + player.getName() + "! Resuming your adventure.");
            }else{
                // There could be an issue with the save file
                System.out.println("Error loading save file. Starting a new game.");
            }
        } else {
            // System.out.println("File does not exist.");
        }

        if(startNewGame){
            // new game
            Scanner scanner = new Scanner(System.in);
            // Prolouge
            System.out.println("Welcome to Zargon. Would you like to see the prologue? (y/n)");
            String show_prologue = scanner.nextLine();
            if(show_prologue.equalsIgnoreCase("y") || show_prologue.equalsIgnoreCase("yes") ){

                try {
                // show intro prologue before game starts
                ProloguePlayer.play();

                } catch (Exception e) {
                    System.out.println("I'm sorry, an error occurred while playing the prologue.  Continuing to game...");
                    // e.printStackTrace();
                }

            }



            System.out.println("Welcome to Zargon. What is your name?");
            // Grab the player name
            String player_name = scanner.nextLine();
            if (player_name.trim().isEmpty()) {
                System.out.println("Ah.. a mysterious one. Very well, you shall be known as 'Scavenger'.");
                player_name = "Scavenger";
            }
            // Set the starting room
            Room currentRoom = gameMap.getRoom("Ship");

            // System.out.println(currentRoom.getDescription());

            // name, currentRoomId, inventory, currentRoom
            player = new Player(player_name, 0, new java.util.ArrayList<Item>(), currentRoom);
            // player.setName(player_name);
            System.out.println("Welcome, " + player.getName() + "! Your adventure begins now.");
            // scanner.close();
        }
        
        Game game = new Game(player);
        game.start();
    }
}