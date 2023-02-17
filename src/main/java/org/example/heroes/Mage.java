package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.Slot;
import org.example.items.Weapon;
import org.example.items.WeaponType;

import java.util.List;

public class Mage extends Hero {

    public static final int STARTING_STRENGTH = 1;
    public static final int STARTING_DEXTERITY = 1;
    public static final int STARTING_INTELLIGENCE = 8;

    public static final int STRENGTH_LEVEL_UP = 1;
    public static final int DEXTERITY_LEVEL_UP = 1;
    public static final int INTELLIGENCE_LEVEL_UP = 5;
    //note to self: By making the variable static, it becomes associated with the class itself, rather than instances of that class

    public Mage(String name) {
        super(name, new HeroAttribute(STARTING_STRENGTH, STARTING_DEXTERITY, STARTING_INTELLIGENCE));
    }

    @Override
    public HeroAttribute getLevelUpAttributes() {
        return new HeroAttribute(STRENGTH_LEVEL_UP, DEXTERITY_LEVEL_UP, INTELLIGENCE_LEVEL_UP);
    }

    protected List<ArmorType>getValidArmorTypes(){
        return List.of(ArmorType.CLOTH);
    }

    protected List<WeaponType>getValidWeaponTypes(){
        return List.of(WeaponType.STAFF, WeaponType.WAND);
    }

    public int calculateDamage() {

        Weapon currentWeapon = (Weapon) getHeroEquipment().get(Slot.WEAPON);
        int currentWeaponDamage = currentWeapon.getWeaponDamage();
        int heroDamage = currentWeaponDamage * (1 + totalAttributes().getIntelligence()/100);

        return heroDamage;
    }

}
