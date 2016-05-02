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
    private boolean selectedForAttack;

    public Territory(String name){
        troopCount = 0;
        continent = null;
        sharedBorderTerritories = new ArrayList<Territory>();
        this.name = name;
        this.setText(String.valueOf(troopCount));
        selected = false;
        selectedForAttack = false;
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

    public void incrementTroopCount(){
        troopCount++;
        this.setText(String.valueOf(troopCount));
    }
    public void decrementTroopCount(){
        if(troopCount > 0) {
            troopCount--;
            this.setText(String.valueOf(troopCount));
        }
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


    public void setColorStandard() {
        String playerName = currentOccupant.getName();


        if (playerName == "Targaryen") {
            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, rgba(197, 102, 25, 0.82) 0%, #7a390e 100%),\n" +
                    "        #ad5014,\n" +
                    "        #944c13,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #944213, #843d0f);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");
        } else if (playerName == "Lannister") {

            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, #d53e18 0%, #ac3814 100%),\n" +
                    "        #f34b34,\n" +
                    "        #d8663f,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #d82f1b, #992b19);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");

        } else if (playerName == "Baratheon") {

            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, #fe7b0d 0%, #b54a17 100%),\n" +
                    "        #d16325,\n" +
                    "        #fe7b0d,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #f67b1d, #b1480a);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");
        } else if (playerName == "Greyjoy") {

            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, #8c38c8 0%, #5a2b71 100%),\n" +
                    "        #563575,\n" +
                    "        #aa48d8,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #ba52eb, #5a10aa);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");
        } else if (playerName == "Martel") {

            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, #c02b94 0%, #9f2379 100%),\n" +
                    "        #9d386e,\n" +
                    "        #d855a4,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #d855a4, #b0447f);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");
        }else if (playerName == "Tully") {

            this.setStyle("  -fx-padding: 1 5 5 5;\n" +
                    "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                    "    -fx-background-radius: 10;\n" +
                    "    -fx-background-color: \n" +
                    "        linear-gradient(from 0% 93% to 0% 100%, #5dbcae 0%, #418982 100%),\n" +
                    "        #388976,\n" +
                    "        #54bc9b,\n" +
                    "        radial-gradient(center 50% 50%, radius 100%, #6cd8bd, #498c6f);\n" +
                    "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-font-size: 1.1em;");
        }
    }


    public void setColorAttack(){ this.setStyle("  -fx-padding: 1 5 5 5;\n" +
            "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
            "    -fx-background-radius: 10;\n" +
            "    -fx-background-color: \n" +
            "        linear-gradient(from 0% 93% to 0% 100%, #a30d1b 0%, #90252b 100%),\n" +
            "        #9d1800,\n" +
            "        #d84028,\n" +
            "        radial-gradient(center 50% 50%, radius 100%, #d81918, #810411);\n" +
            "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
            "    -fx-font-weight: bold;\n" +
            "    -fx-font-size: 1.1em;");
    }

    public void select(){
        this.setColorSelected();
        selected = true;
    }

    public void deSelect(){
        this.setColorStandard();
        selected = false;
    }

    public void selectForAttack(){
        this.setColorAttack();
        selectedForAttack = true;
    }

    public void deselectForAttack(){
        this.setColorStandard();
        selectedForAttack = false;
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
