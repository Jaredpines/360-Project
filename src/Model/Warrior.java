package Model;

import java.sql.SQLException;
import java.util.Random;

public class Warrior extends Hero{
    public Warrior(String theName) throws SQLException {
        super(theName);
        setMyHitPoint(125);
        setMyAttackSpeed(4);
        setMyChanceToHit(0.8);
        setMyChangesToBlockOrHeal(0.2);
        setMyMaximumDamage(60);
        setMyMinimumDamage(35);
    }

    String specialAttack() {
        return "Crushing Blow";
    }

    public void makeSpecialAttack() {
        attack(75, 175);
    }

    @Override
    public int attack(int theMin, int theMax) {
//        Random rand = new Random();
//        int damage = rand.nextInt(theMax - theMin + 1) + theMin;
//        if (theMin == 75) {
//            if (Math.random() * 100 < 60 ) {
//                damage = 0;
//            }
//        } else {
//            if (Math.random() * 100 < (1 - this.getMyChanceToHit()) * 100 ) {
//            damage = 0;
//            }
//        }
//        return damage;
        return 0;
    }

    @Override
    public double blockAttack() {
        return 0.0;
    }
}
