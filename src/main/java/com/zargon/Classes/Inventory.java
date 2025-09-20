package com.zargon.Classes;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> items = new HashMap<>();

    public void addItem(Item item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(Item item, int quantity) {
        int currentQuantity = items.getOrDefault(item, 0);
        if (currentQuantity <= quantity) {
            items.remove(item);
        } else {
            items.put(item, currentQuantity - quantity);
        }
    }

    public boolean hasItem(Item item) {
        return items.containsKey(item);
    }

    public boolean hasItem(Item item, int quantity) {
        return items.getOrDefault(item, 0) >= quantity;
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("--- Inventory ---");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + item.getName() + " x" + quantity + " (Value: " + item.getValue() + ")");
        }
    }
}