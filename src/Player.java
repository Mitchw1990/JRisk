import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mitch on 4/27/2016.
 */
public class Player {

    private ArrayList<Territory> conqueredTerritories;
    private ArrayList<Continent> conqueredContinents;
    private String name, playerColor;
    private ArrayList<Die> playerDies;
    private Territory currentTerritory;
    private Territory currentTerritoryToAttack;

    public Player(String name){
        currentTerritory = null;
        currentTerritoryToAttack = null;
        this.name = name;
        conqueredContinents = new ArrayList<Continent>();
        conqueredTerritories = new ArrayList<Territory>();
        playerDies = new ArrayList<Die>();
        playerDies.add(new Die());
        playerDies.add(new Die());
        playerDies.add(new Die());
    }

    //Added attribute  String color and a function to Territory that allows you to change button color owned by Territory

    public int[]  rollDice(int numberOfDice){

        int[] results = new int[numberOfDice];

        if(numberOfDice > 0 && numberOfDice <= 3){
            for (int i = 0; i < numberOfDice; i++){
                playerDies.get(i).roll();
                results[i] = playerDies.get(i).getFaceValue();
            }
        }else
            System.out.println("Invalid number of dice.  Must be integer between 1 and 3");
        Arrays.sort(results);
        return results;
    }

    public void addTerritory(Territory territory){
        conqueredTerritories.add(territory);
    }
    public void addContinent(Continent continent){
        conqueredContinents.add(continent);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Die> getPlayerDies() {
        return playerDies;
    }

    public Territory getCurrentTerritory() {
        return currentTerritory;
    }

    public void setCurrentTerritory(Territory currentTerritory) {
        this.currentTerritory = currentTerritory;
    }

    public Territory getCurrentTerritoryToAttack() {
        return currentTerritoryToAttack;
    }

    public void setCurrentTerritoryToAttack(Territory currentTerritoryToAttack) {
        this.currentTerritoryToAttack = currentTerritoryToAttack;
    }

    public void resetCurrentTerritoryToAttack(){
        currentTerritoryToAttack = null;
    }

    public void resetPlayerDice(){
        for(Die die : playerDies){
            die.setFaceValue(0);
        }
    }

    public void resetCurrentTerritory(){
        currentTerritory = null;
    }

    public void updateTroopLevel(Territory territory, int troops){
        int index = conqueredTerritories.indexOf(territory);
        conqueredTerritories.get(index).updateTroopCount(troops);
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String color) {
        this.playerColor = color;
    }

    public ArrayList<Territory> getConqueredTerritories() {
        return conqueredTerritories;
    }

    public ArrayList<Continent> getConqueredContinents() {
        return conqueredContinents;
    }

    public boolean ownsTerritory(Territory territory){
        return conqueredTerritories.contains(territory);
    }

    public boolean ownsContinent(Continent continent){
        return conqueredContinents.contains(continent);
    }

    public int getNumberOfTerritories(){
        return conqueredTerritories.size();
    }

    public int getNumberOfArmiesToRecieve(){
        int armies = getNumberOfTerritories()/ 3;
        if(armies < 3){
            armies = 3;
        }

        for(Continent continent : conqueredContinents){
            armies += continent.getBonus();
        }
        return armies;
    }

}

