package Model;

import java.sql.SQLException;

public class Thief extends Hero{
    public Thief(String theName) throws SQLException {
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
