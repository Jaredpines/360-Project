package Controller;

import Model.Dungeon;
import Model.Hero;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

import static Model.DungeonAdventure.Play;
import static View.DriverView.chooseHero;
import static View.DriverView.mapMaker;

public class Driver implements Serializable {
    public static void main(String[] args) throws SQLException {
        System.out.println("Working");
        try {
            Intro();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ooops, game has an issue in main: " + e.getMessage());
        }

    }
    public static StringBuilder heroToScreen(String theName) throws SQLException {
        Hero myHero = new Hero(theName);
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(myHero.getHIT_POINTS()).append("\n");
        stats.append("attack speed: ").append(myHero.getATTACK_SPEED()).append("\n");
        stats.append("chance to hit: ").append(myHero.getCHANCE_TO_HIT()).append("\n");
        stats.append("minimum damage: ").append(myHero.getMINIMUM_DAMAGE()).append("\n");
        stats.append("maximum damage: ").append(myHero.getMAXIMUM_DAMAGE()).append("\n");
        stats.append("chance to block: ").append(myHero.getCHANCE_TO_BLOCK_OR_HEAL()).append("\n");
        return stats;
    }
    public static StringBuilder dungeonToScreen(final int theX, final int theY){
        StringBuilder mySB = new StringBuilder();
        Dungeon myDungeon = new Dungeon(theX,theY);
        String[] mySplit = myDungeon.toString().split(" ");
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
                System.out.println("Thanks for choosing to play our game");
                System.out.println("You can always save the game if you need to run and do some errands");
                System.out.println(chooseHero());
                Play();
                System.out.println("Please enter the size of your dungeon in X Y format.");
                int myX = sc.nextInt();
                int myY = sc.nextInt();
                System.out.println("Type M to see the map");
                myChoice = sc.next();
                if(myChoice.equalsIgnoreCase("M")){
                    System.out.println(mapMaker(myX,myY));
                }


            case "2":
                System.out.println("Game is under construction \n" +
                        "Instructions will be added soon!");
                break;
            case "3":
                System.out.println("It was nice having you here!");
        }
    }
}
