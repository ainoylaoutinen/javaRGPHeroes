package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    Hero rogue = new Rogue("Bad Rogue");

    @Test
    void getLevelUpAttributes() {
        HeroAttribute heroAttributes_expected = new HeroAttribute(1, 4, 1);
        HeroAttribute heroAttributes_actual = rogue.getLevelUpAttributes();

        Assertions.assertEquals(heroAttributes_expected.getStrength(), heroAttributes_actual.getStrength());
        Assertions.assertEquals(heroAttributes_expected.getDexterity(), heroAttributes_actual.getDexterity());
        Assertions.assertEquals(heroAttributes_expected.getIntelligence(), heroAttributes_actual.getIntelligence());    }

    @Test
    void getValidArmorTypes() {

        List<ArmorType> armorType_expected = List.of(ArmorType.LEATHER, ArmorType.MAIL);
        List<ArmorType> armorType_actual = rogue.getValidArmorTypes();

        Assertions.assertEquals(armorType_expected, armorType_actual);
    }

    @Test
    void getValidWeaponTypes() {
        List<WeaponType> weaponType_expected = List.of(WeaponType.DAGGER, WeaponType.SWORD);
        List<WeaponType> weaponType_actual = rogue.getValidWeaponTypes();

        Assertions.assertEquals(weaponType_expected, weaponType_actual);
    }
}