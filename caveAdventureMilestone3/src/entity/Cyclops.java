package entity;

public class Cyclops extends Monster{

    public Cyclops(String name) {
        super(name);
    }

    public void sayHello() {
        System.out.println("Hello my name is " + name);
    }

    public void specialPower() {
        log.debug("I have an eye laser watch out before I blast you.");
    }

    public void doFight(){
        log.info("User score: " + userScore);
        log.info("Monster score: " + monsterScore);
        while (monsterScore > 0  || userScore > 0) {
            System.out.println("The monster's health is: " + monsterScore);
            System.out.println("Your health is: " + userScore);
            if (monsterScore < 0){
                System.out.println();
                System.out.println("Congratulations you have defeated the Cyclops! You win!");
                break;
            } else if (userScore < 0){
                System.out.println("You have been defeated.");
                break;
            }
            String item = i.nextLine();
            if (item.equalsIgnoreCase("cake")){
                userScore = userScore + 5;
                System.out.println("You gained 5 health!");
            } else if (item.equalsIgnoreCase("banana peel")){
                monsterScore = monsterScore/2;
                System.out.println("You threw the banana peel and the monster fell on it. His health has been halved.");
            } else if (item.equalsIgnoreCase("water")){
                userScore = userScore - 2;
                System.out.println("While you were drinking the monster hit you! Why would you drink water mid fight?");
            } else if (item.equalsIgnoreCase("jacket")){
                userScore = userScore + 3;
                System.out.println("The jacket has a protective lining");
            } else if (item.equalsIgnoreCase("flashlight")){
                monsterScore = monsterScore - 3;
            } else if (item.equalsIgnoreCase("fists")){
                monsterScore = monsterScore - 3;
            }
            else {
                System.out.println("Not an option. You get attacked.");
                userScore = userScore - 1;
            }
            System.out.println("The cyclops uses his laser eye");
            userScore = userScore - 2;
            System.out.println("The monster's health is: " + monsterScore);
            System.out.println("Your health is: " + userScore);
        }
    }
}
