package systemDesign.lowLevelDesign.problems.TicTacToe.Model;

public class Board {

    private final int size;
    private final Cell[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell();
    }

    public void printBoard() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                Piece s = cell.getPiece();
                System.out.print(s == null ? "." : s);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size && grid[row][col].isEmpty();
    }

    public void makeMove(int row, int col, Piece piece) {
        grid[row][col].setPiece(piece);
    }

    public boolean checkWinner(int row, int col, Piece piece) {
        // Row
        boolean win = true;
        for (int j = 0; j < size; j++) {
            if(grid[row][j].getPiece() != piece) {
                win = false;
                break;
            }
        }
        if(win) {
            return true;
        }

        // Column
        win = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][col].getPiece() != piece) {
                win = false;
                break;
            }
        }
        if (win) {
            return true;
        }

        // Diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][i].getPiece() != piece) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        // Anti-diagonal
        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][size - 1 - i].getPiece() != piece) {
                    win = false;
                    break;
                }
            }
            return win; // if(win) return true;
        }

        return false;
    }

    public boolean isFull() {
        for (Cell[] row : grid)
            for (Cell cell : row)
                if (cell.isEmpty()) return false;
        return true;
    }
}
