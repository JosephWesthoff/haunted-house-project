package app;

import java.util.*;

/**
 * User related information
 * Creating the name of the character
 * Gives the users all its options like where to move
 * Has spawn area
 */

public class User {
    private String name;
    private final String spawn = "Bedroom";
    protected Location location;

    private ScorableItems scorableItems;
    private static List<String> currentItems;
    private int points;

    //constructor
    public User(String name) {
        this.name = name;
        location = new Location(spawn);
        scorableItems = new ScorableItems();
        currentItems = new ArrayList<>();
        points = 0;
    }

    //returns users name
    public String getName() {
        return name;
    }

    //opening dialogue at beginning of game
    public void greet() {
        System.out.print("You awake in your bedroom but something seems off. You hear strange noises coming from somewhere outside your room. You jump out of bed to go investigate...");
        scorableItems.init();
    }

    public static void printItems(){
        System.out.println("Here are all of your item options: ");
        for (String str: currentItems){
            System.out.println(str);
        }
    }

    //tells user where they are moving
    public void move(String direction) {
        System.out.println(name + " moved to the " + direction);
        location.move(direction);
        checkForScoreableItemsOpp(direction);
        System.out.println("_____________");
    }

    private void checkForScoreableItemsOpp(String direction) {
        checkPointsOppAttic(direction);
        checkForKitchenItemsOpp(direction);
        checkPointsOppBedroom(direction);
        checkPointsOppBasement(direction);
    }

    private void checkForKitchenItemsOpp(String direction) {

        if (location.getCurrent().equals("Kitchen") && direction.equalsIgnoreCase("East") && !currentItems.contains("banana peel")) {
            System.out.println("Your in the kitchen. You heard a noise behind the table. Do you want to investigate? Y/N");
            Scanner s = new Scanner(System.in);
            String response = s.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("You slipped on a banana peel:/");
                currentItems.add("banana peel");
                points += scorableItems.getItem("banana peel");
                System.out.println("You have: ");
                displayCurrentItems2();
                System.out.println("and you have " + points + " points");
            } else {
                System.out.println("Where else would you like to go?");
            }
        }
    }
    private void checkPointsOppAttic (String direction){
        if (location.getCurrent().equals("Attic") && direction.equalsIgnoreCase("North") && !currentItems.contains("cake")) {
            System.out.println("Score...  maybe!  there is a secret panel, would you like to reach inside?  Y/N ");
            Scanner s = new Scanner(System.in);
            String response = s.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Well done, you found a piece of cake - worth 20 points! ");
                currentItems.add("cake");
                points += scorableItems.getItem("cake");
                System.out.println("You have: ");
                displayCurrentItems2();
                System.out.println("and you have " + points + " points");
            } else {
                System.out.println("OK, better luck next time..");
            }
        }
    }
    private void checkPointsOppBedroom (String direction){

        if (location.getCurrent().equals("Bedroom") && direction.equalsIgnoreCase("South") && !currentItems.contains("jacket")) {
            System.out.println("You've found a trap door! would you like to find out what things hide inside? Y/N");
            Scanner s = new Scanner(System.in);
            String response = s.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("Well done, you found jacket! - worth 20 points! ");
                currentItems.add("jacket");
                points += scorableItems.getItem("jacket");
                System.out.println("You have: ");
                displayCurrentItems2();
                System.out.println("and you have " + points + " points");
            } else {
                System.out.println("OK, better luck next time...");
            }
        }
    }
    private void checkPointsOppBasement (String direction) {

        if (location.getCurrent().equals("Basement") && direction.equalsIgnoreCase("South") && (!currentItems.contains("flashlight") || !currentItems.contains("water"))) {
            System.out.println("You're now in the Basement and you found two boxes. Which one would you like to open? 1 or 2");
            Scanner s = new Scanner(System.in);
            String response = s.nextLine();
            if (response.equalsIgnoreCase("1") && !currentItems.contains("flashlight")) {
                System.out.println("Well done! You found a flashlight - worth 20 points! ");
                currentItems.add("flashlight");
                points += scorableItems.getItem("flashlight");
                System.out.println("You have: ");
                displayCurrentItems2();
                System.out.println("and you have " + points + " points");
            } else {
                if (response.equalsIgnoreCase("2") && !currentItems.contains("water")) {
                    System.out.println("Well done! You found water - worth 20 points! ");
                    currentItems.add("water");
                    points += scorableItems.getItem("water");
                    System.out.println("You have: ");
                    displayCurrentItems2();
                    System.out.println("and you have " + points + " points");
                }else{
                    System.out.println("You already have this item. Try again.");
                }
            }
        }
    }
    public int getPoints () {
        return points;
    }

    //shows user this options
    public void showOptions () {
        System.out.println("Your options are - 'North', 'South', 'East', and 'West'");
    }

    public void showOptions2(){
        System.out.println("Your options are 'Wooden', 'Stone', or 'Metal'");
    }

    //gets the users current position
    public void getPosition () {
        System.out.println("You are now located in the: " + location.getCurrent());
    }

    public void displayCurrentItems2 () {
        for (String prize : currentItems) {
            System.out.println(prize);
        }
    }
}