package practice.snakeladder;

import java.util.Arrays;
import java.util.List;
import practice.snakeladder.entities.BoardEntities;
import practice.snakeladder.entities.Dice;
import practice.snakeladder.entities.Game;
import practice.snakeladder.entities.Ladder;
import practice.snakeladder.entities.Snake;

public class SnakeLadderDemo{
    public static void main(String[] args) {
        List<BoardEntities> boardentities = List.of(
            new Snake(17,7),new Snake(54,34),new Snake(62,19),new Snake(98,79),
            new Ladder(3,38), new Ladder(24,33), new Ladder(42,93), new Ladder(72,84)
        );

        List<String> players = Arrays.asList("Alice","Bob","Charlie");

        Game game = new Game.Builder()
                  .setBoard(100, boardentities)
                  .setPlayer(players)
                  .setDice(new Dice(1,6))
                  .Build();
        game.play();
    }
}