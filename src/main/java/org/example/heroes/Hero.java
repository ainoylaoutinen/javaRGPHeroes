package org.example.heroes;

import org.example.items.*;
import org.example.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Hero {

    private String name;
    private int level;
    private HeroAttribute levelAttributes;

    ArrayList<String> equipment = new ArrayList<String>();
    ArrayList<String> validWeaponTypes = new ArrayList<String>();
    ArrayList<String> validArmorTypes = new ArrayList<String>();

    private HashMap<Slot, Item> heroEquipment;
    //When a new Hero is created, the equipment is initialized with null values to represent empty slots

    {
        heroEquipment = new HashMap<Slot, Item>();
        heroEquipment.put(Slot.WEAPON, null);
        heroEquipment.put(Slot.HEAD, null);
        heroEquipment.put(Slot.BODY, null);
        heroEquipment.put(Slot.LEGS, null);

    }

    protected abstract List<ArmorType> getValidArmorTypes();

    protected abstract List<WeaponType> getValidWeaponTypes();

    public HeroAttribute getHeroAttribute() {
        return heroAttribute;
    }

    public void setHeroAttribute(HeroAttribute heroAttribute) {
        this.heroAttribute = heroAttribute;
    }

    private HeroAttribute heroAttribute;


    public Hero(String name, HeroAttribute heroAttribute) {
        this.name = name;
        this.level = 0;
        //this.levelAttributes = levelAttributes;.. or heroAttributes?
        this.heroAttribute = heroAttribute;
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
        heroAttribute.add(getLevelUpAttributes());
    }

    public void equipArmor(Armor armor) throws InvalidArmorException {

    if (!getValidArmorTypes().contains(armor.getArmorType())) {
     throw new InvalidArmorException("Your cannot equip " + armor.getArmorType());
    } else {
        //if (getValidArmorTypes().contains(armor.getArmorType())) {
        heroEquipment.put(armor.getSlot(), armor);
    }
    }

    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
    if (!getValidWeaponTypes().contains(weapon.getWeaponType())) {
        throw new InvalidWeaponException("Your cannot equip " + weapon.getWeaponType());
    } else {
        //if (getValidWeaponTypes().contains(weapon.getWeaponType())) {
        heroEquipment.put(Slot.WEAPON, weapon);
    }
    }
 
    public abstract HeroAttribute getLevelUpAttributes();
}
