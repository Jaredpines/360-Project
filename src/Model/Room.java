package Model;

import Controller.ToScreen;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

public class Room implements Serializable {
    private LinkedList<Character> items;
    private String status = "";
    private ToScreen myToScreen = new ToScreen();
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
        if(theItems.equals("player")){
            this.status = "player";
        }

    }
    public void statusEffect(String theStatus){
        String[] mySplit = theStatus.split("-");
        Random myRand = new Random();
        for (int i = 0; i < mySplit.length; i++) {
            if(mySplit[i].equalsIgnoreCase("HP")){
                myToScreen.getMyHero().setMyHPTotal(myToScreen.getMyHero().getMyHPTotal() + 1);
            }else if(mySplit[i].equalsIgnoreCase("Pit")){
                int myRandDamage = myRand.nextInt(20) + 1;
                myToScreen.getMyHero().setMyHitPoint(myToScreen.getMyHero().getMyHitPoints() - myRandDamage);
            }else if(mySplit[i].equalsIgnoreCase("VP")){
                myToScreen.getMyHero().setMyVPTotal(myToScreen.getMyHero().getMyVPTotal() + 1);
            }else if(mySplit[i].equalsIgnoreCase("A")){
                myToScreen.getMyHero().setMyAttackSpeed(myToScreen.getMyHero().getMyAttackSpeed() + 2);
            }else if(mySplit[i].equalsIgnoreCase("E")){
                myToScreen.getMyHero().setMyChangesToBlockOrHeal(myToScreen.getMyHero().getMyChangesToBlockOrHeal() + 0.2);
            }else if(mySplit[i].equalsIgnoreCase("I")){
                myToScreen.getMyHero().setMyMaximumDamage(myToScreen.getMyHero().getMyMaximumDamage() + 20);
            }else if(mySplit[i].equalsIgnoreCase("P")){
                myToScreen.getMyHero().setMyChanceToHit(myToScreen.getMyHero().getMyChanceToHit() + 0.2);
            }

        }

    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String theStatus){
        status = theStatus;
    }
}
