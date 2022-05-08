package View;
import Controller.Driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverView {

    public static void main(String[] args) throws SQLException {
        System.out.println(chooseHero());
    }
    public static String chooseHero() throws SQLException {
        Scanner myScanner = new Scanner(System.in);
        String myInput = "";
        while(!currentlyAvailableHeroes().contains(myInput)) {
            System.out.println("Choose your hero Warrior, Priestess, or Thief.");
            myInput = myScanner.next();
            if(!currentlyAvailableHeroes().contains(myInput)){
                System.out.println(myInput + " is not a valid hero.");
            }
        }
        return "You chose a "+ myInput + ": \n" + getHero(myInput);
    }
    public static String getHero(String theName) throws SQLException {

        return Driver.heroToScreen(theName).toString();
    }
    public static ArrayList<String> currentlyAvailableHeroes(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Warrior");
        names.add("Priestess");
        names.add("Thief");
        return names;
    }
}
