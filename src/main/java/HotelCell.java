import java.util.HashMap;

public class HotelCell extends Cell {
    int owner = 0;

    public HotelCell(String name) {
        super(name);
    }

    @Override
    public void cellAction(Player player, Board board) {
        if (owner == 0) {
            if (player.money.amount < 200) {
                return;
            }
            owner = player.playerNo;
            player.money.amountDeduction(200);
            player.hotelsOwned += 1;
        } else {
            player.money.amountDeduction(50);
            board.playerList.get(owner - 1).money.amountAddition(50);
        }

    }
}
