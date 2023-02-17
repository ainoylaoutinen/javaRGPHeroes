package org.example.heroes;

import org.example.items.*;
import org.example.exceptions.*;
import org.example.items.enums.ArmorType;
import org.example.items.enums.Slot;
import org.example.items.enums.WeaponType;
import org.example.items.subclasses.Armor;
import org.example.items.subclasses.Weapon;

import java.util.HashMap;
import java.util.List;

public abstract class Hero {

    private String name;
    private int level;

    private HashMap<Slot, Item> heroEquipment;

    protected abstract List<ArmorType> getValidArmorTypes();

    protected abstract List<WeaponType> getValidWeaponTypes();

    private HeroAttribute levelAttributes;

    public Hero(String name, HeroAttribute heroAttribute) {
        this.name = name;
        this.level = 1;
        this.levelAttributes = heroAttribute;

        heroEquipment = new HashMap<Slot, Item>();
        heroEquipment.put(Slot.WEAPON, null);
        heroEquipment.put(Slot.HEAD, null);
        heroEquipment.put(Slot.BODY, null);
        heroEquipment.put(Slot.LEGS, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        levelAttributes.add(getLevelUpAttributes());
    }

    public void equipArmor(Armor armor) throws InvalidArmorException {

        if (!getValidArmorTypes().contains(armor.getArmorType())) {
            throw new InvalidArmorException("Your cannot equip " + armor.getArmorType());
        } else if (level < armor.getRequiredLevel()) {
            throw new InvalidArmorException("Your level is too low");
        } else {
            heroEquipment.put(armor.getSlot(), armor);
        }
    }

    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (!getValidWeaponTypes().contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Your cannot equip " + weapon.getWeaponType());
        } else if (level < weapon.getRequiredLevel()) {
            throw new InvalidWeaponException("Your level is too low");
        } else {
            heroEquipment.put(Slot.WEAPON, weapon);
        }
    }

    public void setLevelAttributes(HeroAttribute levelAttributes) {
        this.levelAttributes = levelAttributes;
    }

    public HeroAttribute getLevelAttributes() {
        return levelAttributes;
    }

    public abstract HeroAttribute getLevelUpAttributes();

    public HeroAttribute totalAttributes() {

        HeroAttribute totalValues = new HeroAttribute(0, 0, 0);
        totalValues.add(levelAttributes);

        heroEquipment.forEach((key, value) -> {
            if (value instanceof Armor) {
                HeroAttribute armorAttributes = ((Armor) value).getArmorAttribute();
                totalValues.add(armorAttributes);
            }
        });

        return totalValues;

    }

    public abstract int calculateDamage();

    public HashMap<Slot, Item> getHeroEquipment() {
        return heroEquipment;
    }

    public void setHeroEquipment(HashMap<Slot, Item> heroEquipment) {
        this.heroEquipment = heroEquipment;
    }

    public void displayHero() {

        System.out.printf("""
                        Name: %s
                        Level: %d
                        Total Strength: %d
                        Total Dexterity: %d
                        Total Intelligence: %d
                        """,
                name,
                level,
                levelAttributes.getStrength(),
                levelAttributes.getDexterity(),
                levelAttributes.getIntelligence());

    }


}
