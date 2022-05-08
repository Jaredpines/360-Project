package Model;

import java.sql.SQLException;

public class Hero {
    private final int hitPoints;
    private final int attackSpeed;
    private final double chanceToHit;
    private final int minimumDamage;
    private final int maximumDamage;
    private final double chanceToBlock;
    public Hero(String theName) throws SQLException {
        Database DB = new Database();
        String[] theStats = DB.getStats(theName).toString().split(" ");
        hitPoints = Integer.parseInt(theStats[0]);
        attackSpeed = Integer.parseInt(theStats[1]);
        chanceToHit = Double.parseDouble(theStats[2]);
        minimumDamage = Integer.parseInt(theStats[3]);
        maximumDamage = Integer.parseInt(theStats[4]);
        chanceToBlock = Double.parseDouble(theStats[5]);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public double getChanceToHit() {
        return chanceToHit;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public double getChanceToBlock() {
        return chanceToBlock;
    }
}
