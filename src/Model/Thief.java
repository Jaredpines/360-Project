package Model;

import java.sql.SQLException;
import java.util.Random;

public class Thief extends Hero{
    public Thief(String theName) throws SQLException {
        super(theName);
        setMyHitPoint(75);
        setMyAttackSpeed(6);
        setMyChanceToHit(0.8);
        setMyChangesToBlockOrHeal(0.4);
        setMyMaximumDamage(40);
        setMyMinimumDamage(20);
    }

    String specialAttack() {
        return "Surprise Attack";
    }

    public void makeSpecialAttack() {
        if (Math.random() * 100 < 40) {
            attack(getMyMinimumDamage(), getMyMaximumDamage());
            attack(getMyMinimumDamage(), getMyMaximumDamage());
        }
        else if (Math.random() * 100 < 20) {
            // do nothing
        } else {
            attack(getMyMinimumDamage(), getMyMaximumDamage());

        }
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
