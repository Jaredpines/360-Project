package Model;

import java.io.Serializable;
import java.sql.SQLException;

abstract public class Hero extends DungeonCharacter implements Serializable {
    public static int myHPTotal = 0;
    public static int myVPTotal = 0;
    public Hero(String theName) throws SQLException {
        super(theName);
    }
    public static int getMyHPTotal(){
        return myHPTotal;
    }
    public static int getMyVPTotal(){
        return myVPTotal;
    }
    public static void setMyHPTotal(int theTotal){
        myHPTotal = theTotal;
    }
    public static void setMyVPTotal(int theTotal){
        myVPTotal = theTotal;
    }
    abstract String specialAttack();
}
