import java.util.ArrayList;

/**
 * Created by Mitch on 4/27/2016.
 */
public class Continent {

    private int numberOfTerritories, bonus;
    private ArrayList<Territory> territoryList;
    private boolean isConquered;
    private Player ruler;
    private String name;


    public Continent(String name, int bonus, Territory ... territories){
        for (Territory terrritory: territories){
            territoryList.add(terrritory);
            terrritory.setContinent(this);
        }
        numberOfTerritories = territoryList.size();
        isConquered = false;
        ruler = null;
        this.bonus = bonus;
        this.name = name;
    }

    public int getBonus(){
        return bonus;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    public ArrayList<Territory> getTerritoryList() {
        return territoryList;
    }

    public void setTerritoryList(ArrayList<Territory> territoryList) {
        this.territoryList = territoryList;
    }

    public void updateStatus(){

        String name;

        for(Territory territory : territoryList){
            name = territory.getCurrentOccupant().getName();

        }
    }
}
