package systemDesign.lowLevelDesign.problems.SnakeLadder;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob")
        );

        Game game = new Game(players, 10);
        game.start();
    }
}
