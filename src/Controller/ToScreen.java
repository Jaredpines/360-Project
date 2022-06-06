package Controller;

import Model.*;
import View.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    private final Options OPTIONS = new Options();
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
    public void Intro () throws Exception {
        OPTIONS.DifferentOptions();
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
    }
    public void battleToScreen(Monster theMonster, Hero theHero) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int[] myStats = new int[11];
        myStats[0] = theMonster.getMINIMUM_DAMAGE();
        myStats[1] = theMonster.getMyMaximumDamage();
        myStats[2] = theMonster.getMyHitPoints();
        myStats[3] = theHero.getMINIMUM_DAMAGE();
        myStats[4] = theHero.getMyMaximumDamage();
        myStats[5] = theHero.getMyHitPoints();
        myStats[6] = theMonster.getMyAttackSpeed();
        myStats[7] = theHero.getMyAttackSpeed();
        myStats[8] = theMonster.getMINIMUM_HEAL_POINTS();
        myStats[9] = theMonster.getMAXIMUM_HEAL_POINTS();
        myStats[10] = (int)theMonster.getMyChangesToBlockOrHeal()*100;
        myView.battleAttacks(myStats, theMonster.getMyName());
    }
    public boolean getMyVPUsed(){
        return myVPUsed;
    }
    public void setMyVPUsed(boolean theTF){
        myVPUsed = theTF;
    }
    public Hero getMyHero(){
        return myHero;
    }
    public Monster getMyMonster(){
        return myMonster;
    }
    public void setMyMonster(Monster theMonster){
        myMonster = theMonster;
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
