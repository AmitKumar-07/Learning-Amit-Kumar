package systemDesign.lowLevelDesign.problems.SnakeLadder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> players;

    public Game(List<Player> players, int size){

        this.players = new ArrayDeque<>(players);
        initializeGame(size);
    }

    private void initializeGame(int size) {
        List<Jump> snakes = Arrays.asList(
                new Jump(99, 21),
                new Jump(56, 15),
                new Jump(47, 9),
                new Jump(85, 46),
                new Jump(35, 5),
                new Jump(70, 42)
        );
        List<Jump> ladders = Arrays.asList(
                new Jump(2, 38),
                new Jump(8, 31),
                new Jump(28, 84),
                new Jump(71, 91)
        );
        board = new Board(size, snakes, ladders);
        dice = new Dice();
    }

    public void start() {
        int finalCell = board.getSize() * board.getSize();
        while (true) {
            Player p = players.poll();

            int roll = dice.rollDice();
            System.out.println(p.getName() + " rolls " + roll);

            int next = p.getCurrentPosition() + roll;

            if (next > finalCell) {
                System.out.println("Cannot move, stays at " + p.getCurrentPosition());
                players.offer(p);
                continue;
            }

            int jumpPos = board.getNextPosition(next);
            if (jumpPos != next) {
                if (jumpPos > next)
                    System.out.println("Ladder! Climb from " + next + " to " + jumpPos);
                else
                    System.out.println("Snake! Bite from " + next + " to " + jumpPos);
            }

            p.setCurrentPosition(jumpPos);
            System.out.println(p.getName() + " moves to " + jumpPos);

            if (jumpPos == finalCell) {
                System.out.println(p.getName() + " wins the game!");
                break;
            }

            players.offer(p);
        }
    }
}
