package entity;

import app.ScorableItems;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.Scanner;


public class Monster implements iMonster {

    static Logger log = LogManager.getLogger(Monster.class);
    protected String name;
    ScorableItems scorableItems = new ScorableItems();
    Scanner i = new Scanner(System.in);
    Random rn = new Random();
    int monsterScore = rn.nextInt(10) + 1;
    int userScore = rn.nextInt(10) + 1;


    public Monster(String name) {
        this.name = name;
    }

    public void fight() {
        doFight();
    }

    public void sayHello() {
        log.debug("I am a monster, my name is: " + name);
    }

    public void specialPower() {
        log.debug("I can do vanilla monster stuff.");
    }

    /**
     *
     * common battle dynamic across monsters - can be shared..
     */
    public void doFight(){
        log.info("User score: " + userScore);
        log.info("Monster score: " + monsterScore);

        while (monsterScore > 0 || userScore > 0){
            if(userScore < 0) {
                log.info("Monster Wins!");
                break;
            }
            else if (monsterScore < 0){
                log.info("User Wins!");
                break;
            }
            scorableItems.displayCurrentItems();
        }
    }
}