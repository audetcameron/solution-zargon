package com.zargon.Classes;

public class Character {
    private String name;
    private int currency;
    protected Inventory inventory;

    public Character(String name, int initialCurrency) {
        this.name = name;
        this.currency = initialCurrency;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public int getCurrency() {
        return currency;
    }

    public void addCurrency(int amount) {
        this.currency += amount;
    }

    public boolean removeCurrency(int amount) {
        if (this.currency >= amount) {
            this.currency -= amount;
            return true;
        }
        return false;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
