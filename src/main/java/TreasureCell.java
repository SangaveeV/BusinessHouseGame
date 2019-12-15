public class TreasureCell extends Cell {
    public TreasureCell(String name) {
        super(name);
    }

    @Override
    public void cellAction(Player player,Board board) {
        player.money.amountAddition(200);
    }
}
