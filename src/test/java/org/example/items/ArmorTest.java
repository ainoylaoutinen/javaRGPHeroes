package org.example.items;

import org.example.heroes.HeroAttribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmorTest {

    @Test
    void testConstructor() {

        Armor armor = new Armor("Never Die Mail", 3, Slot.BODY, ArmorType.MAIL, new HeroAttribute(3, 4, 5));

        Assertions.assertEquals("Never Die Mail", armor.getItemName());
        Assertions.assertEquals(3, armor.getRequiredLevel());
        Assertions.assertEquals(Slot.BODY, armor.getSlot());
        Assertions.assertEquals(ArmorType.MAIL, armor.getArmorType());
    }

}
