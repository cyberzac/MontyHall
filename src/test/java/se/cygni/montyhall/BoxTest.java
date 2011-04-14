package se.cygni.montyhall;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static se.cygni.montyhall.Box.*;

public class BoxTest {

    /**
     * Test that randomBox yields random boxes. With a seed of 0 the sequence
     * will be, box2, box3, box3, box1.
     */
    @Test
    public void randomBox() {
        Box.setRandomSeed(0);
        assertEquals("First box should be box2", box2, Box.randomBox());
        assertEquals("Second box should be box3", box3, Box.randomBox());
        assertEquals("Third box should be box3", box3, Box.randomBox());
        assertEquals("Fourth box should be box1", box1, Box.randomBox());
    }
}
