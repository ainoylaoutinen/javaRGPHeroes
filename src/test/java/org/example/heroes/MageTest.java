package org.example.heroes;

import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.heroes.subclasses.Mage;
import org.example.items.*;
import org.example.items.enums.ArmorType;
import org.example.items.enums.Slot;
import org.example.items.enums.WeaponType;
import org.example.items.subclasses.Armor;
import org.example.items.subclasses.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    //Some testing data
    Hero mage = new Mage("Amazing Mage");
    Weapon weaponForTesting = new Weapon("Wandie", 1, Slot.WEAPON, WeaponType.WAND, 5);
    Item anotherWeaponForTesting = new Item("weapon3", 1, Slot.WEAPON);
    Armor armorForTestingTotal = new Armor("Armor 1", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(2, 2, 2));
    Armor armorForTestingDamage = new Armor("Clothie", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1, 2, 2));

    @Test
    public void getName() {
        Assertions.assertEquals("Amazing Mage", mage.getName());
    }

    @Test
    public void getLevel() {
        Assertions.assertEquals(1, mage.getLevel());
    }

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
    void getLevelUpHero() {
        assertEquals(1, mage.getLevel());
        assertEquals(Mage.STARTING_STRENGTH, mage.getLevelAttributes().getStrength());
        assertEquals(Mage.STARTING_DEXTERITY, mage.getLevelAttributes().getDexterity());
        assertEquals(Mage.STARTING_INTELLIGENCE, mage.getLevelAttributes().getIntelligence());
        //note to self: Mage. instead of mage. because the attributes belong to Mage class, not a specific mage

        mage.levelUp();

        assertEquals(2, mage.getLevel());
        assertEquals(Mage.STARTING_STRENGTH + Mage.STRENGTH_LEVEL_UP, mage.getLevelAttributes().getStrength());
        assertEquals(Mage.STARTING_DEXTERITY + Mage.DEXTERITY_LEVEL_UP, mage.getLevelAttributes().getDexterity());
        assertEquals(Mage.STARTING_INTELLIGENCE + Mage.INTELLIGENCE_LEVEL_UP, mage.getLevelAttributes().getIntelligence());
    }

    @Test
    void testTotalAttributes() throws InvalidArmorException {

        mage.equipArmor(armorForTestingTotal);

        HeroAttribute expected_total = new HeroAttribute(3, 3, 10);
        HeroAttribute actual_total = mage.totalAttributes();

        assertEquals(expected_total.getIntelligence(), actual_total.getIntelligence());
        assertEquals(expected_total.getDexterity(), actual_total.getDexterity());
        assertEquals(expected_total.getStrength(), actual_total.getStrength());

    }

    @Test
    public void calculateDamage() throws InvalidArmorException, InvalidWeaponException {

        mage.levelUp();
        mage.equipWeapon(weaponForTesting);
        mage.equipArmor(armorForTestingDamage);

        Assertions.assertEquals(5 * (1 + (10 / 100)), mage.calculateDamage());
    }

    @Test
    public void displayHero() {

        String display_expected = """
                Name: Amazing Mage
                Level: 1
                Total Strength: 1
                Total Dexterity: 1
                Total Intelligence: 8
                """;

        String display_actual = format("""
                        Name: %s
                        Level: %d
                        Total Strength: %d
                        Total Dexterity: %d
                        Total Intelligence: %d
                        """,
                mage.getName(),
                mage.getLevel(),
                mage.getLevelAttributes().getStrength(),
                mage.getLevelAttributes().getDexterity(),
                mage.getLevelAttributes().getIntelligence());

        Assertions.assertEquals(display_expected, display_actual);
    }

}