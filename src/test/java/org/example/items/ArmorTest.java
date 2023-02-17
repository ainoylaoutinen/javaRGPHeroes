package org.example.items;

import org.example.heroes.HeroAttribute;
import org.example.items.enums.ArmorType;
import org.example.items.enums.Slot;
import org.example.items.subclasses.Armor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmorTest {

    Armor armor = new Armor("Never Die Mail", 3, Slot.BODY, ArmorType.MAIL, new HeroAttribute(3, 4, 5));


    @Test
    void testConstructor() {

        Assertions.assertEquals("Never Die Mail", armor.getItemName());
        Assertions.assertEquals(3, armor.getRequiredLevel());
        Assertions.assertEquals(Slot.BODY, armor.getSlot());
        Assertions.assertEquals(ArmorType.MAIL, armor.getArmorType());
    }

    @Test
    public void getArmorAttributes() {

        HeroAttribute armorAttributes_expected = new HeroAttribute(3, 4, 5);
        HeroAttribute armorAttributes_actual = armor.getArmorAttribute();

        Assertions.assertEquals(armorAttributes_expected.getIntelligence(), armorAttributes_actual.getIntelligence());
    }

}
