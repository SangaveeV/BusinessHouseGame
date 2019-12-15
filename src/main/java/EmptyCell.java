public class EmptyCell extends Cell {
    public EmptyCell(String name) {
        super(name);
    }

    @Override
    public void cellAction(Player player,Board board) {
        return;
    }
}
