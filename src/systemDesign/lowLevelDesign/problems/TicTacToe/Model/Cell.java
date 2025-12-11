package systemDesign.lowLevelDesign.problems.TicTacToe.Model;

public class Cell {

    private Piece piece;

    public Cell() {
        this.piece = null;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
