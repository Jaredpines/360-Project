package Controller;

import Model.Monster;
import Model.MovePlayer;
import View.Art;
import View.View;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static View VIEW = new View();
    private final ToScreen TO_SCREEN = new ToScreen();
    private final MovePlayer MOVE_PLAYER = new MovePlayer();
    private String myChoice = "";
    private boolean myPillar1 = false;
    private boolean myPillar2 = false;
    private boolean myPillar3 = false;
    private boolean myPillar4 = false;
    private int myPillarCount;

    public void Game(Art ART) throws Exception {
        int myX = SCANNER.nextInt();
        int myY = SCANNER.nextInt();
        Random myRand = new Random();
        System.out.println(VIEW.potionsToScreen(TO_SCREEN.getMyHero().getMyHPTotal(), TO_SCREEN.getMyHero().getMyVPTotal()));
        System.out.println(VIEW.roomMap(myX, myY));
        while (!myChoice.equalsIgnoreCase("Stop")) {
            System.out.println("Type Left, Right, Up, or Down to move.");
            if (TO_SCREEN.getMyHero().getMyHPTotal() > 0 || TO_SCREEN.getMyHero().getMyVPTotal() > 0) {
                System.out.println("Type HP or VP to use potions");
            }
            myChoice = SCANNER.next();
            if (myChoice.equalsIgnoreCase("m")) {
                System.out.println(VIEW.mapMaker(myX, myY));
            } else if (myChoice.equalsIgnoreCase("HP") && TO_SCREEN.getMyHero().getMyHPTotal() > 0) {
                TO_SCREEN.getMyHero().setMyHPTotal(TO_SCREEN.getMyHero().getMyHPTotal() - 1);
                int myRandHP = myRand.nextInt(11) + 5;
                TO_SCREEN.getMyHero().setMyHitPoint(TO_SCREEN.getMyHero().getMyHitPoints() + myRandHP);
                System.out.println(VIEW.roomMap(myX, myY));
            } else if (myChoice.equalsIgnoreCase("VP") && TO_SCREEN.getMyHero().getMyVPTotal() > 0) {
                TO_SCREEN.getMyHero().setMyVPTotal(TO_SCREEN.getMyHero().getMyVPTotal() - 1);
                TO_SCREEN.setMyVPUsed(true);
                System.out.println(VIEW.roomMap(myX, myY));
            } else if (myChoice.equalsIgnoreCase("left") || myChoice.equalsIgnoreCase("right") || myChoice.equalsIgnoreCase("up") || myChoice.equalsIgnoreCase("down")) {
                MOVE_PLAYER.move(myChoice);
                System.out.println(VIEW.roomMap(myX, myY));
                if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("A")) {
                    SpecialBattle();
                    myPillar1 = true;
                    myPillarCount++;
                } else if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("E")) {
                    SpecialBattle();
                    myPillar2 = true;
                    myPillarCount++;
                } else if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("I")) {
                    SpecialBattle();
                    myPillar3 = true;
                    myPillarCount++;
                } else if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("P")) {
                    SpecialBattle();
                    myPillar4 = true;
                    myPillarCount++;
                } else if (myRand.nextInt(101) > 75 && !TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                        && !TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                    RandomMonster(myRand);
                    TO_SCREEN.battleToScreen(TO_SCREEN.getMyMonster(), TO_SCREEN.getMyHero());
                }
            }

            if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("Pit")) {
                System.out.println("You fell in a pit and took damage!");
                System.out.println("HP: " + TO_SCREEN.getMyHero().getMyHitPoints());
            }
            if (!TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("entrance")
                    && !TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].setStatus("empty");
            } else if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")
                    && myPillar1 && myPillar2 && myPillar3 && myPillar4) {
                System.out.println(ART.YouWinArt());
                System.exit(0);
            } else if (TO_SCREEN.getMyMainDungeon().getMAZE()[TO_SCREEN.getMyMainDungeon().getMyPlayerX()][TO_SCREEN.getMyMainDungeon().getMyPlayerY()][0].getStatus().equalsIgnoreCase("exit")) {
                System.out.println("You need to collect all the pillars of OO to exit you only have " + myPillarCount + " pillars.");
            }

            System.out.println(VIEW.potionsToScreen(TO_SCREEN.getMyHero().getMyHPTotal(), TO_SCREEN.getMyHero().getMyVPTotal()));
        }
    }

    public void SpecialBattle() throws Exception {
        Random myRand = new Random();
        RandomMonster(myRand);
        int myWhichMonster;
        TO_SCREEN.getMyMonster().setMyHitPoint(TO_SCREEN.getMyMonster().getMyHitPoints() + (TO_SCREEN.getMyMonster().getMyHitPoints() / 2));
        myWhichMonster = myRand.nextInt(11);
        final String BLUE = "\u001B[38;5;4m ";
        final String GREEN = "\u001B[38;5;2m ";
        final String RED = "\u001B[38;5;1m ";
        final String YELLOW = "\u001B[38;5;11m ";
        final String PURPLE = "\u001B[38;5;129m ";
        final String VIOLET = "\u001B[38;5;5m ";
        final String ORANGE = "\u001B[38;5;208m ";
        final String BLACK = "\u001B[38;5;0m ";
        final String MAGENTA = "\u001B[38;5;201m ";
        final String CRIMSON = "\u001B[38;2;157;34;53m ";
        final String BACKGROUND = "\u001B[48;5;244m";
        final String RESET = " \u001B[0m";
        switch (myWhichMonster) {
            case 0 -> TO_SCREEN.getMyMonster().setMyName(BLUE + "Blue " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 1 -> TO_SCREEN.getMyMonster().setMyName(GREEN + "Green " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 2 -> TO_SCREEN.getMyMonster().setMyName(RED + "Red " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 3 -> TO_SCREEN.getMyMonster().setMyName(YELLOW + "Yellow " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 4 -> TO_SCREEN.getMyMonster().setMyName("White " + TO_SCREEN.getMyMonster().getMyName());
            case 5 -> TO_SCREEN.getMyMonster().setMyName(PURPLE + "Purple " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 6 -> TO_SCREEN.getMyMonster().setMyName(VIOLET + "Violet " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 7 -> TO_SCREEN.getMyMonster().setMyName(ORANGE + "Orange " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 8 -> TO_SCREEN.getMyMonster().setMyName(BACKGROUND + BLACK + "Black " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 9 -> TO_SCREEN.getMyMonster().setMyName(MAGENTA + "Magenta " + TO_SCREEN.getMyMonster().getMyName() + RESET);
            case 10 -> TO_SCREEN.getMyMonster().setMyName(CRIMSON + "Crimson " + TO_SCREEN.getMyMonster().getMyName() + RESET);
        }
        TO_SCREEN.battleToScreen(TO_SCREEN.getMyMonster(), TO_SCREEN.getMyHero());
    }

    private void RandomMonster(Random myRand) throws SQLException {
        int myWhichMonster = myRand.nextInt(3);
        switch (myWhichMonster) {
            case 0 -> TO_SCREEN.setMyMonster(new Monster("Ogre"));
            case 1 -> TO_SCREEN.setMyMonster(new Monster("Skeleton"));
            case 2 -> TO_SCREEN.setMyMonster(new Monster("Gremlin"));
        }
    }
}
