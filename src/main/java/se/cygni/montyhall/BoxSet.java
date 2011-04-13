package se.cygni.montyhall;

/**
 * This represents the three boxes to pick from. This class is immutable, with
 * a fluent interface. i.e. instead of changing values, new instances with changed values are returned.
 *
 */
public class BoxSet {

    private final Box winningBox;
    private final Box pickedBox;


    /**
     * Will set up a new BoxSet with a random winning box and no picked box.
     * The access modifier is package private since it is only intended for test.
     */
    public BoxSet() {
        winningBox = Box.randomBox();
        pickedBox = null;
    }



    /**
     * Copy constructor used for setting the pickedBox
     *
     * @param fromSet the set to copy from
     * @param pickedBox the guess
     */
    private BoxSet(BoxSet fromSet, Box pickedBox) {
        winningBox = fromSet.winningBox;
        this.pickedBox = pickedBox;
    }

    /**
     * Pick which box that contains the prize
     *
     * @param picked the picked box
     * @return a new BoxSet with the picked box
     */
    public BoxSet pickBox(Box picked) {
        return new BoxSet(this, picked);
    }

    /**
     * Check if the picked box is the winning one.
     *
     * @return
     */
    public boolean isWinner() {
        return pickedBox == winningBox;
    }

    /**
     * Shuffle, i.e. put the price in a random box
     *
     * @return  a new Shuffled BoxSet
     */
    public BoxSet shuffle() {
        return new BoxSet();
    }

    /**
     * Change your mind, that is if you picked a winning box, you change to an non winning
     * and vice verse.
     *
     * @return
     */
    public BoxSet changeMind() {
        Box changedBox = isWinner() ? null : winningBox;
        return new BoxSet(this, changedBox);
    }
}
