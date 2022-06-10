package Model;

import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable {
    private int myPlayerX;
    private int myPlayerY;
    final private int Dungeon_X;
    final private int Dungeon_Y;
    private int myEntExi;
    /**
     * 2D room inside this class
     */
    private final Room[][][] MAZE;

    /**
     * 2D array that holds coordinates
     */

    public Dungeon(final int theDungeon_X, final int theDungeon_Y) {
        myEntExi = 0;
        Dungeon_X = theDungeon_X;
        Dungeon_Y = theDungeon_Y;


        MAZE = new Room[theDungeon_X][theDungeon_Y][2];
        createEntranceExit();
        creatPillars();
        creatItemRooms();


    }

    public void createEntranceExit() {
        Random myRand = new Random();
        int myRanNumEntranceX = myRand.nextInt(getDungeon_X());
        int myRanNumEntranceY = myRand.nextInt(getDungeon_Y());
        MAZE[myRanNumEntranceX][myRanNumEntranceY][1] = new Room("player");

        myPlayerX = myRanNumEntranceX;
        myPlayerY = myRanNumEntranceY;
        int myRanNumExitX;
        int myRanNumExitY;
        do {
            myRanNumExitX = myRand.nextInt(getDungeon_X());
            myRanNumExitY = myRand.nextInt(getDungeon_Y());
            //it works here
            //System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        } while (myRanNumEntranceX == myRanNumExitX || myRanNumEntranceY == myRanNumExitY);
        MAZE[myRanNumEntranceX][myRanNumEntranceY][0] = new Room(myEntExi);
        myEntExi++;
        MAZE[myRanNumExitX][myRanNumExitY][0] = new Room(myEntExi);
    }

    public void creatPillars() {
        Random myRand = new Random();
        int myX;
        int myY;
        boolean existenceCheck1 = false;
        boolean existenceCheck2 = false;
        boolean existenceCheck3 = false;
        boolean existenceCheck4 = false;
        while (!existenceCheck1 || !existenceCheck2 || !existenceCheck3 || !existenceCheck4) {
            if (MAZE[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck1) {
                MAZE[myX][myY][0] = new Room("pillarA");
                existenceCheck1 = true;
            }
            if (MAZE[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck2) {
                MAZE[myX][myY][0] = new Room("pillarE");
                existenceCheck2 = true;
            }
            if (MAZE[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck3) {
                MAZE[myX][myY][0] = new Room("pillarI");
                existenceCheck3 = true;
            }
            if (MAZE[myX = myRand.nextInt(getDungeon_X())][myY = myRand.nextInt(getDungeon_Y())][0] == null && !existenceCheck4) {
                MAZE[myX][myY][0] = new Room("pillarP");
                existenceCheck4 = true;
            }
        }
    }

    public void creatItemRooms() {
        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (MAZE[i][j][0] == null) {
                    MAZE[i][j][0] = new Room("items");
                }
            }
        }
    }

    public int getDungeon_X() {
        return Dungeon_X;
    }

    public int getDungeon_Y() {
        return Dungeon_Y;
    }

    public int getMyPlayerX() {
        return myPlayerX;
    }

    public int getMyPlayerY() {
        return myPlayerY;
    }

    public void setMyPlayerX(int thePlayerX) {
        myPlayerX = thePlayerX;
    }

    public void setMyPlayerY(int thePlayerY) {
        myPlayerY = thePlayerY;
    }

    public Room[][][] getMAZE() {
        return MAZE;
    }

    @Override

    /*
   TODO STILL NEED TO BE FINISHED
     */
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (Room[][] rooms : MAZE) {
            for (Room[] room : rooms) {
                mySB.append(room[0].getStatus());
                mySB.append(" ");
            }
        }
        return mySB.toString();
    }


}




