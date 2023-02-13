package org.example.heroes;

import org.example.items.Item;
import org.example.items.Slot;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Hero {

    private String name;
    private int level;
    //private int levelAttributes;... = heroAttrubutes?

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


    public abstract HeroAttribute getLevelUpAttributes();
}
