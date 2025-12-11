package systemDesign.lowLevelDesign.problems.TicTacToe;

import systemDesign.lowLevelDesign.problems.TicTacToe.Model.*;
import java.util.*;

public class TicTacToeGame {

    private final Deque<Player> players;
    private final Board board;

    public TicTacToeGame(List<Player> playersList) {
        //creating players
        players = new ArrayDeque<>();
        players.addAll(playersList);

        //initializeBoard
        board = new Board(3);
    }

    public void startGame(){

        for(int i=0; i<players.size(); i++) {
            Player player = players.removeFirst();
            System.out.println("Player1 Name is "+ player.getName() +" and Symbol is " + player.getPiece());
            players.addLast(player);
        }
        System.out.println("Let's start the game");
        System.out.println("current position");
        board.printBoard();
        Scanner sc = new Scanner(System.in);
        while(true){
            Player player = players.removeFirst();
            System.out.print(player.name +", Enter row and column (0-based): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean isGameEnd = play(row, col, player);
            if(isGameEnd) {
                sc.close();
                break;
            }
        }
    }


    public boolean play(int row, int col, Player player) {

        if (!board.isValidMove(row, col)) {
            System.out.println("Invalid move. Try again.");
            players.addFirst(player);
            return false;
        }

        board.makeMove(row, col, player.getPiece());
        board.printBoard();

        if (board.checkWinner(row, col, player.getPiece())) {
            System.out.println(player.getName() + " wins!");
            return true;
        }

        if (board.isFull()) {
            System.out.println("It's a draw!");
            return true;
        }

        players.addLast(player);// switch turns
        return false;
    }


}
