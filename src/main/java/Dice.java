import java.util.List;

public class Dice {
    List<Integer> diceOutput;

    public Dice(List<Integer> diceOutput) {
        this.diceOutput = diceOutput;
    }

    int diceValue() {
        if (diceOutput.size() > 0) {
            int diceValue = diceOutput.get(0);
            diceOutput.remove(0);
            return diceValue;
        }
        return 0;
    }
}
