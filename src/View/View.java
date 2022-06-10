package View;

import Controller.ToScreen;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * Class that shows how the game works in the console
 */
public class View implements Serializable {
    private final Art ART = new Art();
    private final ToScreen TO_SCREEN = new ToScreen();
    /**
     * This method helps to choose the hero
     * @return String that shows hero you chose
     * @throws SQLException
     */
    public String chooseHero() throws SQLException {
        Scanner myScanner = new Scanner(System.in);
        String myInput = "";
        while (!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))) {
            System.out.println("Choose your hero Warrior, Priestess, or Thief.");
            System.out.println();
            System.out.println("Warrior");
            System.out.println(getHeroString("Warrior"));
            System.out.println();
            System.out.println("Priestess");
            System.out.println(getHeroString("Priestess"));
            System.out.println();
            System.out.println("Thief");
            System.out.println(getHeroString("Thief"));
            myInput = myScanner.next();
            if (!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))) {
                System.out.println(myInput + " is not a valid hero.");
            }
        }
        TO_SCREEN.getMyHero().setMyName(myInput.substring(0, 1).toUpperCase(Locale.ROOT) + myInput.substring(1).toLowerCase(Locale.ROOT));
        return "You chose a " + TO_SCREEN.getMyHero().getMyName() + ": \n" + getHeroString(myInput);
    }
    /**
     * Method that is works with statistic of all hit points, attack speed, chance to hit, minimum damage, maximum damage, and change to block or heal
     * @param hit_points
     * @param attack_speed
     * @param chance_to_hit
     * @param minimum_damage
     * @param maximum_damage
     * @param chance_to_block_or_heal
     * @return all the statistic that is in parametrs
     */
    public StringBuilder Stats(int hit_points, int attack_speed, double chance_to_hit, int minimum_damage, int maximum_damage, double chance_to_block_or_heal) {
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(hit_points).append("\n");
        stats.append("attack speed: ").append(attack_speed).append("\n");
        stats.append("chance to hit: ").append(chance_to_hit).append("\n");
        stats.append("minimum damage: ").append(minimum_damage).append("\n");
        stats.append("maximum damage: ").append(maximum_damage).append("\n");
        stats.append("chance to block: ").append(chance_to_block_or_heal).append("\n");
        return stats;
    }
    /**
     * Hettore for Hero name
     * @param theName
     * @return the name of the hero
     * @throws SQLException
     */
    public String getHeroString(String theName) throws SQLException {

        return TO_SCREEN.heroToScreen(theName).toString();
    }
    /**
     * Make the map of the game with X and Y
     * @param theX coordinates of X
     * @param theY coordinates of Y
     * @return map
     */
    public String mapMaker(final int theX, final int theY) {
        StringBuilder mySB = new StringBuilder();
        String[] mySplit = TO_SCREEN.dungeonToScreen(theX, theY).toString().split("");
        int myCounter = 0;
        mySB.append("*".repeat(Math.max(0, theY * 2 + 1)));
        mySB.append("\n");
        for (int i = 0; i < theX; i++) {
            mySB.append("*");
            for (int j = 0; j < theY + 2; j++) {
                if (!(myCounter >= mySplit.length) && j > 1) {
                    mySB.append(mySplit[myCounter]);
                    myCounter++;
                    mySB.append("|");
                }

            }
            mySB.deleteCharAt(mySB.length() - 1);
            mySB.append("*");
            mySB.append("\n");
            if (i < theX - 1) {
                mySB.append("*-".repeat(Math.max(0, theY + 1)));
                mySB.deleteCharAt(mySB.length() - 1);
                mySB.append("\n");
            }
        }
        mySB.append("*".repeat(Math.max(0, theY * 2 + 1)));
        mySB.append("\n");
        return mySB.toString();
    }
    /**
     * Creates room for the map
     * @param theX coordinates of X
     * @param theY coordinates of Y
     * @return String of the room
     */
    public String roomMap(int theX, int theY) {
        int mySideRoomsLeft = 0;
        int mySideRoomsRight = 0;
        StringBuilder myRoom = new StringBuilder();
        String[] theSplit = mapMaker(theX, theY).split("\n");
        if (TO_SCREEN.getMyVPUsed()) {
            mySideRoomsLeft = 2;
            mySideRoomsRight = 2;
            if (0 <= TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 - 2) {
                if (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0) {
                    mySideRoomsLeft = 0;
                }
                if ((TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 - 2].length()) {
                    mySideRoomsRight = 0;
                }
                myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 - 2], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            if (0 <= TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 - 1) {
                myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 - 1], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                mySideRoomsLeft = 2;
                mySideRoomsRight = 2;
                myRoom.append("\n");
            }
        }


        if (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0) {
            mySideRoomsLeft = 0;
        }
        if ((TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2].length()) {
            mySideRoomsRight = 0;
        }
        myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        myRoom.append("\n");
        myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 1], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        myRoom.append("\n");
        myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 2], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        mySideRoomsLeft = 2;
        mySideRoomsRight = 2;


        if (TO_SCREEN.getMyVPUsed()) {
            if (theSplit.length > TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 3) {
                myRoom.append("\n");
                if (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0) {
                    mySideRoomsLeft = 0;
                }
                if ((TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 3].length()) {
                    mySideRoomsRight = 0;
                }
                myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 3], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            if (theSplit.length > TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 4) {
                myRoom.append(theSplit[TO_SCREEN.getMyMainDungeon().getMyPlayerX() * 2 + 4], TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (TO_SCREEN.getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            TO_SCREEN.setMyVPUsed(false);
        }
        return myRoom.toString();
    }
    /**
     * Shows the number of health and vision potionas on the screen
     * @param theHP health potions
     * @param theVP vision potions
     * @return string builder of potions
     */
    public String potionsToScreen(int theHP, int theVP) {
        return "Number of Health Potions: " + theHP +
                "   " +
                "Number of Vision Potions: " + theVP;
    }
    /**
     * Shows the text of the battle.
     * @param theStats the statistic
     * @param theMonsterName the name of the hero
     * @return statistics about hero and monster
     */
    public String battleText(int[] theStats, String theMonsterName) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_CYAN = "\u001B[36m";
        final String UNDERLINE = "\u001B[4m";
        String myMonsterName;
        StringBuilder mySpaces = new StringBuilder();
        String[] mySplit = theMonsterName.split(" ");
        if (mySplit.length > 3) {
            myMonsterName = theMonsterName;
            mySpaces.append(" ".repeat(Math.max(0, 22 - (mySplit[1].length() + mySplit[2].length() + 1))));
        } else {
            myMonsterName = " " + theMonsterName + " ";
            mySpaces.append(" ".repeat(Math.max(0, 22 - theMonsterName.length())));
        }
        return UNDERLINE + myMonsterName + ANSI_RESET + mySpaces + UNDERLINE + " " + TO_SCREEN.getMyHero().getMyName() + " " + ANSI_RESET + "\n" +
                String.format("%-28s %-15s%n", ANSI_RED + "HP: " + theStats[2], ANSI_RESET + ANSI_CYAN + "HP: " + theStats[5] + ANSI_RESET) +
                String.format("%-28s %-15s%n", ANSI_RED + "Damage: " + theStats[0] + "-" + theStats[1], ANSI_RESET + ANSI_CYAN + "Damage: " + theStats[3] + "-" + theStats[4] + ANSI_RESET) +
                String.format("%-28s %-15s%n", ANSI_RED + "Attack Speed: " + theStats[6], ANSI_RESET + ANSI_CYAN + "Attack Speed: " + theStats[7] + ANSI_RESET) +
                String.format("%-23s %-23s", "", ANSI_CYAN + "Health Potions: " + TO_SCREEN.getMyHero().getMyHPTotal() + ANSI_RESET);
    }
    /**
     * Asks user about attack and what attack he wants to use
     * @param theStats statistics
     * @param theMonsterName monster name
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public void battleAttacks(int[] theStats, String theMonsterName) throws Exception {
        int myMonsterSpeed = theStats[6];
        int myHeroSpeed = theStats[7];
        Scanner myScanner = new Scanner(System.in);
        String myInput;
        System.out.println(battleText(theStats, theMonsterName));
        while (theStats[5] > 0 && theStats[2] > 0) {
            while (myHeroSpeed > 0 && theStats[5] > 0 && theStats[2] > 0) {
                myHeroSpeed -= myMonsterSpeed;
                System.out.println("Do you want to (A)ttack, use (S)pecial attack or (H)eal?");
                myInput = myScanner.next();
                if (myInput.equalsIgnoreCase("A")) {
                    int myHitOrMiss = TO_SCREEN.getMyHero().attack();
                    if (myHitOrMiss != 0) {
                        theStats[2] = theStats[2] - myHitOrMiss;
                        System.out.println("Your attack hits for " + myHitOrMiss + " damage.");
                    } else {
                        System.out.println("Your attack missed.");
                    }
                } else if (myInput.equalsIgnoreCase("H") && TO_SCREEN.getMyHero().getMyHPTotal() > 0) {
                    TO_SCREEN.getMyHero().setMyHPTotal(TO_SCREEN.getMyHero().getMyHPTotal() - 1);
                    Random myRand = new Random();
                    int myRandHP = myRand.nextInt(11) + 5;
                    TO_SCREEN.getMyHero().setMyHitPoint(TO_SCREEN.getMyHero().getMyHitPoints() + myRandHP);
                    theStats[5] = theStats[5] + myRandHP;
                    System.out.println("You healed for " + myRandHP + "HP.");
                } else if (myInput.equalsIgnoreCase("S")) {
                    if (TO_SCREEN.getMyHero().getMyName().equalsIgnoreCase("Priestess")) {
                        int myHeal = TO_SCREEN.getMyHero().specialAttack();
                        theStats[5] = theStats[5] + myHeal;
                        System.out.println("You healed for " + myHeal + "HP.");
                    } else {
                        int myHitMiss = TO_SCREEN.getMyHero().specialAttack();
                        if (myHitMiss != 0) {
                            theStats[2] = theStats[2] - myHitMiss;
                            System.out.println("Your attack hits for " + myHitMiss + " damage.");
                        } else {
                            System.out.println("You missed.");
                        }

                    }
                } else if (myInput.equalsIgnoreCase("Avada_Kedavra")) {
                    File myFile = new File("death.wav");
                    AudioInputStream myAudioStream = AudioSystem.getAudioInputStream(myFile);
                    Clip myClip = AudioSystem.getClip();
                    myClip.open(myAudioStream);
                    FloatControl gainControl = (FloatControl) myClip.getControl(FloatControl.Type.MASTER_GAIN);
                    myClip.start();
                    gainControl.setValue(6.0f);
                    theStats[2] = 0;
                }
                if (theStats[2] <= 0) {
                    theStats[2] = 0;
                    System.out.println(battleText(theStats, theMonsterName));
                    System.out.println("The monster is dead!");
                } else {
                    System.out.println(battleText(theStats, theMonsterName));
                }
            }
            myMonsterSpeed = theStats[6];
            myHeroSpeed = theStats[7];
            while (myMonsterSpeed > 0 && theStats[5] > 0 && theStats[2] > 0) {
                int myHitOrMiss = TO_SCREEN.getMyMonster().attack();
                myMonsterSpeed -= myHeroSpeed;
                if (myHitOrMiss != 0) {
                    theStats[5] = theStats[5] - myHitOrMiss;
                    System.out.println("The " + theMonsterName + " attacked for " + myHitOrMiss + " damage.");
                } else {
                    System.out.println("The " + theMonsterName + " missed.");
                }
                TO_SCREEN.getMyMonster().setMyHitPoint(TO_SCREEN.getMyMonster().heal());
                if (theStats[5] < 0) {
                    theStats[5] = 0;
                    System.out.println(battleText(theStats, theMonsterName));
                    System.out.println("You have died! ;_;");
                    System.out.println(ART.GameOverArt());
                    TO_SCREEN.Intro();
                }
                System.out.println(battleText(theStats, theMonsterName));
            }
            myMonsterSpeed = theStats[6];

        }
        TO_SCREEN.getMyHero().setMyHitPoint(theStats[5]);
    }
    /**
     * Shows the availables hero
     * @return the name of the hero
     */
    public ArrayList<String> currentlyAvailableHeroes() {
        ArrayList<String> names = new ArrayList<>();
        names.add("WARRIOR");
        names.add("PRIESTESS");
        names.add("THIEF");
        return names;
    }
}
