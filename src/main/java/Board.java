import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    List<Player> playerList;
    HashMap<Player, Integer> playerPosition;
    List<Cell> cellList;
    int currentPlayer;
    int totalPlayers;

    public Board(int totalPlayers, List<String> cells) {
        this.totalPlayers = totalPlayers;
        playerList = new ArrayList<>();
        playerPosition = new HashMap<>();
        cellList = new ArrayList<>();
        players(totalPlayers);
        initializeCells(cells);
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

    Player currentPlayer() {
        return playerList.get(currentPlayer);
    }

    void nextPlayer() {
        currentPlayer += 1;
        if (currentPlayer >= playerList.size()) {
            currentPlayer = 0;
        }
    }


    void players(int totalPlayers) {
        for (int i = 1; i <= totalPlayers; i++) {
            playerList.add(new Player(i));
            playerPosition.put(new Player(i), -1);
        }
    }

}
