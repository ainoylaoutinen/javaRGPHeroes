package org.example.heroes;

public class Warrior extends Hero {

    int warriorStrength = 5;
    int warriorDexterity = 2;
    int warriorIntelligence = 1;

    public Warrior(String name, int level, HeroAttribute heroAttribute) {
        super(name, level, heroAttribute);
    }

    public int getWarriorStrength() {
        return warriorStrength;
    }

    public void setWarriorStrength(int warriorStrength) {
        this.warriorStrength = warriorStrength;
    }

    public int getWarriorDexterity() {
        return warriorDexterity;
    }

    public void setWarriorDexterity(int warriorDexterity) {
        this.warriorDexterity = warriorDexterity;
    }

    public int getWarriorIntelligence() {
        return warriorIntelligence;
    }

    public void setWarriorIntelligence(int warriorIntelligence) {
        this.warriorIntelligence = warriorIntelligence;
    }
}
