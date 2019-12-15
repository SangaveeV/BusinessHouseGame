public class JailCell extends Cell {

    public JailCell(String name) {
        super(name);
    }

    @Override
    public void cellAction(Player player,Board board) {
        player.money.amountDeduction(150);
    }
}
