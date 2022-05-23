package Model;

import java.sql.SQLException;

public class Priestess extends Hero{
    public Priestess(String theName) throws SQLException {
        super(theName);
    }
    // TODO: Make special attack
    @Override
    String specialAttack() {
        return null;
    }
    // TODO: Make attack
    @Override
    public int attack(int theMin, int theMax) {
        return 0;
    }
}
