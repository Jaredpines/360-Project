package Model;

import java.io.Serializable;
import java.sql.SQLException;

public abstract class DungeonCharacter implements Serializable {
    private static int myHitPoint;
    private static int myAttackSpeed;
    private static double myChanceToHit;
//    private final int MINIMUM_DAMAGE;
    private static int myMaximumDamage;
    private static int myMinimumDamage;
    private static double myChangesToBlockOrHeal;
    private final int MINIMUM_HEAL_POINTS;
    private final int MAXIMUM_HEAL_POINTS;
    public DungeonCharacter(String theName) throws SQLException {
        Database DB = new Database();
        String[] theStats = DB.getStats(theName).toString().split(" ");
        myHitPoint = Integer.parseInt(theStats[0]);
        myAttackSpeed = Integer.parseInt(theStats[1]);
        myChanceToHit = Double.parseDouble(theStats[2]);
        myMinimumDamage = Integer.parseInt(theStats[3]);
        myMaximumDamage = Integer.parseInt(theStats[4]);
        myChangesToBlockOrHeal = Double.parseDouble(theStats[5]);
        if(theStats.length != 6){
            MINIMUM_HEAL_POINTS = Integer.parseInt(theStats[6]);
            MAXIMUM_HEAL_POINTS = Integer.parseInt(theStats[7]);
        }
        else {
            MINIMUM_HEAL_POINTS = 0;
            MAXIMUM_HEAL_POINTS = 0;
        }
    }
    public static int getMyHitPoint() {
        return myHitPoint;
    }

    public static int getMyAttackSpeed() {
        return myAttackSpeed;
    }

    public static double getMyChanceToHit() {
        return myChanceToHit;
    }

    public int getMyMinimumDamage() {
        return myMinimumDamage;
    }

    public static int getMyMaximumDamage() {
        return myMaximumDamage;
    }

    public static double getMyChangesToBlockOrHeal() {
        return myChangesToBlockOrHeal;
    }

    public int getMINIMUM_HEAL_POINTS() {
        return MINIMUM_HEAL_POINTS;
    }

    public int getMAXIMUM_HEAL_POINTS() {
        return MAXIMUM_HEAL_POINTS;
    }

    public static void setMyHitPoint(int theHealth){
        myHitPoint = theHealth;
    }
    public static void setMyAttackSpeed(int theSpeed){
        myAttackSpeed = theSpeed;
    }
    public static void setMyChangesToBlockOrHeal(double theChance){
        myChangesToBlockOrHeal = theChance;
    }
    public static void setMyMaximumDamage(int theDamage){
        myMaximumDamage = theDamage;
    }
    public static void setMyMinimumDamage(int theDamage){
        myMinimumDamage = theDamage;
    }

    public static void setMyChanceToHit(double theChance){
        myChanceToHit = theChance;
    }
    abstract public int attack(int theMin, int theMax);
}
