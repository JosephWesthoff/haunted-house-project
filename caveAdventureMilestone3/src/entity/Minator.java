package entity;

import java.util.Scanner;

public class Minator extends Monster{

    public Minator(String name) {
        super(name);
    }

    public void specialPower() {
        System.out.println("Hello puny one, my name is " + name + " step up and face my challenge. Not of braun but of wits.");
        System.out.println("I have cities but no buildings. I have forests but no trees. I have mountains but no peaks. What am I?");
    }

    public void doFight(){
        Scanner a = new Scanner(System.in);

        while (monsterScore > 0  || userScore > 0){
            String answer = a.nextLine();
            if (answer.equalsIgnoreCase("Map")) {
                System.out.println("You've outsmarted me! How is this possible!");
                monsterScore = -10;
                break;
            }
            else if (answer.equalsIgnoreCase("A Map")) {
                System.out.println("You've outsmarted me! How is this possible!");
                monsterScore = -10;
                break;
            }
            else {
                System.out.println("Wrong answer you fool!");
                userScore -= 1;
                System.out.println("Your current health is " + userScore);
            }
            if (monsterScore < 0){
                break;
            }
            else if (userScore < 0){
                System.out.println("You lose, better luck next time.");
            }
        }
    }
}
