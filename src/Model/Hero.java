package Model;

import java.io.Serializable;
import java.sql.SQLException;

abstract public class Hero extends DungeonCharacter implements Serializable {
    public int myHPTotal = 0;
    public int myVPTotal = 0;
    public Hero(String theName) throws SQLException {
        super(theName);
    }
    public int getMyHPTotal(){
        return myHPTotal;
    }
    public int getMyVPTotal(){
        return myVPTotal;
    }
    public void setMyHPTotal(int theTotal){
        myHPTotal = theTotal;
    }
    public void setMyVPTotal(int theTotal){
        myVPTotal = theTotal;
    }
    abstract int specialAttack();
    abstract int specialAttack(int theMin, int theMax);
}
