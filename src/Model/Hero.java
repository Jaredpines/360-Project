package Model;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * An abstract class extended from DungeonCharacter to create hero
 */
abstract public class Hero extends DungeonCharacter implements Serializable {
    public int myHPTotal = 0;
    public int myVPTotal = 0;

    /**
     * Constructor of Hero class
     * @param theName Hero's name
     * @throws SQLException database exception
     */
    public Hero(String theName) throws SQLException {
        super(theName);
    }

    /**
     * Getter for Healing potion
     * @return healing points
     */
    public int getMyHPTotal() {
        return myHPTotal;
    }

    /**
     * Getter for Vision potion
     * @return vision points
     */
    public int getMyVPTotal() {
        return myVPTotal;
    }

    /**
     * Setter for Healing potion
     * @param theTotal
     */
    public void setMyHPTotal(int theTotal) {
        myHPTotal = theTotal;
    }

    /**
     * Setter for vision potion
     * @param theTotal
     */
    public void setMyVPTotal(int theTotal) {
        myVPTotal = theTotal;
    }

    /**
     * Abstract attack method
     * @return damage amount
     */
    public abstract int attack();

    /**
     * Abstract specialAttack method
     * @return damage amount
     */
    public abstract int specialAttack();
}
