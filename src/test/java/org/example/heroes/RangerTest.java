package org.example.heroes;

import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;


class RangerTest {

    //Basic test data
    Hero ranger = new Ranger("Great Ranger");
    Armor armorForTesting = new Armor("Armor 1", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(2, 2, 2));
    Weapon weaponForTesting = new Weapon("DBowie", 1, Slot.WEAPON, WeaponType.BOW, 4);

    @Test
    public void getName(){
        Assertions.assertEquals("Great Ranger", ranger.getName());
    }

    @Test
    public void getLevel() {
        Assertions.assertEquals(1, ranger.getLevel());
    }

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
        assertEquals(1, ranger.getLevel());
        assertEquals(Ranger.STARTING_STRENGTH, ranger.getLevelAttributes().getStrength());
        assertEquals(Ranger.STARTING_DEXTERITY, ranger.getLevelAttributes().getDexterity());
        assertEquals(Ranger.STARTING_INTELLIGENCE, ranger.getLevelAttributes().getIntelligence());

        ranger.levelUp();
        //running the method for seeing if it increases the level + attributes => also if .add works

        assertEquals(2, ranger.getLevel());
        assertEquals(Ranger.STARTING_STRENGTH + Ranger.STRENGTH_LEVEL_UP, ranger.getLevelAttributes().getStrength());
        assertEquals(Ranger.STARTING_DEXTERITY + Ranger.DEXTERITY_LEVEL_UP, ranger.getLevelAttributes().getDexterity());
        assertEquals(Ranger.STARTING_INTELLIGENCE + Ranger.INTELLIGENCE_LEVEL_UP, ranger.getLevelAttributes().getIntelligence());
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

    @Test
    public void calculateDamage() throws InvalidArmorException, InvalidWeaponException {

        ranger.levelUp();
        ranger.equipWeapon(weaponForTesting);
        ranger.equipArmor(armorForTesting);

        Assertions.assertEquals(4*(1+(10/100)), ranger.calculateDamage());
    }

    @Test
    public void displayHero() {

        String display_expected = """
                    Name: Great Ranger
                    Level: 1
                    Total Strength: 1
                    Total Dexterity: 7
                    Total Intelligence: 1
                    """;

        String display_actual = format("""
                    Name: %s
                    Level: %d
                    Total Strength: %d
                    Total Dexterity: %d
                    Total Intelligence: %d
                    """,
                ranger.getName(),
                ranger.getLevel(),
                ranger.getLevelAttributes().getStrength(),
                ranger.getLevelAttributes().getDexterity(),
                ranger.getLevelAttributes().getIntelligence());

        Assertions.assertEquals(display_expected, display_actual);
    }

}