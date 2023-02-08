package org.example.items;

public class Armor extends Item{

    private ArmorType armorType;

    public Armor(String itemName, int requiredLevel, Slot slot) {
        super(itemName, requiredLevel, slot);
    }
}
