package Pokemoni;

/**
 * Project Nedelja5, Package Pokemoni, Class Pokemon, Created by Milovan 28.8.2021.
 */
public abstract class Pokemon implements Attackable {
    private String name, type;
    private int health;

    public Pokemon(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public abstract String logAll(); //Ispisuje kako pokemon napada, kako se brani, koga pobedjuje i od koga gubi
}

