package systemDesign.lowLevelDesign.problems.SnakeLadder;

import java.util.List;

public class Board {

    int size;
    List<Jump> snakes;
    List<Jump> ladders;

    Board(int size, List<Jump> snakes, List<Jump> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getNextPosition(int pos) {
        for (Jump sn : snakes) {
            if (sn.start == pos) return sn.end;
        }
        for (Jump ld : ladders) {
            if (ld.start == pos) return ld.end;
        }
        return pos;
    }

    public int getSize() {
        return size;
    }
}
