package se.cygni.montyhall;

/**
 * This will simulate the Monty Hall game
 */
public class MontyHall {

    private BoxSet boxSet = new BoxSet();
    private int laps = 100000;


    public static void main(String[] args) {
        MontyHall montyHall = new MontyHall();
        montyHall.simulate();
    }

    private void simulate() {

        int winsNoChangeMind = 0;
        int winsChangedMind = 0;
        for (int i = 0; i < laps; i++) {
            if (boxSet.shuffle().pickBox(Box.randomBox()).isWinner()) {
                winsNoChangeMind++;
            }
            if (boxSet.shuffle().pickBox(Box.randomBox()).changeMind().isWinner()) {
                winsChangedMind++;
            }
        }

        System.out.println(String.format("No change of mind, winning %d%%", winsNoChangeMind * 100 / laps));
        System.out.println(String.format("Change of mind, winning %d%%", winsChangedMind * 100 / laps));
    }


}
