public abstract class Cell {
    String name;
    public Cell(String name){
        this.name=name;
    }

    public abstract void cellAction(Player player,Board board);
}
