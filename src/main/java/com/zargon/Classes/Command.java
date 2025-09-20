package com.zargon.Classes;

public class Command {
    private String commandText;

    public Command(String commandText) {
        this.commandText = commandText;
    }

    public String getCommandText() {
        return commandText;
    }

    public void execute(Player player, Room currentRoom) {
        // Implementation for executing the command will go here
    }

    public static Command parse(String input) {
        // Implementation for parsing user input into a Command object will go here
        return new Command(input);
    }
}