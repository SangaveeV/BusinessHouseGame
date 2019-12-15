import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Game {
    public static void main(String[] args){
        String input = "E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E";
        List<String> cells = Arrays.asList(input.split(","));


        String dice = "4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12";
        List<Integer> diceOutput = Stream.of(dice.split(","))
                .map(Integer::parseInt).collect(toList());


        BusinessGame businessGame=new BusinessGame(3,cells,diceOutput);
        businessGame.startGame();

    }
}
