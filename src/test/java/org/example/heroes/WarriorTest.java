package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Hero warrior = new Warrior("Winning Warrior");

    @Test
    void getLevelUpAttributes() {
        HeroAttribute heroAttributes_expected = new HeroAttribute(3, 2, 1);
        HeroAttribute heroAttributes_actual = warrior.getLevelUpAttributes();

        Assertions.assertEquals(heroAttributes_expected.getStrength(), heroAttributes_actual.getStrength());
        Assertions.assertEquals(heroAttributes_expected.getDexterity(), heroAttributes_actual.getDexterity());
        Assertions.assertEquals(heroAttributes_expected.getIntelligence(), heroAttributes_actual.getIntelligence());    }

    @Test
    void getValidArmorTypes() {

        List<ArmorType> armorType_expected = List.of(ArmorType.MAIL, ArmorType.PLATE);
        List<ArmorType> armorType_actual = warrior.getValidArmorTypes();

        Assertions.assertEquals(armorType_expected, armorType_actual);
    }

    @Test
    void getValidWeaponTypes() {

        List<WeaponType> weaponType_expected = List.of(WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD);
        List<WeaponType> weaponType_actual = warrior.getValidWeaponTypes();

        Assertions.assertEquals(weaponType_expected, weaponType_actual);
    }
}