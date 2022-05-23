package Model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Random;

public class Hero extends DungeonCharacter implements Serializable {
    public Hero(String theName) throws SQLException {
        super(theName);
    }

    @Override
    public int attack(int theMin, int theMax) {
       return 0;
    }

    public double blockAttack() {
        return 0.0;
    }
}
