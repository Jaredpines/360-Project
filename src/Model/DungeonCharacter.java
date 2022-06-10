package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Locale;
/**
 * DungeonCharacter-creates dungeon character from SQLite data base
 */
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
        if (theStats.length != 6) {
            MINIMUM_HEAL_POINTS = Integer.parseInt(theStats[6]);
            MAXIMUM_HEAL_POINTS = Integer.parseInt(theStats[7]);
        } else {
            MINIMUM_HEAL_POINTS = 0;
            MAXIMUM_HEAL_POINTS = 0;
        }
        myName = theName.substring(0, 1).toUpperCase(Locale.ROOT) + theName.substring(1).toLowerCase(Locale.ROOT);
    }
    /**
     * Getter for hit points
     * @return
     */
    public int getMyHitPoints() {
        return myHitPoint;
    }
    /**
     * Getter for attack speed
     * @return
     */
    public int getMyAttackSpeed() {
        return myAttackSpeed;
    }
    /**
     * Getter for the chance to hit
     * @return
     */
    public double getMyChanceToHit() {
        return myChanceToHit;
    }

    /**
     * Getter for minimum damage
     * @return
     */
    public int getMINIMUM_DAMAGE() {
        return MINIMUM_DAMAGE;
    }
    /**
     * Getter for maximum damage
     * @return
     */
    public int getMyMaximumDamage() {
        return myMaximumDamage;
    }
    /**
     * Getter for changes to block or heal
     * @return
     */
    public double getMyChangesToBlockOrHeal() {
        return myChangesToBlockOrHeal;
    }
    /**
     * Getter for minimum heal points
     * @return
     */
    public int getMINIMUM_HEAL_POINTS() {
        return MINIMUM_HEAL_POINTS;
    }
    /**
     * Getter for maximun heal points
     * @return
     */
    public int getMAXIMUM_HEAL_POINTS() {
        return MAXIMUM_HEAL_POINTS;
    }
    /**
     * Getter to get the name
     * @return
     */
    public String getMyName() {
        return myName;
    }
    /**
     * Detter to set hit points
     * @param theHealth
     */
    public void setMyHitPoint(int theHealth) {
        myHitPoint = theHealth;
    }

    /**
     * Setter for attack speed
     * @param theSpeed
     */
    public void setMyAttackSpeed(int theSpeed) {
        myAttackSpeed = theSpeed;
    }
    /**
     * Setter for changes for block or heal
     * @param theChance
     */
    public void setMyChangesToBlockOrHeal(double theChance) {
        myChangesToBlockOrHeal = theChance;
    }
    /**
     * Setter for maximum damage
     * @param theDamage
     */
    public void setMyMaximumDamage(int theDamage) {
        myMaximumDamage = theDamage;
    }
    /**
     * setter for chance to hit
     * @param theChance
     */
    public void setMyChanceToHit(double theChance) {
        myChanceToHit = theChance;
    }
    /**
     * Setter for the name
     * @param theName
     */
    public void setMyName(String theName) {
        myName = theName;
    }

    abstract public int attack();
}
