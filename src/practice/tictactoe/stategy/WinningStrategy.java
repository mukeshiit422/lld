package practice.tictactoe.stategy;

import practice.tictactoe.entities.Board;
import practice.tictactoe.entities.Player;

public interface WinningStrategy {
    boolean chekcWinnner(Board board, Player player);
}
