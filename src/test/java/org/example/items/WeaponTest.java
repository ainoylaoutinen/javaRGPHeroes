package org.example.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
//Testing the constructor of the Weapon class

    @Test
    void testConstructor() {

        Weapon weapon = new Weapon("Good weapon", 4, Slot.WEAPON, WeaponType.AXE, 2000);

        Assertions.assertEquals("Good weapon", weapon.getItemName());
        Assertions.assertEquals(4, weapon.getRequiredLevel());
        Assertions.assertEquals(Slot.WEAPON, weapon.getSlot());
        Assertions.assertEquals(WeaponType.AXE, weapon.getWeaponType());
        Assertions.assertEquals(2000, weapon.getWeaponDamage());
    }
}