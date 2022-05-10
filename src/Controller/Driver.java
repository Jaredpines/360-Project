package Controller;

import Model.Hero;

import java.io.Serializable;
import java.sql.SQLException;

import static View.DriverView.chooseHero;

public class Driver implements Serializable {
    public static void main(String[] args) throws SQLException {
        System.out.println(chooseHero());
    }
    public static StringBuilder heroToScreen(String theName) throws SQLException {
        Hero myHero = new Hero(theName);
        StringBuilder stats = new StringBuilder();
        stats.append("hit points: ").append(myHero.getHIT_POINTS()).append("\n");
        stats.append("attack speed: ").append(myHero.getATTACK_SPEED()).append("\n");
        stats.append("chance to hit: ").append(myHero.getCHANCE_TO_HIT()).append("\n");
        stats.append("minimum damage: ").append(myHero.getMINIMUM_DAMAGE()).append("\n");
        stats.append("maximum damage: ").append(myHero.getMAXIMUM_DAMAGE()).append("\n");
        stats.append("chance to block: ").append(myHero.getCHANCE_TO_BLOCK_OR_HEAL()).append("\n");
        return stats;
    }
}
