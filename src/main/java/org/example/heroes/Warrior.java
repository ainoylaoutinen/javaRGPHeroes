package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.Slot;
import org.example.items.Weapon;
import org.example.items.WeaponType;

import java.util.List;

public class Warrior extends Hero {

    public static final int STARTING_STRENGTH = 5;
    public static final int STARTING_DEXTERITY = 2;
    public static final int STARTING_INTELLIGENCE = 1;

    public static final int STRENGTH_LEVEL_UP = 3;
    public static final int DEXTERITY_LEVEL_UP = 2;
    public static final int INTELLIGENCE_LEVEL_UP = 1;

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

    public int calculateDamage() {

        Weapon currentWeapon = (Weapon) getHeroEquipment().get(Slot.WEAPON);
        int currentWeaponDamage = currentWeapon.getWeaponDamage();
        int heroDamage = currentWeaponDamage * (1 + totalAttributes().getIntelligence()/100);

        return heroDamage;
    }
}
