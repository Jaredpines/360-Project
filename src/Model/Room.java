package Model;

import java.util.LinkedList;

public class Room {
    private LinkedList<Character> myItems;
    private final int ROOM_X;
    private final int ROOM_Y;
    public Room (int x, int y, final String theItems){
        if (theItems == null || theItems.length()==0){
            throw new IllegalArgumentException("Item passed to room was 0 or null");
        }
        //myItems = setItems();
        ROOM_X = x;
        ROOM_Y = y;
        switch (theItems) {
            case "entrance" -> myItems.add('I');
            case "exit" -> myItems.add('O');
            case "pit" -> myItems.add('X');
        }
     //   public int getRoomX(){
      //      return myRoomX;
     //   }
    }


}
