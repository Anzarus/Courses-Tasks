//Создать объект класса Планета, используя классы Материк, Океан, Остров.
//Методы: вернуть название материка, планеты, количество материков.

package com.hillel.elementary.teamleaders.planetClasses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PlanetTest {

    @Test
    void creationPlanetTest() {
        ArrayList<Island> islands = new ArrayList<>();
            islands.add(new Island("Giltar"));
            islands.add(new Island("Jerin"));
            islands.add(new Island("Pasbol"));

        ArrayList<Mainland> mainlands = new ArrayList<>();
            mainlands.add(new Mainland("Tascoul"));
            mainlands.add(new Mainland("Gotgolab"));

        ArrayList<Ocean> oceans = new ArrayList<>();
            oceans.add(new Ocean("Morowater"));
            oceans.add(new Ocean("Lowsea"));

        String planet = "Kar'N'rock";
        int countOfMainlands = 2;


        Planet newPlanet = new Planet(planet, islands, mainlands, oceans);

        assertEquals(planet, newPlanet.getPlanetName());
        assertEquals(mainlands.get(0).getName(), newPlanet.getMainlandName(0));
        assertEquals(mainlands.get(1).getName(), newPlanet.getMainlandName(1));
        assertEquals(countOfMainlands, newPlanet.getCountOfMainlands());
    }

    @Test
    void anotherPlanetTest() {
        Planet newPlanet = new Planet();

        assertEquals("Elrock", newPlanet.getPlanetName());
        assertEquals("Giltar", newPlanet.getIslands().get(0).getName());
        assertEquals("Gotgolab", newPlanet.getMainlands().get(0).getName());
        assertEquals("Lowsea", newPlanet.getOceans().get(0).getName());
    }
}
