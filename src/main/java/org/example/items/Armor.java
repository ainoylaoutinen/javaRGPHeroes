package org.example.items;

import org.example.heroes.HeroAttribute;

public class Armor extends Item{

    private ArmorType armorType;

    private HeroAttribute armorAttribute;

    public Armor(String itemName, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(itemName, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public HeroAttribute getArmorAttribute() { return armorAttribute; }

}
