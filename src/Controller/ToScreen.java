package Controller;

import Model.*;
import View.*;

import java.io.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;


public class ToScreen implements Serializable {

    private static Dungeon myMainDungeon;
    private static boolean myVPUsed;
    private static Hero myHero;
    private static Monster myMonster;
    private static View myView;
    private Music myMusic = new Music();
    private MovePlayer myMovePlayer = new MovePlayer();
    private Art myArt = new Art();
    public StringBuilder heroToScreen(String theName) throws SQLException {
        StringBuilder myStats = new StringBuilder();
        myView = new View();
        if(theName.equalsIgnoreCase("Warrior")) {
            Warrior myWarrior = new Warrior(theName);
            setMyHero(myWarrior);
            myStats = myView.Stats(myWarrior.getMyHitPoints(), myWarrior.getMyAttackSpeed(), myWarrior.getMyChanceToHit(), myWarrior.getMINIMUM_DAMAGE(), myWarrior.getMyMaximumDamage(), myWarrior.getMyChangesToBlockOrHeal());
        }else if(theName.equalsIgnoreCase("Priestess")){
            Priestess myPriestess = new Priestess(theName);
            setMyHero(myPriestess);
            myStats = myView.Stats(myPriestess.getMyHitPoints(), myPriestess.getMyAttackSpeed(), myPriestess.getMyChanceToHit(), myPriestess.getMINIMUM_DAMAGE(), myPriestess.getMyMaximumDamage(), myPriestess.getMyChangesToBlockOrHeal());
        }else if(theName.equalsIgnoreCase("Thief")){
            Thief myThief = new Thief(theName);
            setMyHero(myThief);
            myStats = myView.Stats(myThief.getMyHitPoints(), myThief.getMyAttackSpeed(), myThief.getMyChanceToHit(), myThief.getMINIMUM_DAMAGE(), myThief.getMyMaximumDamage(), myThief.getMyChangesToBlockOrHeal());
        }

        return myStats;
    }


    public StringBuilder dungeonToScreen(final int theX, final int theY){
        StringBuilder mySB = new StringBuilder();
        //make Dungeon 3D array
        int myCoordinates = 0;

        if(myMainDungeon == null){
            this.myMainDungeon = new Dungeon(theX,theY);
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
    public String Intro () throws Exception {
        myMusic.playMusic();
        System.out.println("Welcome to the game!");
        System.out.println("This is dungeon adventure game!");
        System.out.println("Press 1) Start the game");
        System.out.println("Press 2) Read the instruction of the game");
        System.out.println("Press 3) To exit the game");

        Scanner sc = new Scanner(System.in);
        String myChoice = sc.next();

        switch (myChoice) {

            case "1":

                String myStart = myArt.StartScreenArt();

                for (int i = 0; i < myStart.length(); i++){
                    System.out.print(myStart.charAt(i));
                    Thread.sleep(1);
                }

                Thread.sleep(1000);
                try {
                    Runtime.getRuntime().exec("cls");
                }catch (IOException ignored){

                }
                try {
                    Runtime.getRuntime().exec("clear");
                }catch (IOException ignored){

                }
                System.out.println("Thanks for choosing to play our game");
                System.out.println("You can always save the game if you need to run and do some errands");

                myView = new View();
                System.out.println(myView.chooseHero());
                System.out.println("Please enter the size of your dungeon in X Y format.");
                int myX = sc.nextInt();
                int myY = sc.nextInt();
                Random myRand = new Random();
                System.out.println(myView.potionsToScreen(getMyHero().getMyHPTotal(), getMyHero().getMyVPTotal()));
                System.out.println(myView.roomMap(myX,myY));
                while (!myChoice.equalsIgnoreCase("Stop")) {
                    System.out.println("Type Left, Right, Up, or Down to move.");
                    if(getMyHero().getMyHPTotal()>0 || getMyHero().getMyVPTotal()>0){
                        System.out.println("Type HP or VP to use potions");
                    }
                    myChoice = sc.next();
                    if(myChoice.equalsIgnoreCase("m")){
                        System.out.println(myView.mapMaker(myX,myY));
                    }else if(myChoice.equalsIgnoreCase("HP") && getMyHero().getMyHPTotal()>0) {
                        getMyHero().setMyHPTotal(getMyHero().getMyHPTotal()-1);
                        int myRandHP = myRand.nextInt(11) + 5;
                        getMyHero().setMyHitPoint(getMyHero().getMyHitPoints() + myRandHP);
                        System.out.println(myView.roomMap(myX,myY));
                    }else if(myChoice.equalsIgnoreCase("VP") && getMyHero().getMyVPTotal()>0){
                        getMyHero().setMyVPTotal(getMyHero().getMyVPTotal()-1);
                        myVPUsed = true;
                        System.out.println(myView.roomMap(myX,myY));
                    }else {
                        myMovePlayer.move(myChoice);
                        System.out.println(myView.roomMap(myX,myY));
                    }

                    if(myRand.nextInt(101) >75 && !getMyMainDungeon().getMyMaze()[getMyMainDungeon().getMyPlayerX()][getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                            && !getMyMainDungeon().getMyMaze()[getMyMainDungeon().getMyPlayerX()][getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")){
                        int myWhichMonster = myRand.nextInt(3);
                        switch (myWhichMonster) {
                            case 0 -> myMonster = new Monster("Ogre");
                            case 1 -> myMonster = new Monster("Skeleton");
                            case 2 -> myMonster = new Monster("Gremlin");
                        }
                        battleToScreen(myMonster, myHero);
                    }
                    if(!myMainDungeon.getMyMaze()[myMainDungeon.getMyPlayerX()][myMainDungeon.getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                            && !myMainDungeon.getMyMaze()[myMainDungeon.getMyPlayerX()][myMainDungeon.getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                        myMainDungeon.getMyMaze()[myMainDungeon.getMyPlayerX()][myMainDungeon.getMyPlayerY()][0].setStatus("empty");
                    }
                    System.out.println(myView.potionsToScreen(getMyHero().getMyHPTotal(), getMyHero().getMyVPTotal()));
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

                System.out.println("This game is pretty simple but in case you have quetions here are the instructions");
                System.out.println("1) Pick what hero you want to pick. You can see specifications of each hero before picking it");
                System.out.println("2) Pick what size of the dungeon you want to have");
                System.out.println("3) Once you enter size of the dungeon you will see the entrance room and number of health " +
                        "potions and vision postions you have");
                System.out.println("4) Pick where do you want to go (Left, Right, Up, Down) ");
                System.out.println("5) Once you pick where to go you will be moved to that room");
                System.out.println("6) There is a possibility you will find a monster there. If you do be brave and fight!");
                System.out.println("You also have possibility to use special attack and heal (if you have heal points)");
                System.out.println("Repeat and have fun!");
                break;
            case "3":
                System.out.println("It was nice having you here!");
        }
        return myChoice;
    }
    public void battleToScreen(Monster theMonster, Hero theHero){
        int[] myStats = new int[8];
        myStats[0] = theMonster.getMINIMUM_DAMAGE();
        myStats[1] = theMonster.getMyMaximumDamage();
        myStats[2] = theMonster.getMyHitPoints();
        myStats[3] = theHero.getMINIMUM_DAMAGE();
        myStats[4] = theHero.getMyMaximumDamage();
        myStats[5] = theHero.getMyHitPoints();
        myStats[6] = theMonster.getMyAttackSpeed();
        myStats[7] = theHero.getMyAttackSpeed();
        myView.battleAttacks(myStats, theMonster.getMyName());
    }
    public boolean getMyVPUsed(){
        return myVPUsed;
    }
    public void setMyVPUsed(){
        myVPUsed = false;
    }
    public Hero getMyHero(){
        return myHero;
    }
    public Monster getMyMonster(){
        return myMonster;
    }
    public void setMyHero(Hero theHero){
        myHero = theHero;
    }
    public Dungeon getMyMainDungeon(){
        return myMainDungeon;
    }
    public Room getRoom(){
        return myMainDungeon.getMyMaze()[getMyMainDungeon().getMyPlayerX()][getMyMainDungeon().getMyPlayerY()][0];
    }
}
