
/**
 *
 * ThreeDice is composed of three Die objects.
 * Methods to get the individual die values, 
 * a method to roll the dice, and a method that 
 * returns the current die sum values included.
 * 
 * @author George Young
 * @version 04/27/2016
 */

public class ThreeDice 
{
        //instance variables
        private final Die die1;
        private final Die die2;
        private final Die die3;
        
        private int valueOfDie1, valueOfDie2, valueOfDie3, sumOfDice;

   public ThreeDice()
    /**
     * Initialization of three die objects
     */
    
    {
       die1 = new Die();
       die2 = new Die();
       die3 = new Die();
    }
    
   /**
    * method to roll three die objects
    */
   
   public void rollDice()
   {
       valueOfDie1 = die1.roll();
       valueOfDie2 = die2.roll();
       valueOfDie3 = die3.roll();
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
    * method to get the value of die3
    * returns face value of die3
    */

   public int getValueDie3(int number)
   {
      valueOfDie3 = die3.getFaceValue();
       
      return valueOfDie3;
   }
   
   /**
    * method to calculate the sum of three die objects 
    */
   
   public int getSumOfDice()
   {
      sumOfDice = (die1.roll() + die2.roll() + die3.roll());
       
      return sumOfDice;
 
   }  
   
   /**
   * method returns sum of three die objects as string
   */
  
   public String toString()
   {
      String result = Integer.toString(sumOfDice);
       
      return result;
  
   }    
}//end of class