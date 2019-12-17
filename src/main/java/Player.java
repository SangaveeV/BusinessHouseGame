import java.util.Objects;

public class Player {
    private int playerNo;
    Money money = new Money(1000);
    int turnsCount = 0;
    int hotelsOwned;

    public Player(int playerNo) {
        this.playerNo = playerNo;
    }

    int rollDice(Dice dice) {
        return dice.diceValue();
    }

    void nextTurn() {
        turnsCount++;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    @Override
    public boolean equals(Object object) {
        Player that = (Player) object;
        if (this.playerNo == that.playerNo)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNo);
    }

}
