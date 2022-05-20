package ModelTest;
import Model.Dungeon;
import Model.Room;
import org.junit.jupiter.api.Test;
import static Model.Dungeon.*;
import static Model.MovePlayer.move;
import static View.DriverView.mapMaker;
import static org.junit.jupiter.api.Assertions.*;

public class ModelMovePlayerTest {

    @Test
    public void moveTestLeft(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                move("Left");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestRight(){
        Dungeon myDungeon = new Dungeon(15,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                move("Right");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestUp(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                move("Up");
            }, "Out of Bounds");
        }
    }
    @Test
    public void moveTestDown(){
        Dungeon myDungeon = new Dungeon(5,5);
        int count = 100;
        while (count-- > 0) {
            assertDoesNotThrow(() -> {
                move("Down");
            }, "Out of Bounds");
        }
    }
}
