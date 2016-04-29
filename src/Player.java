import java.util.ArrayList;

/**
 * Created by Mitch on 4/27/2016.
 */
public class Player {

    private ArrayList<Territory> conqueredTerritories;
    private ArrayList<Continent> conqueredContinents;
    private String name;



    private ArrayList<Die> playerDies;

    public Player(String name){
        this.name = name;
        conqueredContinents = new ArrayList<Continent>();
        conqueredTerritories = new ArrayList<Territory>();
        playerDies = new ArrayList<Die>();
        playerDies.add(new Die());
        playerDies.add(new Die());
        playerDies.add(new Die());
    }

    public int[]  rollDice(int numberOfDice){

        int[] results = new int[numberOfDice];

        if(numberOfDice > 0 && numberOfDice <= 3){
            for (int i = 0; i < numberOfDice; i++){
                playerDies.get(i).roll();
                results[i] = playerDies.get(i).getFaceValue();
            }
        }else
            System.out.println("Invalid number of dice.  Must be integer between 1 and 3");
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

    public void resetPlayerDice(){
        for(Die die : playerDies){
            die.setFaceValue(0);
        }
    }
}
