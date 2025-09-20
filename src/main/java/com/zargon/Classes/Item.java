package com.zargon.Classes;
import java.lang.reflect.Field;

public class Item {
    private String name;
    private int qty;
    private int value;
    protected String type; // e.g., "weapon", "potion", "misc"
    private String description;
    // private Map<String, Integer> attributes; // e.g., {"damage": 10, "healing": 5}   
    // private Map<String, String> effects; // e.g., {"onUse": "heals 5 HP", "onEquip": "increases strength by 2"}

    public Item(String name, int qty, int value) {
        this.name = name;
        this.qty = qty;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getValue() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }
    /**
     * Checks if a given class has a field with the specified name.
     * This method can find public, private, and protected fields declared in the class.
     *
     * @param clazz The Class object to inspect.
     * @param fieldName The name of the field to check for.
     * @return true if the class has the specified field, false otherwise.
     */
    public boolean hasField(Item item, String fieldName) {
        try {
            // Correct usage: Call getDeclaredField on the Class object
            Field field = Item.class.getDeclaredField(fieldName);
            // System.out.println("Field found: " + field.getName());
            return true;
        } catch (NoSuchFieldException e) {
            return false;
            // System.err.println("Field not found: " + e.getMessage());
        } catch (SecurityException e) {
            return false;
            // System.err.println("Security exception: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Item [name=" + name + "\n qty=" + qty + "\n value=" + value + "]\n";
    }
}
