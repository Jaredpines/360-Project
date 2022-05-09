package Model;

import java.util.LinkedList;

public class Room {
    private LinkedList<Character> myItems;
    private int myRoomX;
    private int myRoomY;
    public Room (int x, int y, final String theItems){
        if (theItems == null || theItems.length()==0){
            throw new IllegalArgumentException("Item passed to room was 0 or null");
        }
        //myItems = setItems();
        myRoomX = x;
        myRoomY = y;
        switch (theItems){
            case "entrance":
                myItems.add('I');
                break;
            case "exit":
                myItems.add('O');
                break;
            case "pit":
                myItems.add('X');
                break;
        }
     //   public int getRoomX(){
      //      return myRoomX;
     //   }
    }


}
