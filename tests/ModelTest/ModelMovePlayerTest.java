package ModelTest;
import Model.Dungeon;
import Model.MovePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMovePlayerTest {
    private MovePlayer myMovePlayer = new MovePlayer();
    @Test
    public void moveTestLeft(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Left");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestRight(){
        Dungeon myDungeon = new Dungeon(15,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Right");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestUp(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Up");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestDown(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                myMovePlayer.move("Down");
            }, "Out of Bounds");
        }
    }
}
