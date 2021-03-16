/*
Mini Project 2
Group #2: Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
Date: 3/16/21
*/

/**
 * This class tracks the number of eggs and the egg basket
 * @author Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
 * @version 3/9/21
*/

import java.util.ArrayList;

class Player {
  private int eggs;
  private ArrayList<Egg> basket;

  //Creation of default constructor 
  Player() {
    eggs = 0;
    basket = new ArrayList<Egg>();
  }
  
  /**
   * This method adds an egg to the basket when the egg is found
   * @param Passing an object into the basket
  */
  public void foundEgg(Egg foundAnEgg) {
    eggs++;
    basket.add(foundAnEgg);
  }

  //Prints out each found egg with its color and contents
  public void printBasket() {
    for(int num = 0; num<basket.size(); num++) {
      basket.get(num).printEgg();
    }
  }

  /**
   * This method accesses the number of eggs
   * @return Number of eggs
  */
  public int getNumberOfEggs() {
    return eggs;
  }

  /**
   * This method accesses the egg basket
   * @return Egg basket
  */
  public ArrayList<Egg> getBasket() {
    return basket;
  }
}