
/**
 * Write a description of class HeadToHead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class HeadToHead
{
    // instance variables - replace the example below with your own
    private int numOfDie;
    private int AttackNumOfDie;
    private int DefendNumOfDie;

    /**
     * Constructor for objects of class HeadToHead
     */
    public HeadToHead()
    {
        // initialise instance variables
        numOfDie = 0;
        AttackNumOfDie = 0;
        DefendNumOfDie = 0;

    }

    public static void setNumOfDie(int numDie){

        Scanner scan = new Scanner(System.in);

        System.out.println("Attacker: How many die?");

        int AttackNumOfDie = scan.nextInt();

        if (AttackNumOfDie < 0 || AttackNumOfDie > 3){

            System.out.println("Please enter a number of die between 1 and 3");

            AttackNumOfDie = scan.nextInt();
        }

        System.out.println("Defender: How many die?");

        int DefendNumOfDie = scan.nextInt();

        if (DefendNumOfDie < 0 || DefendNumOfDie > 2){

            System.out.println("Please enter a number of die between 1 and 2");

            DefendNumOfDie = scan.nextInt();
        }

        scan.close();


    }
}
