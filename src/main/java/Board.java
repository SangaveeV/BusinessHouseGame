import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    List<Player> playerList;
    HashMap<Player, Integer> playerPosition;
    List<Cell> cellList;

    public Board(List<Player> playerList, List<String> cells) {
        this.playerList = playerList;
        playerPosition = new HashMap<>();
        cellList = new ArrayList<>();
        initializeCells(cells);
        playerPositions();
    }

    void initializeCells(List<String> cell) {
        for (String str : cell) {
            if (str.equals("J")) {
                cellList.add(new JailCell("J"));
            } else if (str.equals("T")) {
                cellList.add(new TreasureCell("T"));
            } else if (str.equals("H")) {
                cellList.add(new HotelCell("H"));
            } else {
                cellList.add(new EmptyCell("E"));
            }
        }
    }

    void movePlayer(Player player, int diceValue) {
        Cell nextCell = nextPosition(player, diceValue);
        nextCell.cellAction(player, this);
        player.nextTurn();
    }

    Cell nextPosition(Player player, int diceValue) {
        int index = playerPosition.get(player) + diceValue;
        index = index % cellList.size();
        playerPosition.replace(player, index);
        return cellList.get(index);
    }

    private void playerPositions() {
        for (Player player : playerList) {
            playerPosition.put(player, -1);
        }
    }
}
