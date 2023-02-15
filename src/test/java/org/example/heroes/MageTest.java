package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.heroes.Mage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    Hero mage = new Mage("Amazing Mage");

    @Test
    void getLevelUpAttributes() {
        HeroAttribute heroAttributes_expected = new HeroAttribute(1, 1, 5);
        HeroAttribute heroAttributes_actual = mage.getLevelUpAttributes();

        Assertions.assertEquals(heroAttributes_expected.getStrength(), heroAttributes_actual.getStrength());
        Assertions.assertEquals(heroAttributes_expected.getDexterity(), heroAttributes_actual.getDexterity());
        Assertions.assertEquals(heroAttributes_expected.getIntelligence(), heroAttributes_actual.getIntelligence());
    }

    @Test
    void getValidArmorTypes() {

        List<ArmorType> armorType_expected = List.of(ArmorType.CLOTH);
        List<ArmorType> armorType_actual = mage.getValidArmorTypes();

        Assertions.assertEquals(armorType_expected, armorType_actual);
    }

    @Test
    void getValidWeaponTypes() {

        List<WeaponType> weaponType_expected = List.of(WeaponType.WAND, WeaponType.STAFF);
        List<WeaponType> weaponType_actual = mage.getValidWeaponTypes();

        Assertions.assertEquals(weaponType_expected, weaponType_actual);
    }

    @Test
    void levelUp() {



    }
}