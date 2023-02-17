package org.example.heroes.subclasses;

import org.example.heroes.Hero;
import org.example.heroes.HeroAttribute;
import org.example.items.enums.ArmorType;
import org.example.items.enums.Slot;
import org.example.items.subclasses.Weapon;
import org.example.items.enums.WeaponType;

import java.util.List;

public class Ranger extends Hero {

    public static final int STARTING_STRENGTH = 1;
    public static final int STARTING_DEXTERITY = 7;
    public static final int STARTING_INTELLIGENCE = 1;

    public static final int STRENGTH_LEVEL_UP = 1;
    public static final int DEXTERITY_LEVEL_UP = 5;
    public static final int INTELLIGENCE_LEVEL_UP = 1;

    public Ranger(String name) {
        super(name, new HeroAttribute(STARTING_STRENGTH, STARTING_DEXTERITY, STARTING_INTELLIGENCE));
    }

    @Override
    public HeroAttribute getLevelUpAttributes() {
        return new HeroAttribute(STRENGTH_LEVEL_UP, DEXTERITY_LEVEL_UP, INTELLIGENCE_LEVEL_UP);
    }

    protected List<ArmorType> getValidArmorTypes() {
        return List.of(ArmorType.LEATHER, ArmorType.MAIL);
    }

    protected List<WeaponType> getValidWeaponTypes() {
        return List.of(WeaponType.BOW);
    }

    public int calculateDamage() {

        Weapon currentWeapon = (Weapon) getHeroEquipment().get(Slot.WEAPON);
        int currentWeaponDamage = currentWeapon.getWeaponDamage();
        int heroDamage = currentWeaponDamage * (1 + totalAttributes().getIntelligence() / 100);

        return heroDamage;
    }
}
