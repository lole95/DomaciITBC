package Pokemoni;

/**
 * Project Nedelja5, Package Pokemoni, Class Test, Created by Milovan 28.8.2021.
 */
public class Test {
    public static void main(String[] args) {
        Pokemon w = new WaterPokemon("Vodeni", "Water", 30);
        Pokemon g = new GrassPokemon("Naduvani", "Travnasti", 3);
        Pokemon f = new FirePokemon("Zipo", "Fire", 99);

        System.out.println(w.logAll());
        System.out.println(g.logAll());
        System.out.println(f.logAll());
    }
}

