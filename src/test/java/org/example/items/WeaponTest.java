package org.example.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
//Testing the constructor of the Weapon class

    @Test
    void testConstructor() {

        Weapon weapon = new Weapon("Epic axe 3000", 4, Slot.WEAPON, WeaponType.AXE, 2000);
        //note to self: if this was Item weapon, it would only be able to access Item attributes

        Assertions.assertEquals("Epic axe 3000", weapon.getItemName());
        Assertions.assertEquals(4, weapon.getRequiredLevel());
        Assertions.assertEquals(Slot.WEAPON, weapon.getSlot());
        Assertions.assertEquals(WeaponType.AXE, weapon.getWeaponType());
        Assertions.assertEquals(2000, weapon.getWeaponDamage());
    }
}