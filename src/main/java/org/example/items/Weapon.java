package org.example.items;

public class Weapon extends Item{

    private WeaponType weaponType;
    private WeaponDamage weaponDamage;

    public Weapon(String itemName, int requiredLevel, Slot slot) {
        super(itemName, requiredLevel, slot);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public WeaponDamage getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(WeaponDamage weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
