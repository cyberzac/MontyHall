package se.cygni.montyhall;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static se.cygni.montyhall.Box.*;

public class BoxSetTest {
    private BoxSet dut;

    /**
     * In this test we use 0 for the RandomSeed, the generated sequence will be:
     * box2, box3, box3... @see BoxTest#randomBox.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Box.setRandomSeed(0);
        dut = new BoxSet(); // The winningBox is now box2
    }

    /**
     * Verify that only one box is the winning box.
     */
    @Test
    public void pickBox() {
        BoxSet pickedBox1 = dut.pickBox(box1);
        assertFalse("Box 1 should not be the winning box", pickedBox1.isWinner());
        BoxSet pickedBox2 = dut.pickBox(box2);
        assertTrue("Box 2 should be the winning box", pickedBox2.isWinner());
        BoxSet pickedBox3 = dut.pickBox(box3);
        assertFalse("Box 3 should not be the winning box", pickedBox3.isWinner());
    }

    /**
     * Verify that shuffle shuffles the winning box
     */
    @Test
    public void shuffle() {
        BoxSet shuffeld = dut.shuffle();  // The winning box is now box3
        BoxSet pickedBox2 = shuffeld.pickBox(box2);
        BoxSet pickedBox1 = shuffeld.pickBox(box1);
        assertFalse("Box 1 should not the winning box", pickedBox1.isWinner());
        assertFalse("Box 2 is still the winning box", pickedBox2.isWinner());
        BoxSet pickedBox3 = shuffeld.pickBox(box3);
        assertTrue("Box 3 should be the winning box", pickedBox3.isWinner());
        BoxSet shuffeld2 = shuffeld.shuffle(); // Winning box is now box3
        assertTrue("Box 3 should be the winning box after a second shuffle", pickedBox3.isWinner());
        BoxSet shuffeld3 = shuffeld2.shuffle(); // Winning box is now box1
        assertTrue("Box 1 should be the winning box after a second shuffle", pickedBox3.isWinner());
    }

    /**
     * Given that the picked box is wrong, changeMind shall change the
     * picked box to the winning box
     */
    @Test
    public void changeMindToWinning() {
        BoxSet pickedBox1 = dut.pickBox(box1);
        BoxSet changed = pickedBox1.changeMind();
        assertTrue(changed.isWinner());
    }

    /**
     * Given that the picked box was the winning, change mind shall change
     * the picked box to the wrong one.
     */
    @Test
    public void changeMindFromWinning() {
        BoxSet pickedWinning = dut.pickBox(box2);
        BoxSet changed = pickedWinning.changeMind();
        assertFalse(changed.isWinner());
    }

}
