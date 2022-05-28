package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Locale;

public abstract class DungeonCharacter implements Serializable {
    private String myName;
    private int myHitPoint;
    private int myAttackSpeed;
    private double myChanceToHit;
    private final int MINIMUM_DAMAGE;
    private int myMaximumDamage;
    private double myChangesToBlockOrHeal;
    private final int MINIMUM_HEAL_POINTS;
    private final int MAXIMUM_HEAL_POINTS;
    public DungeonCharacter(String theName) throws SQLException {
        Database DB = new Database();
        String[] theStats = DB.getStats(theName).toString().split(" ");
        myHitPoint = Integer.parseInt(theStats[0]);
        myAttackSpeed = Integer.parseInt(theStats[1]);
        myChanceToHit = Double.parseDouble(theStats[2]);
        MINIMUM_DAMAGE = Integer.parseInt(theStats[3]);
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
        myName = theName.substring(0,1).toUpperCase(Locale.ROOT) + theName.substring(1).toLowerCase(Locale.ROOT);
    }
    public int getMyHitPoints() {
        return myHitPoint;
    }

    public int getMyAttackSpeed() {
        return myAttackSpeed;
    }

    public double getMyChanceToHit() {
        return myChanceToHit;
    }

    public int getMINIMUM_DAMAGE() {
        return MINIMUM_DAMAGE;
    }

    public int getMyMaximumDamage() {
        return myMaximumDamage;
    }

    public double getMyChangesToBlockOrHeal() {
        return myChangesToBlockOrHeal;
    }

    public int getMINIMUM_HEAL_POINTS() {
        return MINIMUM_HEAL_POINTS;
    }

    public int getMAXIMUM_HEAL_POINTS() {
        return MAXIMUM_HEAL_POINTS;
    }
    public String getMyName(){
        return myName;
    }
    public void setMyHitPoint(int theHealth){
        myHitPoint = theHealth;
    }
    public void setMyAttackSpeed(int theSpeed){
        myAttackSpeed = theSpeed;
    }
    public void setMyChangesToBlockOrHeal(double theChance){
        myChangesToBlockOrHeal = theChance;
    }
    public void setMyMaximumDamage(int theDamage){
        myMaximumDamage = theDamage;
    }
    public void setMyChanceToHit(double theChance){
        myChanceToHit = theChance;
    }
    public void setMyName(String theName){
        myName = theName;
    }
    abstract public int attack();
}
