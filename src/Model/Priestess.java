package Model;

import java.sql.SQLException;
import java.util.Random;

public class Priestess extends Hero{
    public Priestess(String theName) throws SQLException {
        super(theName);
        setMyHitPoint(75);
        setMyAttackSpeed(5);
        setMyChanceToHit(0.7);
        setMyChangesToBlockOrHeal(0.3);
        setMyMaximumDamage(45);
        setMyMinimumDamage(25);
    }

    String specialAttack() {
        return "Heal";
    }

    // heal from 30 to 50 points
    public int makeSpecialAttack() {
        Random rand = new Random();
        return rand.nextInt(50 - 30 + 1) + 30;
    }


    @Override
    public int attack(int theMin, int theMax) {
//        Random rand = new Random();
//        int damage = rand.nextInt(theMax - theMin + 1) + theMin;
//        if (Math.random() * 100 < (1 - this.getMyChanceToHit()) * 100 ) {
//            damage = 0;
//        }
//        return damage;
        return 0;
    }

    @Override
    public double blockAttack() {
        return 0.0;
    }
}
