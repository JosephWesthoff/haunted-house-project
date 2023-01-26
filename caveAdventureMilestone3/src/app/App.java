package app;

import entity.CREATURE;
import entity.Monster;
import util.MonsterFactory;

import java.util.Scanner;

/**
 * Introduces user to the game with a welcome greeting
 * Has the run
 * Ability to make a choice by typing 1 to start
 * Tells the user to select their direction
 */

public class App {
    public static void main(String[] args) {
        Scanner u = new Scanner(System.in);
        System.out.println("Welcome to Haunted House Adventure! Try to get 50 points Please enter your name: ");
        String userName = u.nextLine();
        User player = new User(userName);
        Monster monster = null;
        System.out.println("Hello " + player.getName() + " enter '1' to start your adventure:");
        String gameStart = u.nextLine();

        if (gameStart.equals("1")) {
            Scanner d = new Scanner(System.in);
            player.greet();
            Help Directions = new Help();
            while (player.getPoints() < 50) {
                System.out.println();
                //you are now located in the...
                System.out.println("Please select another direction. ");
                System.out.println("If you would like help, type 'help' ");
                //your options are- north/south/east/west
                player.showOptions();
                String directionChoice = d.nextLine();
                if (directionChoice.equals("help")) {
                    Directions.printMap();
                    player.printItems();
                } else  {
                    player.move(directionChoice);
                }
                player.getPosition();
            }
            System.out.println("You black out. When you open your eyes you find yourself in an eerie room. Around you are 3 doors, one wooden, one stone, and one metal. Which door would you like to enter?");
            player.showOptions2();
            String directionChoice = d.nextLine();
            if (directionChoice.equalsIgnoreCase("help")){
                Directions.printMap2();
            }
            else player.move(directionChoice);
            player.getPosition();
            if (directionChoice.equalsIgnoreCase("Wooden")){
                System.out.println("You walk through the wooden door and in front of you appears a Minatour.");
                monster = MonsterFactory.create(CREATURE.MINATOUR, "Frank");
            }
            else if (directionChoice.equalsIgnoreCase("Metal")){
                System.out.println("You walk through the metal door and in front of you appears a Cyclops.");
                monster = MonsterFactory.create(CREATURE.CYCLOPS, "Brock");
            }
            else if (directionChoice.equalsIgnoreCase("Stone")){
                System.out.println("You walk through the stone door and in front of you appears a Troll.");
                monster = MonsterFactory.create(CREATURE.TROLL, "Allan");
            }
            else {
                System.out.println("No monsters here.");
            }
            try {
                doMonsterMayhem(monster);
            }catch (Exception e) {
                System.out.println("Monster problem..." + e.getMessage());
            }
        }
    }

    public static void doMonsterMayhem(Monster monster) throws Exception {
        if (monster == null) {
            throw new Exception("no monsters");
        }
        monster.sayHello();
        monster.specialPower();
        System.out.println("Use inventory items in your fight. Or answer the riddle.");
        User.printItems();
        monster.fight();

    }
}