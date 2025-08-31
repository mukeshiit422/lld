package practice.tictactoe.states;

import practice.tictactoe.entities.Game;
import practice.tictactoe.entities.Player;
import practice.tictactoe.exceptions.InvalidMoveException;

public class WinningState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is over." + game.getWinner().getName() + " has won.");
    }
}
