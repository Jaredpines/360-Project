package Model;

import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable {
    final private int X;
    final private int Y;
    private int entExi;
    private int myRanNumEntranceX;
    private int myRanNumEntranceY;
    private int myRanNumExitX;
    private int myRanNumExitY;
    /**
     * 2D room inside of this class
     */
    private Room[][] myMaze;
    /**
     * 2D array that holds coordinates
     */
    private int myCoordinates;

    public Dungeon(final int X, final int Y, int myCoordinate) {
        this.entExi = 0;
        this.X = X;
        this.Y = Y;
        this.myCoordinates = myCoordinate;

        myMaze = new Room[X][Y];
        createEntranceExit();
        creatPillars();
        creatItemRooms();

        //TODO Wrong too
        System.out.println("corX " + myRanNumEntranceX + "_ corY " + myRanNumEntranceY);


    }
    public void createEntranceExit(){
        Random myRand = new Random();
        myRanNumEntranceX = myRand.nextInt(getX());
        myRanNumEntranceY = myRand.nextInt(getY());

        //TODO SHOWS weird coordinates

        do{
            myRanNumExitX = myRand.nextInt(getX());
            myRanNumExitY = myRand.nextInt(getY());
            //it works here
            //System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        }while (myRanNumEntranceX == myRanNumExitX || myRanNumEntranceY == myRanNumExitY);
        myMaze[myRanNumEntranceX][myRanNumEntranceY] = new Room(entExi);
        entExi++;
        myMaze[myRanNumExitX][myRanNumExitY]= new Room(entExi);
       // System.out.println("ExitCorX " + myRanNumExitX + "ExitCorY " + myRanNumExitY);
        //System.out.println("corX " + myRanNumEntranceX + "corY " + myRanNumEntranceY);
    }
    public void creatPillars(){
        Random myRand = new Random();
        int myX;
        int myY;
        boolean existenceCheck1 = false;
        boolean existenceCheck2 = false;
        boolean existenceCheck3 = false;
        boolean existenceCheck4 = false;
        while (!existenceCheck1||!existenceCheck2||!existenceCheck3||!existenceCheck4) {
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())] == null && !existenceCheck1) {
                myMaze[myX][myY] = new Room("pillarA");
                existenceCheck1 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())] == null && !existenceCheck2) {
                myMaze[myX][myY] = new Room("pillarE");
                existenceCheck2 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())] == null && !existenceCheck3) {
                myMaze[myX][myY]= new Room("pillarI");
                existenceCheck3 = true;
            }
            if (myMaze[myX = myRand.nextInt(getX())][myY = myRand.nextInt(getY())] == null && !existenceCheck4) {
                myMaze[myX][myY] = new Room("pillarP");
                existenceCheck4 = true;
            }
        }
    }
    public void creatItemRooms(){
        for (int i = 0; i < myMaze.length; i++){
            for (int j = 0; j < myMaze[i].length; j++) {
                if(myMaze[i][j] == null){
                    myMaze[i][j] = new Room("items");
                }
            }
        }
    }
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Room[][] getMyMaze() {
        return myMaze;
    }

    public void setMyMaze(Room[][] myMaze) {
        this.myMaze = myMaze;
    }

    @Override

    /*
   TODO STILL NEED TO BE FINISHED
     */
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < myMaze.length; i++){
            for (int j = 0; j < myMaze[i].length; j++) {
                mySB.append(myMaze[i][j].getStatus());
                mySB.append(" ");
            }
        }
        return mySB.toString();
    }


    //creates walls

}

    /* STILL DECIDING IF WE NEED IT
    //creates walls bases on their Rows
    private String lineMaker(final int theRow) {
        StringBuilder sb = new StringBuilder();
        sb.append("    *");
        for (int col = 0; col < myMaze[theRow].length; col++) {
            sb.append(" ");
            if (theRow == myCoordinates[4][0] && col == myCoordinates[4][1])
                sb.append("@");	// @ for Hero's location
            else
                sb.append(myMaze[theRow][col]);
            sb.append(" ");
            if (col == myMaze[theRow].length - 1)
                sb.append("*");
            else
                sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }


}

     */



