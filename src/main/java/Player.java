import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Player {
    int playerNo;
    Money money = new Money(1000);
    int turnsCount = 0;
    List<Integer> hotelsOwned;

    public Player(int playerNo) {
        this.playerNo = playerNo;
        hotelsOwned=new ArrayList<>();
    }

    int rollDice(Dice dice) {
        return dice.diceValue();
    }

    void nextTurn() {
        turnsCount++;
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
