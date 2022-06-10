package Model;

import Controller.ToScreen;

import java.io.Serializable;
import java.util.Random;

/**
 * The class that creates room for the dungeon
 */
public class Room implements Serializable {
    private String status = "";
    private final ToScreen TO_SCREEN = new ToScreen();

    /**
     * Constructor of Room class for entrance and exit
     * @param entExi 0 or 1 indicates entrance or exit
     */
    public Room(int entExi) {
        if (entExi == 0) {
            this.status = "entrance";
        } else if (entExi == 1) {
            this.status = "exit";
        } else {
            System.out.println("Hey dummy you coded this wrong.");
        }
    }

    /**
     * Constructor of Room class for the pillar items
     * @param theItems a string indicates which item it is
     */
    public Room(final String theItems) {
        switch (theItems) {
            case "pillarA" -> this.status = "A";
            case "pillarE" -> this.status = "E";
            case "pillarI" -> this.status = "I";
            case "pillarP" -> this.status = "P";
        }
        if (theItems.equals("items")) {
            Random myRand = new Random();
            int myHP = myRand.nextInt(101);
            int myVP = myRand.nextInt(101);
            int myPit = myRand.nextInt(101);
            boolean existenceCheck1 = false;
            boolean existenceCheck2 = false;
            if (myHP < 10) {
                this.status += "HP";
                existenceCheck1 = true;
            }
            if (myVP < 10) {
                if (existenceCheck1) {
                    this.status += "-";
                }
                this.status += "VP";
                existenceCheck2 = true;

            }

            if (myPit < 10) {
                if (existenceCheck2 || existenceCheck1) {
                    this.status += "-";
                }
                this.status += "Pit";
            }
            if (this.status.equals("")) {
                this.status = "empty";
            }
        }
        if (theItems.equals("player")) {
            this.status = "player";
        }

    }

    /**
     * Picking up an item from each room. Identifying which item it is when there is an item in
     * the room, and increase the hero's corresponding item count
     * @param theStatus a string represents the item
     */
    public void statusEffect(String theStatus) {
        String[] mySplit = theStatus.split("-");
        Random myRand = new Random();
        for (String s : mySplit) {
            if (s.equalsIgnoreCase("HP")) {
                TO_SCREEN.getMyHero().setMyHPTotal(TO_SCREEN.getMyHero().getMyHPTotal() + 1);
            } else if (s.equalsIgnoreCase("Pit")) {
                int myRandDamage = myRand.nextInt(20) + 1;
                TO_SCREEN.getMyHero().setMyHitPoint(TO_SCREEN.getMyHero().getMyHitPoints() - myRandDamage);
            } else if (s.equalsIgnoreCase("VP")) {
                TO_SCREEN.getMyHero().setMyVPTotal(TO_SCREEN.getMyHero().getMyVPTotal() + 1);
            } else if (s.equalsIgnoreCase("A")) {
                TO_SCREEN.getMyHero().setMyAttackSpeed(TO_SCREEN.getMyHero().getMyAttackSpeed() + 2);
            } else if (s.equalsIgnoreCase("E")) {
                TO_SCREEN.getMyHero().setMyChangesToBlockOrHeal(TO_SCREEN.getMyHero().getMyChangesToBlockOrHeal() + 0.2);
            } else if (s.equalsIgnoreCase("I")) {
                TO_SCREEN.getMyHero().setMyMaximumDamage(TO_SCREEN.getMyHero().getMyMaximumDamage() + 20);
            } else if (s.equalsIgnoreCase("P")) {
                TO_SCREEN.getMyHero().setMyChanceToHit(TO_SCREEN.getMyHero().getMyChanceToHit() + 0.2);
            }

        }

    }

    /**
     * Getter for status
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for status
     * @param theStatus a string represents the status
     */
    public void setStatus(String theStatus) {
        status = theStatus;
    }
}
