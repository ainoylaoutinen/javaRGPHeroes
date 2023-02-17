package org.example.heroes;

import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    //Basic test data
    Hero rogue = new Rogue("Bad Rogue");
    Armor armorForTesting = new Armor("Armory", 1, Slot.BODY, ArmorType.MAIL, new HeroAttribute(1, 2, 5));
    Weapon weaponForTesting = new Weapon("daggery", 1, Slot.WEAPON, WeaponType.DAGGER, 3);

    @Test
    public void getName(){
        Assertions.assertEquals("Bad Rogue", rogue.getName());
    }

    @Test
    public void getLevel() {
        Assertions.assertEquals(1, rogue.getLevel());
    }

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

    @Test
    void getLevelUpHero() {
        assertEquals(1, rogue.getLevel());
        assertEquals(Rogue.STARTING_STRENGTH, rogue.getLevelAttributes().getStrength());
        assertEquals(Rogue.STARTING_DEXTERITY, rogue.getLevelAttributes().getDexterity());
        assertEquals(Rogue.STARTING_INTELLIGENCE, rogue.getLevelAttributes().getIntelligence());

        rogue.levelUp();

        assertEquals(2, rogue.getLevel());
        assertEquals(Rogue.STARTING_STRENGTH + Rogue.STRENGTH_LEVEL_UP, rogue.getLevelAttributes().getStrength());
        assertEquals(Rogue.STARTING_DEXTERITY + Rogue.DEXTERITY_LEVEL_UP, rogue.getLevelAttributes().getDexterity());
        assertEquals(Rogue.STARTING_INTELLIGENCE + Rogue.INTELLIGENCE_LEVEL_UP, rogue.getLevelAttributes().getIntelligence());
    }

    @Test
    public void calculateDamage() throws InvalidArmorException, InvalidWeaponException {

        rogue.levelUp();
        rogue.equipWeapon(weaponForTesting);
        rogue.equipArmor(armorForTesting);

        Assertions.assertEquals(3*(1+(10/100)), rogue.calculateDamage());
    }

    @Test
    public void displayHero() {

        String display_expected = """
                    Name: Bad Rogue
                    Level: 1
                    Total Strength: 2
                    Total Dexterity: 6
                    Total Intelligence: 1
                    """;

        String display_actual = format("""
                    Name: %s
                    Level: %d
                    Total Strength: %d
                    Total Dexterity: %d
                    Total Intelligence: %d
                    """,
                rogue.getName(),
                rogue.getLevel(),
                rogue.getLevelAttributes().getStrength(),
                rogue.getLevelAttributes().getDexterity(),
                rogue.getLevelAttributes().getIntelligence());

        Assertions.assertEquals(display_expected, display_actual);
    }

}