package Model;

import java.io.Serializable;

public class Dungeon implements Serializable {
    public static void main(String[] args) {
        Dungeon test = new Dungeon();
        System.out.println(test);
    }

    /**
     * 2D room inside of this class
     */
    private Room[][] myMaze;
    /**
     * 2D array that holds coordinates
     */
    private int[][] myCoordinates;

    public Dungeon() {

    }

    @Override

    /*
   TODO STILL NEED TO BE FINISHED
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return "String";
    }


    //creates walls
    private String lineMaker(final String theSegment, final int theLength) {
        StringBuilder sb = new StringBuilder();
        sb.append("    *");
        for (int i = 0; i < theLength; i++) {
            sb.append(" ");
            sb.append(theSegment);
            sb.append(" ");
            sb.append("*");
        }
        sb.append("\n");
        return sb.toString();
    }
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



