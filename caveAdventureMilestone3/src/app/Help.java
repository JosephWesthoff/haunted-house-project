package app;

/**
 * Helping the user with the correct directions
 * Has room to add more for help options in later milestones
 */

public class Help {

    private ScorableItems scorableItems2;

    public Help() {
        scorableItems2 = new ScorableItems();
    }

    public void printMap(){
        System.out.println("# # # # # # # # # # # # # # # # # # # # #\n");
        System.out.println ("\t          | Attic \n      ");
        System.out.println ("Bedroom ---- Kitchen \n      ");
        System.out.println ("\t          | Basement \n      ");
        System.out.println("# # # # # # # # # # # # # # # # # # # # #\n");
    }

    public void printMap2(){
        System.out.println("# # # # # # # # # # # # # # # # # # # # #\n");
        System.out.println("\t |Wood Door|\n");
        System.out.println("Metal Door --- You --- Stone Door\n");
        System.out.println("# # # # # # # # # # # # # # # # # # # # #\n");
    }
}