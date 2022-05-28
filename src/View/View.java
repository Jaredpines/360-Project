package View;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static Controller.ToScreen.*;

public class View implements Serializable {
    public String chooseHero() throws SQLException {
        Scanner myScanner = new Scanner(System.in);
        String myInput = "";
        while(!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))) {
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
            if(!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))){
                System.out.println(myInput + " is not a valid hero.");
            }
        }
        getMyHero().setMyName(myInput.substring(0,1).toUpperCase(Locale.ROOT) + myInput.substring(1).toLowerCase(Locale.ROOT));
        return "You chose a "+ getMyHero().getMyName() + ": \n" + getHeroString(myInput);
    }
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
    public String getHeroString(String theName) throws SQLException {

        return heroToScreen(theName).toString();
    }
    public String mapMaker(final int theX, final int theY) {
        StringBuilder mySB = new StringBuilder();
        String[] mySplit = dungeonToScreen(theX,theY).toString().split("");
        int myCounter = 0;
        for (int i = 0; i < theY*2+1; i++) {
            mySB.append("*");
        }
        mySB.append("\n");
        for (int i = 0; i < theX; i++) {
            mySB.append("*");
            for (int j = 0; j < theY+2; j++) {
                if(!(myCounter >= mySplit.length) && j > 1) {
                    mySB.append(mySplit[myCounter]);
                    myCounter++;
                    mySB.append("|");
                }

            }
            mySB.deleteCharAt(mySB.length()-1);
            mySB.append("*");
            mySB.append("\n");
            if(i<theX-1) {
                for (int j = 0; j < theY + 1; j++) {
                    mySB.append("*-");
                }
                mySB.deleteCharAt(mySB.length() - 1);
                mySB.append("\n");
            }
        }
        for (int i = 0; i < theY*2+1; i++) {
            mySB.append("*");
        }
        mySB.append("\n");
        return mySB.toString();
    }
    public String roomMap(int theX, int theY){
        int mySideRoomsLeft = 0;
        int mySideRoomsRight = 0;
        StringBuilder myRoom = new StringBuilder();
        String[] theSplit = mapMaker(theX , theY).split("\n");
        if(getMyVPUsed()){
            mySideRoomsLeft = 2;
            mySideRoomsRight = 2;
            if(0 <= getMyMainDungeon().getMyPlayerX()*2 - 2) {
                if(getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0){
                    mySideRoomsLeft = 0;
                }
                if((getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[getMyMainDungeon().getMyPlayerX() * 2 - 2].length()){
                    mySideRoomsRight = 0;
                }
                myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 - 2], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            if(0 <= getMyMainDungeon().getMyPlayerX()*2 - 1) {
                myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 - 1], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                mySideRoomsLeft = 2;
                mySideRoomsRight = 2;
                myRoom.append("\n");
            }
        }


        if(getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0){
            mySideRoomsLeft = 0;
        }
        if((getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[getMyMainDungeon().getMyPlayerX() * 2].length()){
            mySideRoomsRight = 0;
        }
        myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        myRoom.append("\n");
        myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 + 1], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        myRoom.append("\n");
        myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 + 2], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
        mySideRoomsLeft = 2;
        mySideRoomsRight = 2;


        if(getMyVPUsed()){
            if(theSplit.length > getMyMainDungeon().getMyPlayerX()*2+3) {
                myRoom.append("\n");
                if(getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft < 0){
                    mySideRoomsLeft = 0;
                }
                if((getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsLeft >= theSplit[getMyMainDungeon().getMyPlayerX() * 2 + 3].length()){
                    mySideRoomsRight = 0;
                }
                myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 + 3], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            if(theSplit.length > getMyMainDungeon().getMyPlayerX()*2+4) {
                myRoom.append(theSplit[getMyMainDungeon().getMyPlayerX() * 2 + 4], getMyMainDungeon().getMyPlayerY() * 2 - mySideRoomsLeft, (getMyMainDungeon().getMyPlayerY() * 2) + 3 + mySideRoomsRight);
                myRoom.append("\n");
            }
            setMyVPUsed();
        }
        return myRoom.toString();
    }
    public String potionsToScreen(int theHP, int theVP){
        StringBuilder mySB = new StringBuilder();
        mySB.append("Number of Health Potions: ").append(theHP);
        mySB.append("   ");
        mySB.append("Number of Vision Potions: ").append(theVP);
        return mySB.toString();
    }
    public String battle(int[] theStats, String monsterName){
        return monsterName + "           " + getMyHero().getMyName() +
                "\n" +
                "HP " + theStats[2] + "         " + "HP " + theStats[5] +
                "\n" +
                "Damage " + theStats[0] + "-" + theStats[1] + "   " + "Damage " + theStats[3] + "-" + theStats[4] +
                "\n";
    }
    public ArrayList<String> currentlyAvailableHeroes(){
        ArrayList<String> names = new ArrayList<>();
        names.add("WARRIOR");
        names.add("PRIESTESS");
        names.add("THIEF");
        return names;
    }
}
