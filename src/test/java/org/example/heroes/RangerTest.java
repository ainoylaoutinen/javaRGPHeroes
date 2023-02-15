package org.example.heroes;

import org.example.items.ArmorType;
import org.example.items.WeaponType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RangerTest {

    Hero ranger = new Ranger("Great Ranger");

    @Test
    void getLevelUpAttributes() {

        HeroAttribute heroAttributes_expected = new HeroAttribute(1, 5, 1);
        HeroAttribute heroAttributes_actual = ranger.getLevelUpAttributes();

        Assertions.assertEquals(heroAttributes_expected.getStrength(), heroAttributes_actual.getStrength());
        Assertions.assertEquals(heroAttributes_expected.getDexterity(), heroAttributes_actual.getDexterity());
        Assertions.assertEquals(heroAttributes_expected.getIntelligence(), heroAttributes_actual.getIntelligence());
    }


    @Test
    void getLevelUpHero() {
        assertEquals(0, ranger.getLevel());
        assertEquals(Ranger.STARTING_STRENGTH, ranger.getHeroAttribute().getStrength());

        ranger.levelUp();

        assertEquals(Ranger.STARTING_STRENGTH + Ranger.STRENGTH_LEVEL_UP, ranger.getHeroAttribute().getStrength());
        assertEquals(1, ranger.getLevel());
    }


    @Test
    void getValidArmorTypes() {

        List<ArmorType> armorType_expected = List.of(ArmorType.LEATHER, ArmorType.MAIL);
        List<ArmorType> armorType_actual = ranger.getValidArmorTypes();

        Assertions.assertEquals(armorType_expected, armorType_actual);
    }


    @Test
    void getValidWeaponTypes() {

        List<WeaponType> weaponType_expected = List.of(WeaponType.BOW);
        List<WeaponType> weaponType_actual = ranger.getValidWeaponTypes();

        Assertions.assertEquals(weaponType_expected, weaponType_actual);
    }
}