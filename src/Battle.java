import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Mitch on 4/29/2016.
 */
public class Battle {

    Player attacker, defender;
    int defenderDice, attackerDice;

    public Battle(Player attacker, int attackerDice,
                  Player defender, int defenderDice){
        this.attacker = attacker;
        this.defender = defender;
        this.attackerDice = attackerDice;
        this.defenderDice = defenderDice;
    }

    public void engage(){
        int[] attackerResults = attacker.rollDice(attackerDice);
        int[] defenderResults = defender.rollDice(defenderDice);

        Arrays.sort(attackerResults);
        Arrays.sort(defenderResults);


        attacker.resetPlayerDice();
        defender.resetPlayerDice();
    }




}
