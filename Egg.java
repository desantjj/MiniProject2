/*
Mini Project 2
Group #2: Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
Date: 3/16/21
*/

/**
 * This class determines the eggs color and contents
 * @author Joey DeSantis, Sam Dobrowolski, Christopher Sonnhalter
 * @version 3/9/21
*/

import java.util.Random;

class Egg {
  private String color;
  private String contents;

  //Assigns a random color and contents to the egg
  Egg() {
    color = randomColor();
    contents = randomContents();
  }

  /**
   * This method sets up an array and generates random egg colors
   * @return Random egg color
  */
  public String randomColor() {
    Random r = new Random();
    String[] colors = {"Blue", "Pink", "Yellow", "Green"};
    //0-3 indices related to colors in above array
    int color = r.nextInt(4);
    return colors[color];
  }

  /**
   * This method sets up an array and generates random egg contents
   * @return Random egg contents
  */
  public String randomContents() {
    Random r = new Random();
    String[] content = {"cadbury egg","reese's egg","pink starburst","yellow peep", "25 cents", "50 cents", "one dollar"};
    //0-6 indices related to contents in above array
    int contents = r.nextInt(7);
    return content[contents];
  }

  //Prints out random color and contents for the egg
  public void printEgg() {
    System.out.println(color + " egg contains " + contents);
  }

  /**
   * This method accesses the egg color
   * @return Egg color
  */
  public String getColors() {
    return color;
  }

  /**
   * This method accesses the egg contents
   * @return Egg contents
  */
  public String getContents() {
    return contents;
  }
}