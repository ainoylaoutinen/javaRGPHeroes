package org.example.heroes;

public class Rogue extends Hero {

    int rogueStrength = 2;
    int rogueDexterity = 6;
    int rogueIntelligence = 1;

    public Rogue(String name, int level, HeroAttribute heroAttribute) {
        super(name, level, heroAttribute);
    }

    public int getRogueStrength() {
        return rogueStrength;
    }

    public void setRogueStrength(int rogueStrength) {
        this.rogueStrength = rogueStrength;
    }

    public int getRogueDexterity() {
        return rogueDexterity;
    }

    public void setRogueDexterity(int rogueDexterity) {
        this.rogueDexterity = rogueDexterity;
    }

    public int getRogueIntelligence() {
        return rogueIntelligence;
    }

    public void setRogueIntelligence(int rogueIntelligence) {
        this.rogueIntelligence = rogueIntelligence;
    }
}
