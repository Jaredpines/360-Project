package Controller;

import Model.*;

import java.io.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static Model.Dungeon.*;
import static Controller.DungeonAdventure.Play;
import static Model.Hero.*;
import static Model.MovePlayer.move;
import static View.DriverView.*;

public class Driver implements Serializable {

    private static Dungeon myMainDungeon;
    private static boolean myVPUsed;
    public static StringBuilder heroToScreen(String theName) throws SQLException {
        StringBuilder myStats = new StringBuilder();
        if(theName.equalsIgnoreCase("Warrior")) {
            Warrior myWarrior = new Warrior(theName);
            myStats = Stats(myWarrior.getMyHitPoint(), myWarrior.getMyAttackSpeed(), myWarrior.getMyChanceToHit(), myWarrior.getMINIMUM_DAMAGE(), myWarrior.getMyMaximumDamage(), myWarrior.getMyChangesToBlockOrHeal(), myWarrior);
        }else if(theName.equalsIgnoreCase("Priestess")){
            Priestess myPriestess = new Priestess(theName);
            myStats = Stats(myPriestess.getMyHitPoint(), myPriestess.getMyAttackSpeed(), myPriestess.getMyChanceToHit(), myPriestess.getMINIMUM_DAMAGE(), myPriestess.getMyMaximumDamage(), myPriestess.getMyChangesToBlockOrHeal(), myPriestess);
        }else if(theName.equalsIgnoreCase("Thief")){
            Thief myThief = new Thief(theName);
            myStats = Stats(myThief.getMyHitPoint(), myThief.getMyAttackSpeed(), myThief.getMyChanceToHit(), myThief.getMINIMUM_DAMAGE(), myThief.getMyMaximumDamage(), myThief.getMyChangesToBlockOrHeal(), myThief);
        }

        return myStats;
    }

    private static StringBuilder Stats(int hit_points, int attack_speed, double chance_to_hit, int minimum_damage, int maximum_damage, double chance_to_block_or_heal, Hero myHero) {
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(hit_points).append("\n");
        stats.append("attack speed: ").append(attack_speed).append("\n");
        stats.append("chance to hit: ").append(chance_to_hit).append("\n");
        stats.append("minimum damage: ").append(minimum_damage).append("\n");
        stats.append("maximum damage: ").append(maximum_damage).append("\n");
        stats.append("chance to block: ").append(chance_to_block_or_heal).append("\n");
        return stats;
    }

    public static StringBuilder dungeonToScreen(final int theX, final int theY){
        StringBuilder mySB = new StringBuilder();
        //make Dungeon 3D array
        int myCoordinates = 0;

        if(myMainDungeon == null){
            myMainDungeon = new Dungeon(theX,theY);
        }
        String[] mySplit = myMainDungeon.toString().split(" ");
        for (int i = 0; i < mySplit.length; i++) {
            switch (mySplit[i]) {
                case "entrance" -> mySB.append("i");
                case "exit" -> mySB.append("O");
                case "A" -> mySB.append("A");
                case "E" -> mySB.append("E");
                case "I" -> mySB.append("I");
                case "P" -> mySB.append("P");
                case "Pit" -> mySB.append("X");
                case "HP" -> mySB.append("H");
                case "VP" -> mySB.append("V");
                case "empty" -> mySB.append(" ");
            }
            String[] mySplitLoop = mySplit[i].split("-");
            if(mySplitLoop.length > 1){
                mySB.append("M");
            }
        }
        return mySB;
    }
    public static void Intro () throws Exception {
        System.out.println("Welcome to the game!");
        System.out.println("This is dungeon adventure game!");
        System.out.println("Press 1) Start the game");
        System.out.println("Press 2) Read the instruction of the game");
        System.out.println("Press 3) To exit the game");

        Scanner sc = new Scanner(System.in);
        String myChoice = sc.next();

        switch (myChoice) {

            case "1":

                String art = """ 
          d8888b. db    db d8b   db  d888b  d88888b  .d88b.  d8b   db
          88  `8D 88    88 888o  88 88' Y8b 88'     .8P  Y8. 888o  88
          88   88 88    88 88V8o 88 88      88ooooo 88    88 88V8o 88
          88   88 88    88 88 V8o88 88  ooo 88~~~~~ 88    88 88 V8o88
          88  .8D 88b  d88 88  V888 88. ~8~ 88.     `8b  d8' 88  V888
          Y8888D' ~Y8888P' VP   V8P  Y888P  Y88888P  `Y88P'  VP   V8P
                                                                      
                                                                      
   .d8b.  d8888b. db    db d88888b d8b   db d888888b db    db d8888b. d88888b
  d8' `8b 88  `8D 88    88 88'     888o  88 `~~88~~' 88    88 88  `8D 88'
  88ooo88 88   88 Y8    8P 88ooooo 88V8o 88    88    88    88 88oobY' 88ooooo
  88~~~88 88   88 `8b  d8' 88~~~~~ 88 V8o88    88    88    88 88`8b   88~~~~~
  88   88 88  .8D  `8bd8'  88.     88  V888    88    88b  d88 88 `88. 88.
  YP   YP Y8888D'    YP    Y88888P VP   V8P    YP    ~Y8888P' 88   YD Y88888P
                                                                              
                                                                              
                       .d888b.  .d88b.  .d888b. .d888b.
                       VP  `8D .8P  88. VP  `8D VP  `8D
                          odD' 88  d'88    odD'    odD'
                        .88'   88 d' 88  .88'    .88'
                       j88.    `88  d8' j88.    j88.
                       888888D  `Y88P'  888888D 888888D
                                                        
                        """;

                for (int i = 0; i < art.length(); i++){
                    System.out.print(art.charAt(i));
                    Thread.sleep(1);
                }


                System.out.println("Thanks for choosing to play our game");
                System.out.println("You can always save the game if you need to run and do some errands");


                System.out.println(chooseHero());
                Play();
                System.out.println("Please enter the size of your dungeon in X Y format.");
                int myX = sc.nextInt();
                int myY = sc.nextInt();
                System.out.println(potionsToScreen(getMyHPTotal(), getMyVPTotal()));
                System.out.println(roomMap(myX,myY));
                while (!myChoice.equalsIgnoreCase("Stop")) {
                    System.out.println("Type Left, Right, Up, or Down to move.");
                    if(getMyHPTotal()>0 || getMyVPTotal()>0){
                        System.out.println("Type HP or VP to use potions");
                    }
                    myChoice = sc.next();
                    if(myChoice.equalsIgnoreCase("m")){
                        System.out.println(mapMaker(myX,myY));
                    }else if(myChoice.equalsIgnoreCase("HP") && getMyHPTotal()>0) {
                        setMyHPTotal(getMyHPTotal()-1);
                        Random myRand = new Random();
                        int myRandHP = myRand.nextInt(11) + 5;
                        setMyHitPoint(getMyHitPoint() + myRandHP);
                    }else if(myChoice.equalsIgnoreCase("VP") && getMyVPTotal()>0){
                        setMyVPTotal(getMyVPTotal()-1);
                        myVPUsed = true;
                    }
                    move(myChoice);
                    System.out.println(roomMap(myX,myY));
                    if(!getMyMaze()[getMyPlayerX()][getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance") && !getMyMaze()[getMyPlayerX()][getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                        getMyMaze()[getMyPlayerX()][getMyPlayerY()][0].setStatus("empty");
                    }
                    System.out.println(potionsToScreen(getMyHPTotal(), getMyVPTotal()));
                }
                //HOPEFULLY WHAT WE NEED TO MAKE SERIALIZATION WORK
                FileOutputStream myFileOut = new FileOutputStream("UserInfo.ser");
                ObjectOutputStream myOut = new ObjectOutputStream(myFileOut);
                //This 5 and 5 are just random, still need to figure out what to pass there
                myOut.writeObject(dungeonToScreen(5,5));
                myOut.close();
                myFileOut.close();

                System.out.println("The game info saved");


                //This is deserialization
                Dungeon myDungeon1 = null;

                // Reading the object from a file
                FileInputStream myFileIn = new FileInputStream("UserInfo.ser");
                ObjectInputStream myIn = new ObjectInputStream(myFileIn);

                //TODO Serialization works but Deserialization shows an error
                // (Will ask prof on code review what is wrong)
                /*
                // Method for deserialization of object
                myDungeon1 = (Dungeon) myIn.readObject();

                myIn.close();
                myFileIn.close();

                System.out.println("Object has been deserialized ");
                System.out.println("a = " + myDungeon1.getX());
                System.out.println("b = " + myDungeon1.getY());




                 */


            case "2":
                System.out.println("Game is under construction \n" +
                        "Instructions will be added soon!");
                break;
            case "3":
                System.out.println("It was nice having you here!");
        }
    }
    public static void battleToScreen(Monster theMonster, Hero theHero){

    }
    public static boolean getMyVPUsed(){
        return myVPUsed;
    }
    public static void setMyVPUsed(){
        myVPUsed = false;
    }
}
