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
    private ArrayList<Territory> sharedBorderTerritories;
    private boolean selected;

    public Territory(String name){
        troopCount = 0;
        continent = null;
        sharedBorderTerritories = new ArrayList<Territory>();
        this.name = name;
        this.setText(String.valueOf(troopCount));
        selected = false;
    }


    public void addBorderTerritory(Territory ... territories){
        for(Territory territory : territories ) {
            sharedBorderTerritories.add(territory);
        }
    }

    public boolean sharesBorder(Territory territory){
        return sharedBorderTerritories.contains(territory);
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
        this.setText(String.valueOf(troopCount));
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

    public void setColor(String color){
        this.setStyle("-fx-font: 0 arial; -fx-base: " + color + ";");
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
        this.setText(String.valueOf(this.troopCount));
    }

    public void setColorSelected() {
        this.setStyle("-fx-padding: 15 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 15;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a2a30b 0%, #d7d82d 100%),\n" +
                "        #9d972c,\n" +
                "        #afd818,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d8d314, #b7c518);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
    }


    public void setColorStandard(){
        this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 10;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
    }

    public void select(){
        this.setColorSelected();
        selected = true;
    }

    public void deSelect(){
        this.setColorSelected();
        selected = false;
    }

    public void setAvailable(Boolean bool){
        this.setVisible(bool);
    }

    public boolean isOwnedBy(Player player){
        return player == currentOccupant;
    }

    public boolean canAttack(Player player){
        if (player.ownsTerritory(this))
                return false;
        for(Territory t : sharedBorderTerritories){
            if(t == player.getCurrentTerritory())
                return true;
        }
        return false;
    }
}
