package View;
import Controller.Driver;
import Model.Dungeon;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static Model.Dungeon.*;

public class DriverView implements Serializable {


    public static String chooseHero() throws SQLException {
        Scanner myScanner = new Scanner(System.in);
        String myInput = "";
        while(!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))) {
            System.out.println("Choose your hero Warrior, Priestess, or Thief.");
            System.out.println();
            System.out.println("Warrior");
            System.out.println(getHero("Warrior"));
            System.out.println();
            System.out.println("Priestess");
            System.out.println(getHero("Priestess"));
            System.out.println();
            System.out.println("Thief");
            System.out.println(getHero("Thief"));
            myInput = myScanner.next();
            if(!currentlyAvailableHeroes().contains(myInput.toUpperCase(Locale.ROOT))){
                System.out.println(myInput + " is not a valid hero.");
            }
        }
        String myName =  myInput.substring(0,1).toUpperCase(Locale.ROOT) + myInput.substring(1).toLowerCase(Locale.ROOT);
        return "You chose a "+ myName + ": \n" + getHero(myInput);
    }
    public static String getHero(String theName) throws SQLException {

        return Driver.heroToScreen(theName).toString();
    }
    public static String mapMaker(final int theX, final int theY) {
        StringBuilder mySB = new StringBuilder();
        String[] mySplit = Driver.dungeonToScreen(theX,theY).toString().split("");
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
    public static String roomMap(int theX, int theY){
        int mySpacer = 2;
        StringBuilder myRoom = new StringBuilder();
        String[] theSplit = mapMaker(theX , theY).split("\n");
        myRoom.append(theSplit[getMyPlayerX()*2], getMyPlayerY()*2, (getMyPlayerY()*2)+3);
        myRoom.append("\n");
        myRoom.append(theSplit[(getMyPlayerX()*2)+1], getMyPlayerY()*2, (getMyPlayerY()*2)+3);
        myRoom.append("\n");
        myRoom.append(theSplit[(getMyPlayerX()*2)+2], getMyPlayerY()*2, (getMyPlayerY()*2)+3);
        return myRoom.toString();
    }
    public static ArrayList<String> currentlyAvailableHeroes(){
        ArrayList<String> names = new ArrayList<>();
        names.add("WARRIOR");
        names.add("PRIESTESS");
        names.add("THIEF");
        return names;
    }
}
