package Controller;

import Model.*;
import View.View;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * ToScreen-makes sure that every element shows on the screen
 */
public class ToScreen implements Serializable {

    private static Dungeon myMainDungeon;
    private static boolean myVPUsed;
    private static Hero myHero;
    private static Monster myMonster;
    private static View myView;
    private final Options OPTIONS = new Options();
    /**
     * heroToScreen-builds stringBuilder for the game
     * @param theName of the hero
     * @return Statistic about hero
     * @throws SQLException
     */
    public StringBuilder heroToScreen(String theName) throws SQLException {
        StringBuilder myStats = new StringBuilder();
        myView = new View();
        if (theName.equalsIgnoreCase("Warrior")) {
            Warrior myWarrior = new Warrior(theName);
            setMyHero(myWarrior);
            myStats = myView.Stats(myWarrior.getMyHitPoints(), myWarrior.getMyAttackSpeed(), myWarrior.getMyChanceToHit(), myWarrior.getMINIMUM_DAMAGE(), myWarrior.getMyMaximumDamage(), myWarrior.getMyChangesToBlockOrHeal());
        } else if (theName.equalsIgnoreCase("Priestess")) {
            Priestess myPriestess = new Priestess(theName);
            setMyHero(myPriestess);
            myStats = myView.Stats(myPriestess.getMyHitPoints(), myPriestess.getMyAttackSpeed(), myPriestess.getMyChanceToHit(), myPriestess.getMINIMUM_DAMAGE(), myPriestess.getMyMaximumDamage(), myPriestess.getMyChangesToBlockOrHeal());
        } else if (theName.equalsIgnoreCase("Thief")) {
            Thief myThief = new Thief(theName);
            setMyHero(myThief);
            myStats = myView.Stats(myThief.getMyHitPoints(), myThief.getMyAttackSpeed(), myThief.getMyChanceToHit(), myThief.getMINIMUM_DAMAGE(), myThief.getMyMaximumDamage(), myThief.getMyChangesToBlockOrHeal());
        }

        return myStats;
    }

    /**
     * dungeonToScreen-shows dungeon on the screen
     * @param theX -passes parameter X
     * @param theY -passes parameter Y
     * @return stringBuilder with dungeon
     */
    public StringBuilder dungeonToScreen(final int theX, final int theY) {
        StringBuilder mySB = new StringBuilder();
        if (myMainDungeon == null) {
            myMainDungeon = new Dungeon(theX, theY);
        }
        String[] mySplit = myMainDungeon.toString().split(" ");
        for (String s : mySplit) {
            switch (s) {
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
            String[] mySplitLoop = s.split("-");
            if (mySplitLoop.length > 1) {
                mySB.append("M");
            }
        }
        return mySB;
    }
    /**
     * Intro-shows the intro of the game
     * @throws Exception
     */
    public void Intro() throws Exception {
        OPTIONS.DifferentOptions();
        //HOPEFULLY WHAT WE NEED TO MAKE SERIALIZATION WORK
        FileOutputStream myFileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream myOut = new ObjectOutputStream(myFileOut);
        //This 5 and 5 are just random, still need to figure out what to pass there
        myOut.writeObject(dungeonToScreen(5, 5));
        myOut.close();
        myFileOut.close();

        System.out.println("The game info saved");

        // Reading the object from a file
        //FileInputStream myFileIn = new FileInputStream("UserInfo.ser");
        //ObjectInputStream myIn = new ObjectInputStream(myFileIn);

        //TODO Serialization works but Deserialization shows an error
        // (Will ask prof on code review what is wrong)
    }
    /**
     * battleToScreen-shows the current battle on the console
     * @param theMonster - passes the monster
     * @param theHero - passes the hero that user chose

     */
    public void battleToScreen(Monster theMonster, Hero theHero) throws Exception {
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
        myStats[10] = (int) theMonster.getMyChangesToBlockOrHeal() * 100;
        myView.battleAttacks(myStats, theMonster.getMyName());
    }
    /**
     * Getter for VP used
     * @return VP
     */
    public boolean getMyVPUsed() {
        return myVPUsed;
    }
    /**
     * Setter for VP
     * @param theTF
     */
    public void setMyVPUsed(boolean theTF) {
        myVPUsed = theTF;
    }
    /**
     * Getter for hero
     * @return
     */
    public Hero getMyHero() {
        return myHero;
    }
    /**
     * Getter for monster
     * @return
     */
    public Monster getMyMonster() {
        return myMonster;
    }

    /**
     * Setter for monster
     * @param theMonster
     */
    public void setMyMonster(Monster theMonster) {
        myMonster = theMonster;
    }
    /**
     * Setter for hero
     * @param theHero
     */
    public void setMyHero(Hero theHero) {
        myHero = theHero;
    }

    /**
     * Getter for main dungeon
     * @return
     */
    public Dungeon getMyMainDungeon() {
        return myMainDungeon;
    }

    /**
     * Setter for main dungeon
     * @param theDungeon
     */
    public void setMyMainDungeon(Dungeon theDungeon) {
        myMainDungeon = theDungeon;
    }
    /**
     * Getter for room
     * @return
     */
    public Room getRoom() {
        return myMainDungeon.getMAZE()[getMyMainDungeon().getMyPlayerX()][getMyMainDungeon().getMyPlayerY()][0];
    }

}
