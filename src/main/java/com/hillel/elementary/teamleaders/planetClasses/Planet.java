//Создать объект класса Планета, используя классы Материк, Океан, Остров.
//Методы: вернуть название материка, планеты, количество материков.
package com.hillel.elementary.teamleaders.planetClasses;
import java.util.ArrayList;

public class Planet {

    private String planetName = "Elrock";
    private ArrayList<Island> islands;
    private ArrayList<Mainland> mainlands;
    private ArrayList<Ocean> oceans;

    Planet() {
        this.islands = new ArrayList<>();
            islands.add(new Island());
        this.mainlands = new ArrayList<>();
            mainlands.add(new Mainland());
        this.oceans = new ArrayList<>();
            oceans.add(new Ocean());
    }

    Planet(ArrayList<Island> islands, ArrayList<Mainland> mainlands, ArrayList<Ocean> oceans) {
        this.islands = islands;
        this.mainlands = mainlands;
        this.oceans = oceans;
    }

    Planet(String planetName, ArrayList<Island> islands, ArrayList<Mainland> mainlands, ArrayList<Ocean> oceans) {
        this.planetName = planetName;
        this.islands = islands;
        this.mainlands = mainlands;
        this.oceans = oceans;
    }

    public String getPlanetName() {
        return planetName;
    }

    public String getMainlandName(int count) {
        return mainlands.get(count).getName();
    }

    public int getCountOfMainlands() {
        return mainlands.size();
    }

    public ArrayList<Island> getIslands() {
        return islands;
    }

    public ArrayList<Mainland> getMainlands() {
        return mainlands;
    }

    public ArrayList<Ocean> getOceans() {
        return oceans;
    }
}
