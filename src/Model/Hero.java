package Model;

import java.io.Serializable;
import java.sql.SQLException;

abstract public class Hero extends DungeonCharacter implements Serializable {
    public Hero(String theName) throws SQLException {
        super(theName);
    }
    abstract String specialAttack();
}
