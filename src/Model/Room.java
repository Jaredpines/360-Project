package Model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

public class Room implements Serializable {
    private LinkedList<Character> items;

    private String status = "";
    public Room (int entExi){
        if(entExi == 0){
            this.status = "entrance";
        }
        else if(entExi == 1){
            this.status = "exit";
        }
        else {
            System.out.println("Hey dummy you coded this wrong.");
        }
    }
    public Room (final String theItems){
        switch (theItems) {
            case "pillarA" -> this.status = "A";
            case "pillarE" -> this.status = "E";
            case "pillarI" -> this.status = "I";
            case "pillarP" -> this.status = "P";
        }
        if(theItems.equals("items")){
            Random myRand = new Random();
            int myHP = myRand.nextInt(101);
            int myVP = myRand.nextInt(101);
            int myPit = myRand.nextInt(101);
            boolean existenceCheck1 = false;
            boolean existenceCheck2 = false;
            if(myHP < 10){
                this.status += "HP";
                existenceCheck1 = true;
            }
            if(myVP < 10){
                if (existenceCheck1){
                    this.status += "-";
                }
                this.status += "VP";
                existenceCheck2 = true;

            }

            if (myPit < 10){
                if (existenceCheck2||existenceCheck1){
                    this.status += "-";
                }
                this.status += "Pit";
            }
            if (this.status.equals("")){
                this.status = "empty";
            }
        }

    }


    public String getStatus() {
        return status;
    }
}
