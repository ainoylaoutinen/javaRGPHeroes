package org.example.items;

public class Armor extends Item{

    private ArmorType armorType;

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public Armor(String itemName, int requiredLevel, Slot slot, ArmorType armorType) {
        super(itemName, requiredLevel, slot);
        this.armorType = armorType;
    }
}
