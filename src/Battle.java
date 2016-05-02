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

    public void engage() {
        int attackerCasualties = 0, defenderCasualties = 0;
        int[] attackerResults = attacker.rollDice(attackerDice),
                defenderResults = defender.rollDice(defenderDice);

        for (int i = 1; i <= defenderDice; i++) {
            if(attackerDice - i < 0 || defenderDice - i < 0)
                break;
            int attackerDieValue = attackerResults[attackerDice - i];
            int defenderDieValue = defenderResults[defenderDice - i];

            if (attackerDieValue == 0 || defenderDieValue == 0)
                continue;
            if (attackerDieValue <= defenderDieValue) {
                attackerCasualties++;
                System.out.println("Defender wins pair.");
                System.out.println("Winning die: " + defenderDieValue);
            } else if (attackerDieValue > defenderDieValue) {
                System.out.println("Attacker wins pair.");
                System.out.println("Winning die: " + attackerDieValue);
                defenderCasualties++;
            }
        }

        attacker.getCurrentTerritory().updateTroopCount(attackerCasualties * -1);
        defender.getCurrentTerritory().updateTroopCount(defenderCasualties * -1);

        attacker.resetPlayerDice();
        defender.resetPlayerDice();
    }
}