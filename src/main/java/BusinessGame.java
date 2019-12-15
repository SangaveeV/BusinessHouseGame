import java.util.List;

public class BusinessGame {
    Player player;
    Board board;
    Dice dice;
    int totalPlayers;

    public BusinessGame(int totalPlayers, List<String> cells, List<Integer> diceOutputs){
        this.totalPlayers=totalPlayers;
        this.board=new Board(totalPlayers,cells);
        this.dice=new Dice(diceOutputs);
    }

    void startGame(){
        while(playerHasChance() && dice.diceOutput.size()>0){
            int diceValue=board.currentPlayer().rollDice(dice);
            board.movePlayer(board.currentPlayer(),diceValue);
            board.nextPlayer();
        }
        displayPlayersAmount();

    }

    private void displayPlayersAmount() {
        for (Player player :board.playerList) {
            double amount=player.money.amount + (player.hotelsOwned.size() *200);
            System.out.println("Player "+player.playerNo+": " +amount);
        }
    }

    boolean playerHasChance(){
        for (Player player :board.playerList) {
            if(player.turnsCount>10){
                return false;
            }
        }
        return true;
    }
}
