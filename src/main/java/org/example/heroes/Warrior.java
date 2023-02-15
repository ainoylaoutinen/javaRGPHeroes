package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.WeaponType;

import java.util.List;

public class Warrior extends Hero {

    private static int STARTING_STRENGTH = 5;
    private static int STARTING_DEXTERITY = 2;
    private static int STARTING_INTELLIGENCE = 1;

    private static final int STRENGTH_LEVEL_UP = 3;
    private static final int DEXTERITY_LEVEL_UP = 2;
    private static final int INTELLIGENCE_LEVEL_UP = 1;

    public Warrior(String name) {
        super(name, new HeroAttribute(STARTING_STRENGTH, STARTING_DEXTERITY, STARTING_INTELLIGENCE));
    }

    @Override
    public HeroAttribute getLevelUpAttributes() {
        return new HeroAttribute(STRENGTH_LEVEL_UP, DEXTERITY_LEVEL_UP, INTELLIGENCE_LEVEL_UP);
    }

    protected List<ArmorType> getValidArmorTypes(){
        return List.of(ArmorType.MAIL,ArmorType.PLATE);
    }

    protected List<WeaponType>getValidWeaponTypes(){
        return List.of(WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD);
    }
}
