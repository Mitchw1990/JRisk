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
                  Player defender, int defenderDice) {
        this.attacker = attacker;
        this.defender = defender;
        this.attackerDice = attackerDice;
        this.defenderDice = defenderDice;
    }

    public ArrayList engage() {
        Player winner = null;
        int casualties = 0;
        ArrayList result = new ArrayList();

        int[] attackerResults = attacker.rollDice(attackerDice),
                defenderResults = defender.rollDice(defenderDice);

        for (int i = 1; i <= attackerDice; i++) {
            int attackerDieValue = attackerResults[attackerDice - i];
            int defenderDieValue = defenderResults[defenderDice - i];

            if (attackerDieValue == 0 || defenderDieValue == 0)
                continue;
            if (attackerDieValue <= defenderDieValue) {
                winner = defender;
                casualties = attackerDice;
            } else if (attackerDieValue > defenderDieValue) {
                winner = attacker;
                casualties = defenderDice;
            }
        }

        result.add(winner);
        result.add(casualties);

        attacker.resetPlayerDice();
        defender.resetPlayerDice();

        return result; //returns an arraylist with the winning player and casualties for the loser}
    }
}