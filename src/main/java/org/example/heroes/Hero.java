package org.example.heroes;

import java.util.ArrayList;
public class Hero {

    private String name;
    private int level;
    //private int levelAttributes;

    ArrayList<String> equipment = new ArrayList<String>();
    ArrayList<String> validWeaponTypes = new ArrayList<String>();
    ArrayList<String> validArmorTypes = new ArrayList<String>();

    private HeroAttribute heroAttribute;

    public Hero(String name, int level, HeroAttribute heroAttribute) {
        //int levelAttributes
        this.name = name;
        this.level = level;
        //this.levelAttributes = levelAttributes;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {
        level = level + 1;
    }
}
