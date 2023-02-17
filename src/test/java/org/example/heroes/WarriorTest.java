package org.example.heroes;

import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    //Some testing data
    Hero warrior = new Warrior("Winning Warrior");
    Weapon weaponForTesting = new Weapon("Hammerrr", 1, Slot.WEAPON, WeaponType.HAMMER, 6);
    Armor armorForTesting = new Armor("Platon", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(4, 3, 5));

    @Test
    public void getName() {
        Assertions.assertEquals("Winning Warrior", warrior.getName());
    }

    @Test
    public void getLevel() {
        Assertions.assertEquals(1, warrior.getLevel());
    }

    @Test
    void getLevelUpAttributes() {
        HeroAttribute heroAttributes_expected = new HeroAttribute(3, 2, 1);
        HeroAttribute heroAttributes_actual = warrior.getLevelUpAttributes();

        Assertions.assertEquals(heroAttributes_expected.getStrength(), heroAttributes_actual.getStrength());
        Assertions.assertEquals(heroAttributes_expected.getDexterity(), heroAttributes_actual.getDexterity());
        Assertions.assertEquals(heroAttributes_expected.getIntelligence(), heroAttributes_actual.getIntelligence());
    }

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

    @Test
    void getLevelUpHero() {
        assertEquals(1, warrior.getLevel());
        assertEquals(Warrior.STARTING_STRENGTH, warrior.getLevelAttributes().getStrength());
        assertEquals(Warrior.STARTING_DEXTERITY, warrior.getLevelAttributes().getDexterity());
        assertEquals(Warrior.STARTING_INTELLIGENCE, warrior.getLevelAttributes().getIntelligence());

        warrior.levelUp();

        assertEquals(2, warrior.getLevel());
        assertEquals(Warrior.STARTING_STRENGTH + Warrior.STRENGTH_LEVEL_UP, warrior.getLevelAttributes().getStrength());
        assertEquals(Warrior.STARTING_DEXTERITY + Warrior.DEXTERITY_LEVEL_UP, warrior.getLevelAttributes().getDexterity());
        assertEquals(Warrior.STARTING_INTELLIGENCE + Warrior.INTELLIGENCE_LEVEL_UP, warrior.getLevelAttributes().getIntelligence());
    }

    @Test
    public void calculateDamage() throws InvalidArmorException, InvalidWeaponException {

        warrior.levelUp();
        warrior.equipWeapon(weaponForTesting);
        warrior.equipArmor(armorForTesting);

        Assertions.assertEquals(6 * (1 + (10 / 100)), warrior.calculateDamage());
    }

    @Test
    public void displayHero() {

        String display_expected = """
                Name: Winning Warrior
                Level: 1
                Total Strength: 5
                Total Dexterity: 2
                Total Intelligence: 1
                """;

        String display_actual = format("""
                        Name: %s
                        Level: %d
                        Total Strength: %d
                        Total Dexterity: %d
                        Total Intelligence: %d
                        """,
                warrior.getName(),
                warrior.getLevel(),
                warrior.getLevelAttributes().getStrength(),
                warrior.getLevelAttributes().getDexterity(),
                warrior.getLevelAttributes().getIntelligence());

        Assertions.assertEquals(display_expected, display_actual);
    }

}