import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Mitch on 4/29/2016.
 */
public class Battle {

    private Player attacker, defender;
    private int defenderDice, attackerDice;
    private Territory attackerTerritory, defenderTerritory;

    public Battle(Player attacker, int attackerDice, Territory attackerTerritory,
                  Player defender, int defenderDice, Territory defenderTerritory) {
        this.attacker = attacker;
        this.defender = defender;
        this.attackerDice = attackerDice;
        this.defenderDice = defenderDice;
        this.attackerTerritory = attackerTerritory;
        this.defenderTerritory = defenderTerritory;

        attacker.setCurrentTerritory(attackerTerritory);
        defender.setCurrentTerritory(defenderTerritory);
    }

    public ArrayList engage() {
        Player winner = null, loser = null;
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
                loser = attacker;
                casualties = attackerDice;
            } else if (attackerDieValue > defenderDieValue) {
                winner = attacker;
                loser = defender;
                casualties = defenderDice;
            }
        }

        result.add(winner);
        result.add(casualties);

        attacker.resetPlayerDice();
        defender.resetPlayerDice();

        loser.getCurrentTerritory().updateTroopCount(casualties * -1);//update troop count at territory

        return result; //returns an arraylist with the winning player and casualties for the loser}
    }
}