package org.example.heroes;

public class Rogue extends Hero {

    private static int STARTING_STRENGTH = 2;
    private static int STARTING_DEXTERITY = 6;
    private static int STARTING_INTELLIGENCE = 1;

    private static final int STRENGTH_LEVEL_UP = 1;
    private static final int DEXTERITY_LEVEL_UP = 4;
    private static final int INTELLIGENCE_LEVEL_UP = 1;

    public Rogue(String name) {
        super(name, new HeroAttribute(STARTING_STRENGTH, STARTING_DEXTERITY, STARTING_INTELLIGENCE));
    }

    @Override
    public HeroAttribute getLevelUpAttributes() {
        return new HeroAttribute(STRENGTH_LEVEL_UP, DEXTERITY_LEVEL_UP, INTELLIGENCE_LEVEL_UP);
    }
}
