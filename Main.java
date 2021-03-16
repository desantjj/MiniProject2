/*
Mini Project 2
Group #2: Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
Date: 3/16/21
*/

/**
 * This class is a model for running an Easter egg hunt
 * @author Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
 * @version 3/9/21
*/

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
      System.out.println("How many players are in this Easter egg hunt? Enter a positive whole number:");
      int number = s.nextInt();
      //Extra credit: logic to only accept positive whole numbers and throw an error if the number is negative
      while (number <= 0) {
        System.out.println("Sorry, we cannot accept a negative number for the amount of players. Please enter a positive number.");
        System.out.println("Please enter a positive whole number: ");
        number = s.nextInt();
      }

      //Forming an ArrayList of the number of players inputted by the user
      ArrayList<Player> players = new ArrayList<Player>();

      for(int num = 0; num<number; num++) {
        players.add(new Player());
      }

      System.out.println("We have added " + number + " players to this hunt. Let's find some eggs!");

      //Call of hunt method
      hunt(players);

      //Call of recap method
      recap(players);
      
      //Call of stats method
      stats(players);

  }

  /**
   * This method is where the Easter egg hunt actually takes place
   * @param Passing my players ArrayList to this method
  */
  public static void hunt(ArrayList<Player> allPlayers) {
    Random r = new Random();
    int numberOfEggsFound;

    for(int num = 0; num<allPlayers.size(); num++) {
      numberOfEggsFound = r.nextInt(11);
      for(int number = 0; number<numberOfEggsFound; number++) {
        allPlayers.get(num).foundEgg(new Egg());
      }
    }
  }

  /**
   * This method is where you can see each individual players basket and the colors and contents of the eggs they found
   * @param Passing my players ArrayList to this method
  */
  public static void recap(ArrayList<Player> allPlayers) {
    for (int num = 0; num<allPlayers.size(); num++) {
      System.out.println();
      System.out.println("Player " + num + " found " + allPlayers.get(num).getNumberOfEggs() + " eggs");
      allPlayers.get(num).printBasket();
    }
  }

  /**
   * This method is where you can see the stats of the player with the most eggs found, total eggs found by color, and total eggs found by content
   * @param Passing my players ArrayList to this method
  */
  public static void stats(ArrayList<Player> allPlayers) {
    int playerWithMostEggsFound = 0;
    int playerTotalNumOfEggsFound = 0;

    for(int num = 0; num<allPlayers.size(); num++) {
      if(allPlayers.get(num).getNumberOfEggs() > playerTotalNumOfEggsFound) {
        playerTotalNumOfEggsFound = allPlayers.get(num).getNumberOfEggs();
        playerWithMostEggsFound = num;
      }
    }
    System.out.println();
    System.out.println("Player " + playerWithMostEggsFound + " found the most eggs, with " + playerTotalNumOfEggsFound + " eggs!");
  
  //Logic to count the number of colored eggs found.
  int[] colors = new int[4];
    for(int num = 0; num<allPlayers.size(); num++) {
      for(int number = 0; number<allPlayers.get(num).getNumberOfEggs(); number++) {
        if(allPlayers.get(num).getBasket().get(number).getColors().equals("Pink"))
          colors[0]++;
        if(allPlayers.get(num).getBasket().get(number).getColors().equals("Blue"))
          colors[1]++;
        if(allPlayers.get(num).getBasket().get(number).getColors().equals("Yellow"))
          colors[2]++;
        if(allPlayers.get(num).getBasket().get(number).getColors().equals("Green"))
          colors[3]++;
      }
    }

    //Additional functionality in finding the sum of all eggs found
    int sum = 0;
    for(int num : colors)
    sum += num;
    
    System.out.println();
    System.out.println("Total Eggs Found by Color");
    System.out.println("Pink eggs: " + colors[0]);
    System.out.println("Blue eggs: " + colors[1]);
    System.out.println("Yellow eggs: " + colors[2]);
    System.out.println("Green eggs: " + colors[3]);
    //Print statement for total sum of eggs found
    System.out.println("There were a total of " + sum + " eggs found!");
  
  //Extra credit for breaking down the stats for the content of the eggs
  int[] contents = new int[7];
    for(int num = 0; num<allPlayers.size(); num++) {
      for(int number = 0; number<allPlayers.get(num).getNumberOfEggs(); number++) {
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("cadbury egg"))
          contents[0]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("reese's egg"))
          contents[1]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("pink starburst"))
          contents[2]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("yellow peep"))
          contents[3]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("25 cents"))
          contents[4]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("50 cents"))
          contents[5]++;
        if(allPlayers.get(num).getBasket().get(number).getContents().equals("one dollar"))
          contents[6]++;
      }
    }

    System.out.println();
    System.out.println("Total Eggs Found by Content");
    System.out.println("Cadbury egg: " + contents[0]);
    System.out.println("Reese's egg: " + contents[1]);
    System.out.println("Pink starburst: " + contents[2]);
    System.out.println("Yellow peep: " + contents[3]);
    System.out.println("25 cents: " + contents[4]);
    System.out.println("50 cents: " + contents[5]);
    System.out.println("One dollar: " + contents[6]);
  }
}