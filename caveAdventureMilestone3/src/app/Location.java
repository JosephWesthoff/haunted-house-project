package app;

/**
 * Has all the handle moves
 * Has all the moves and directions
 * Possibility to add more
 * Tells user which way not to go
 */

public class Location {
    private final String EAST = "East";
    private final String WEST = "West";
    private final String NORTH = "North";
    private final String SOUTH = "South";
    private String currentLocation;

    //spawn = "Bedroom" via User class
    public Location(String spawn) {
        currentLocation = spawn;
    }


    public String getCurrent() {
        return currentLocation;
    }

    //four locations: bedroom, attic, kitchen, basement
    public void move(String direction) {
        if (currentLocation.equalsIgnoreCase("Bedroom"))
            handleBedroomMove(direction);
        else if (currentLocation.equalsIgnoreCase("Kitchen"))
            handleKitchenMove(direction);
        else if (currentLocation.equalsIgnoreCase("Basement"))
            handleBasementMove(direction);
        else if (currentLocation.equalsIgnoreCase("Attic")) {
            handleAtticMove(direction);
        }
        else if (currentLocation.equalsIgnoreCase("Wooden Door")){

        }
        else if (currentLocation.equalsIgnoreCase("Stone Door")){

        }
        else if (currentLocation.equalsIgnoreCase("Metal Door")){

        }
        else
            System.out.println("Try again");
    }

    //if east from Bedroom..  Kitchen
    //if west from Bedroom..  nothing
    //if south from Kitchen..  Basement

    //state ( location ) has been updated
    public void handleBedroomMove(String direction) {
        Help Directions = new Help();
        if (direction.equalsIgnoreCase(EAST)) {
            System.out.println("........................");
            currentLocation = "Kitchen";
        }else if (direction.equalsIgnoreCase(SOUTH)) {
            System.out.println(".......................");
        }else if (direction.equalsIgnoreCase("Help")) {
            Directions.printMap();
        }else
            System.out.println("Not an option...Try Again ");
        System.out.println();
    }

    public void handleKitchenMove(String direction) {
        Help Directions= new Help();
        if (direction.equalsIgnoreCase(SOUTH)) {
            System.out.println("..................");
            currentLocation = "Basement";
        }else if (direction.equalsIgnoreCase(EAST)) {
            System.out.println(".................");
        }else if (direction.equalsIgnoreCase(NORTH)) {
            currentLocation = "Attic";
        }else if (direction.equalsIgnoreCase(WEST)) {
            currentLocation = "Bedroom";
        }else if(direction.equalsIgnoreCase("Help")) {
            Directions.printMap();
        }else
            System.out.println("Not an option...Try Again ");
        System.out.println();
    }

    public void handleBasementMove(String direction) {
        Help Directions= new Help();
        if (direction.equalsIgnoreCase(NORTH))
            currentLocation = "Kitchen";
        else if (direction.equalsIgnoreCase(SOUTH))
            System.out.println("...................");
        else if (direction.equalsIgnoreCase("Help")) {
            Directions.printMap();
        }else
            System.out.println("Not an option...Try Again ");
        System.out.println();
    }

    public void handleAtticMove(String direction) {
        Help Directions= new Help();
        if (direction.equalsIgnoreCase(SOUTH))
            currentLocation = "Kitchen";
        else if(direction.equalsIgnoreCase(NORTH))
            System.out.println("........................");
        else if (direction.equalsIgnoreCase("help")){
            Directions.printMap();
        }else
            System.out.println("Not an option...Try Again ");
        System.out.println();
    }
}