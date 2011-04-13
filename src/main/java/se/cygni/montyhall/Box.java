package se.cygni.montyhall;


import java.util.Random;

/**
 * This is the Boxes,
 */
public enum Box {
    box1, box2, box3;

    private static Random random = new Random();

    /**
     * Set the initial seed for the random generator
     * @param seed
     */
    public static void setRandomSeed(long seed) {
        Box.random.setSeed(seed);
    }

    /**
     * Yields a random box every time called.
     * @return
     */
    public static Box randomBox() {
        Box[] boxes = Box.values();
        int box = Math.abs(random.nextInt()) % boxes.length;
        return boxes[box];
    }
}
