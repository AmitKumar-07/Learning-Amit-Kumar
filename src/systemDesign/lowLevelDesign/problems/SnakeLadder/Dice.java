package systemDesign.lowLevelDesign.problems.SnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int min = 1;
    int max = 6;

    public int rollDice(){

        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
}
