package org.example.items;

import org.example.items.enums.Slot;
import org.example.items.enums.WeaponType;
import org.example.items.subclasses.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeaponTest {
//Testing the constructor of the Weapon class

    Weapon weapon = new Weapon("Epic axe 3000", 4, Slot.WEAPON, WeaponType.AXE, 55);
    //note to self: if this was Item weapon, it would only be able to access Item attributes

    @Test
    void testConstructor() {

        Assertions.assertEquals("Epic axe 3000", weapon.getItemName());
        Assertions.assertEquals(4, weapon.getRequiredLevel());
        Assertions.assertEquals(Slot.WEAPON, weapon.getSlot());
        Assertions.assertEquals(WeaponType.AXE, weapon.getWeaponType());
        Assertions.assertEquals(55, weapon.getWeaponDamage());
    }

}