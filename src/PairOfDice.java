
/**
 *
 * 
 * PairOfDice is composed of two Die objects.
 * Methods to get the individual die values, 
 * a method to roll the dice, and a method that 
 * returns the current die sum values included.
 * 
 * @author George Young
 * @version 04/28/2015
 */

public class PairOfDice 
{
        //instance variables
        private final Die die1;
        private final Die die2;
        
        private int valueOfDie1, valueOfDie2, sumOfDice;

   public PairOfDice()
    /**
     * Initialization of two die objects
     */
    
    {
       die1 = new Die();
       die2 = new Die();
    }
    
   /**
    * method to roll two die objects
    */
   
   public void rollDice()
   {
       valueOfDie1 = die1.roll();
       valueOfDie2 = die2.roll();
   }
   
   /**
    * method to get the value of die1
    * returns face value of die1
    */
   public int getValueDie1(int number)
   {
      valueOfDie1 = die1.getFaceValue();
       
      return valueOfDie1;
   }
   /**
    * method to get the value of die2
    * returns face value of die2
    */

   public int getValueDie2(int number)
   {
      valueOfDie2 = die2.getFaceValue();
       
      return valueOfDie2;
   }
   
   /**
    * method to calculate the sum of two die objects 
    */
   
   public int getSumOfDice()
   {
      sumOfDice = (die1.roll() + die2.roll());
       
      return sumOfDice;
 
   }  
  /**
   * method returns sum of two die objects as string
   */
  
   public String toString()
   {
      String result = Integer.toString(sumOfDice);
       
      return result;
  
   }    
}