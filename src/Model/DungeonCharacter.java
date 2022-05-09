package Model;

import java.io.Serializable;
import java.sql.SQLException;

public abstract class DungeonCharacter implements Serializable {
    private final int HIT_POINTS;
    private final int ATTACK_SPEED;
    private final double CHANCE_TO_HIT;
    private final int MINIMUM_DAMAGE;
    private final int MAXIMUM_DAMAGE;
    private final double CHANCE_TO_BLOCK_OR_HEAL;
    private final int MINIMUM_HEAL_POINTS;
    private final int MAXIMUM_HEAL_POINTS;
    public DungeonCharacter(String theName) throws SQLException {
        Database DB = new Database();
        String[] theStats = DB.getStats(theName).toString().split(" ");
        HIT_POINTS = Integer.parseInt(theStats[0]);
        ATTACK_SPEED = Integer.parseInt(theStats[1]);
        CHANCE_TO_HIT = Double.parseDouble(theStats[2]);
        MINIMUM_DAMAGE = Integer.parseInt(theStats[3]);
        MAXIMUM_DAMAGE = Integer.parseInt(theStats[4]);
        CHANCE_TO_BLOCK_OR_HEAL = Double.parseDouble(theStats[5]);
        if(theStats.length != 6){
            MINIMUM_HEAL_POINTS = Integer.parseInt(theStats[6]);
            MAXIMUM_HEAL_POINTS = Integer.parseInt(theStats[7]);
        }
        else {
            MINIMUM_HEAL_POINTS = 0;
            MAXIMUM_HEAL_POINTS = 0;
        }
    }
    public int getHIT_POINTS() {
        return HIT_POINTS;
    }

    public int getATTACK_SPEED() {
        return ATTACK_SPEED;
    }

    public double getCHANCE_TO_HIT() {
        return CHANCE_TO_HIT;
    }

    public int getMINIMUM_DAMAGE() {
        return MINIMUM_DAMAGE;
    }

    public int getMAXIMUM_DAMAGE() {
        return MAXIMUM_DAMAGE;
    }

    public double getCHANCE_TO_BLOCK_OR_HEAL() {
        return CHANCE_TO_BLOCK_OR_HEAL;
    }

    public int getMINIMUM_HEAL_POINTS() {
        return MINIMUM_HEAL_POINTS;
    }

    public int getMAXIMUM_HEAL_POINTS() {
        return MAXIMUM_HEAL_POINTS;
    }
}
