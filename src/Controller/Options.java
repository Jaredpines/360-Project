package Controller;
import View.Art;

/**
 * This class contains the starting setting of the Dungeon Adventure game
 */
public class Options {
    private final Art ART = new Art();
    private final Intro INTRO = new Intro();
    private final GameSetup GAME_SETUP = new GameSetup();
    private final static GamePlay GAME_PLAY = new GamePlay();

    /**
     * The choices that a player can make in the beginning of the game
     * @throws Exception type error
     */
    public void DifferentOptions() throws Exception {
        String myChoice = "";
        while (!myChoice.equals("3")) {
            myChoice = INTRO.IntroChoice();
            switch (myChoice) {
                case "1":
                    GAME_SETUP.Setup(ART);
                    GAME_PLAY.Game(ART);
                case "2":
                    System.out.println("This game is pretty simple but in case you have questions here are the instructions");
                    System.out.println("1) Pick what hero you want to pick. You can see specifications of each hero before picking it");
                    System.out.println("2) Pick what size of the dungeon you want to have");
                    System.out.println("3) Once you enter size of the dungeon you will see the entrance room and number of health " +
                            "potions and vision potions you have");
                    System.out.println("4) Pick where do you want to go (Left, Right, Up, Down) ");
                    System.out.println("5) Once you pick where to go you will be moved to that room");
                    System.out.println("6) There is a possibility you will find a monster there. If you do be brave and fight!");
                    System.out.println("You also have possibility to use special attack and heal (if you have heal points)");
                    System.out.println("Repeat and have fun!");
                case "3":
                    System.out.println(ART.ExitGameArt());
                    System.out.println("It was nice having you here!");
            }
        }
    }
}
