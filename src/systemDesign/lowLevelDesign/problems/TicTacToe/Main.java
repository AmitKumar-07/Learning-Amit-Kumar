package systemDesign.lowLevelDesign.problems.TicTacToe;

import systemDesign.lowLevelDesign.problems.TicTacToe.Model.Player;
import systemDesign.lowLevelDesign.problems.TicTacToe.Model.Piece;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Player p1 = new Player("Alice", Piece.X);
        Player p2 = new Player("Bob", Piece.O);
//        Player p3 = new Player("Amit", Piece.Z);
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
//        players.add(p3);
        TicTacToeGame game = new TicTacToeGame(players);
        game.startGame();
    }
}
