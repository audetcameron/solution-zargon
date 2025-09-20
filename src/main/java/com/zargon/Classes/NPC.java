package com.zargon.Classes;

public class NPC extends Character {
    private String dialogue;
    private Inventory sellItems;
    private Inventory buyItems; // Items the NPC wants to buy

    public NPC(String name, int initialCurrency, String dialogue) {
        super(name, initialCurrency);
        this.dialogue = dialogue;
        this.sellItems = new Inventory();
        this.buyItems = new Inventory();
    }

    public void addSellItem(Item item, int quantity) {
        this.sellItems.addItem(item, quantity);
    }
    
    public void addBuyItem(Item item, int quantity) {
        this.buyItems.addItem(item, quantity);
    }

    public String getDialogue() {
        return dialogue;
    }

    public Inventory getSellItems() {
        return sellItems;
    }

    public Inventory getBuyItems() {
        return buyItems;
    }

    public void engageTrade(Player player) {
        System.out.println("-------------------------");
        System.out.println(getName() + " says: " + getDialogue());
        System.out.println("What would you like to do? (buy/sell/leave)");
        // Game logic to handle user input for trading
    }
}
