package org.example.heroes;

public class Mage extends Hero {

    int mageStrength = 1;
    int mageDexterity = 1;
    int mageIntelligence = 8;

    public Mage(String name, int level, HeroAttribute heroAttribute) {
        super(name, level, heroAttribute);
    }

    public int getMageStrength() {
        return mageStrength;
    }

    public void setMageStrength(int mageStrength) {
        this.mageStrength = mageStrength;
    }

    public int getMageDexterity() {
        return mageDexterity;
    }

    public void setMageDexterity(int mageDexterity) {
        this.mageDexterity = mageDexterity;
    }

    public int getMageIntelligence() {
        return mageIntelligence;
    }

    public void setMageIntelligence(int mageIntelligence) {
        this.mageIntelligence = mageIntelligence;
    }
}
