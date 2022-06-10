package Model;

import java.io.Serializable;
import java.util.Random;
/**
 * The class that create Dungeon
 */
public class Dungeon implements Serializable {
    private int myPlayerX;
    private int myPlayerY;
    final private int Dungeon_X;
    final private int Dungeon_Y;
    private int myEntExi;

    private final Room[][][] MAZE;

    /**
     * Constructor for the Dungeon
     * @param theDungeon_X X coordinates
     * @param theDungeon_Y Y coordinates
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
    /**
     * Create entrance and exit
     */
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
    /**
     * Create pillars
     */
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

    /**
     * Create iteams for rooms
     */
    public void creatItemRooms() {
        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (MAZE[i][j][0] == null) {
                    MAZE[i][j][0] = new Room("items");
                }
            }
        }
    }

    /**
     * Getters for Dungeon with coordinates X
     * @return
     */
    public int getDungeon_X() {
        return Dungeon_X;
    }
    /**
     * Getters for Dungeon with coordinates Y
     * @return
     */
    public int getDungeon_Y() {
        return Dungeon_Y;
    }
    /**
     * Getters for Player with coordinates X
     * @return
     */
    public int getMyPlayerX() {
        return myPlayerX;
    }
    /**
     * Getters for Player with coordinates Y
     * @return
     */
    public int getMyPlayerY() {
        return myPlayerY;
    }
    /**
     * Setters for Player with coordinates X
     * @return
     */
    public void setMyPlayerX(int thePlayerX) {
        myPlayerX = thePlayerX;
    }
    /**
     * Getters for Player with coordinates Y
     * @return
     */
    public void setMyPlayerY(int thePlayerY) {
        myPlayerY = thePlayerY;
    }

    /**
     * Returns the maze
     * @return
     */
    public Room[][][] getMAZE() {
        return MAZE;
    }

    @Override

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




