package org.example.heroes;

public class Ranger extends Hero {

    int rangerStrength = 1;
    int rangerDexterity = 7;
    int rangerIntelligence = 1;

    public Ranger(String name, int level, HeroAttribute heroAttribute) {
        super(name, level, heroAttribute);
    }

    public int getRangerStrength() {
        return rangerStrength;
    }

    public void setRangerStrength(int rangerStrength) {
        this.rangerStrength = rangerStrength;
    }

    public int getRangerDexterity() {
        return rangerDexterity;
    }

    public void setRangerDexterity(int rangerDexterity) {
        this.rangerDexterity = rangerDexterity;
    }

    public int getRangerIntelligence() {
        return rangerIntelligence;
    }

    public void setRangerIntelligence(int rangerIntelligence) {
        this.rangerIntelligence = rangerIntelligence;
    }
}
