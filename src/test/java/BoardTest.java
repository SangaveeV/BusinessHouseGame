import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BoardTest {
    @Test
    void getNextPositionAsJailForDiceValue4() {
        List<String> cells = cells();
        Board board = new Board(players(), cells);
        int diceValue = diceOutput().get(0);
        Cell nextCell = board.nextPosition(players().get(0), diceValue);
        assertEquals("J", nextCell.name);
    }

    @Test
    void aPlayerMovesToJailAndAmount150IsDeducted() {
        List<String> cells = cells();
        Board board = new Board(players(), cells);
        int diceValue = diceOutput().get(0);
        board.movePlayer(board.playerList.get(0), diceValue);
        assertEquals(850, board.playerList.get(0).money.amount);
    }

    @Test
    void aPlayerMovesToTreasureAndAmount150IsAdded() {
        List<String> cells = cells();
        Board board = new Board(players(), cells);
        int diceValue = diceOutput().get(7);
        board.movePlayer(board.playerList.get(0), diceValue);
        assertEquals(1200, board.playerList.get(0).money.amount);
    }

    @Test
    void aPlayerMovesToHotelAndAmount200IsDeducted() {
        List<String> cells = cells();
        Board board = new Board(players(), cells);
        int diceValue = diceOutput().get(4);
        board.movePlayer(board.playerList.get(0), diceValue);
        assertEquals(800, board.playerList.get(0).money.amount);
    }

    @Test
    void aPlayerMovesToPreOwnedHotelAndPays50ToOwner() {
        List<String> cells = cells();
        Board board = new Board(players(), cells);
        board.movePlayer(board.playerList.get(0), 5);
        board.movePlayer(board.playerList.get(1), 5);
        assertEquals(950, board.playerList.get(1).money.amount);
    }

    @Test
    void getPlayerAmountForSetOfDiceValues(){
        BusinessGame businessGame=new BusinessGame(2,cells(),diceOutput());
        businessGame.startGame();
        assertEquals(900,businessGame.board.playerList.get(1).money.amount);

    }


    List<String> cells() {
        List<String> cells = new ArrayList<>();
        cells.add("E");
        cells.add("E");
        cells.add("E");
        cells.add("J");
        cells.add("H");
        cells.add("E");
        cells.add("T");
        cells.add("E");
        return cells;
    }

    List<Integer> diceOutput() {
        List<Integer> diceValue = new ArrayList<>();
        diceValue.add(4);
        diceValue.add(3);
        diceValue.add(6);
        diceValue.add(2);
        diceValue.add(5);
        diceValue.add(1);
        diceValue.add(3);
        diceValue.add(7);
        diceValue.add(2);
        return diceValue;
    }

    List<Player> players() {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player(1));
        playersList.add(new Player(2));
        return playersList;
    }
}
