import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Created by Mitch on 4/27/2016.
 */
public class Territory extends Button {

    private Player currentOccupant;
    private Continent continent;
    private String name;
    private int troopCount;
    private ArrayList<Territory> sharedBorderContinents;

    public Territory(){
        name = null;
        troopCount = 0;
        continent = null;
        sharedBorderContinents = new ArrayList<Territory>();
    }


    public void addBorderTerritory(Territory territory){
        sharedBorderContinents.add(territory);
    }

    public boolean sharesBorder(Territory territory){
        return sharedBorderContinents.contains(territory);
    }

    public boolean isPartOfContinent(Continent continent){
        return this.continent == continent;
    }

    public Territory(String name, Continent continent){
        this.name = name;
        troopCount = 0;
        this.continent = continent;
    }

    public void updateTroopCount(int troops){//can update with negative or positive integer for troops
        if(troopCount + troops >= 0){
            troopCount += troops;
        }else
            troopCount = 0;
    }

    public void setContinent(Continent continent){
        this.continent = continent;
    }

    public Continent getContinent(){
        return continent;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public Player getCurrentOccupant() {
        return currentOccupant;
    }

    public void setCurrentOccupant(Player currentOccupant) {
        this.currentOccupant = currentOccupant;
    }

    public int getTroopCount() {
        return troopCount;
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
    }
}
