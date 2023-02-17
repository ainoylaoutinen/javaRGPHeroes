package org.example.items.subclasses;

import org.example.items.Item;
import org.example.items.enums.Slot;
import org.example.items.enums.WeaponType;

public class Weapon extends Item {

    private int weaponDamage;
    private WeaponType weaponType;

    public Weapon(String itemName, int requiredLevel, Slot slot, WeaponType weapontype, int weaponDamage) {
        super(itemName, requiredLevel, slot);
        this.weaponType = weapontype;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }


}


