import java.util.*;

public class BusinessGame {
    List<Player> playerList;
    Board board;
    Dice dice;
    int totalPlayers;

    public BusinessGame(int totalPlayers, List<String> cells, List<Integer> diceOutputs) {
        this.totalPlayers = totalPlayers;
        playerList = new ArrayList<>();
        players(totalPlayers);
        this.board = new Board(playerList, cells);
        this.dice = new Dice(diceOutputs);
    }

    void startGame() {
        while (playerHasChance() && dice.diceOutput.size() > 0) {
            int diceValue = board.currentPlayer().rollDice(dice);
            board.movePlayer(board.currentPlayer(), diceValue);
            nextPlayer();
        }
        displayPlayersAmount();
    }

    private void displayPlayersAmount() {
        for (Player player : board.playerList) {
            player.money.amount = player.money.amount + (player.hotelsOwned * 200);
        }
        Collections.sort(playerList, Collections.reverseOrder((player1, player2) ->
                (int) (player1.money.amount - player2.money.amount)));
        playerList.stream().forEach(player ->
                System.out.println("player " + player.getPlayerNo() + ": " + player.money.amount));
    }

    boolean playerHasChance() {
        for (Player player : board.playerList) {
            if (player.turnsCount > 10) {
                return false;
            }
        }
        return true;
    }

    void players(int totalPlayers) {
        for (int i = 1; i <= totalPlayers; i++) {
            playerList.add(new Player(i));
        }
    }

    void nextPlayer() {
        board.currentPlayer += 1;
        if (board.currentPlayer >= playerList.size()) {
            board.currentPlayer = 0;
        }
    }
}
