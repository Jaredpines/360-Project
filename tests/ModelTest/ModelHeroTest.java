package ModelTest;
import Model.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelHeroTest {
    @Test
    void canCreateHeroTest(){
        Hero myHero = new Hero("Warrior");
        Boolean isItAHero = false;
        isItAHero = myHero instanceof Hero;
        assertEquals(true, isItAHero);
    }
}
