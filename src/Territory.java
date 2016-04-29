import javafx.scene.control.Button;

/**
 * Created by Mitch on 4/27/2016.
 */
public class Territory extends Button {

    private Player currentOccupant;
    private Continent continent;
    private String name;
    private int troopCount;

    public Territory(){
        name = null;
        troopCount = 0;
        continent = null;
    }

    public Territory(String name, Continent continent){
        this.name = name;
        troopCount = 0;
        this.continent = continent;
    }

    public void addTroops(int troops){
        troopCount += troops;
    }

    public void removeTroops(int troops){
        if(troopCount >= troops) {
            troopCount -= troops;
        }
        else
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


}
