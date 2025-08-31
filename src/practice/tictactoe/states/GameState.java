package practice.tictactoe.states;

import practice.tictactoe.entities.Game;
import practice.tictactoe.entities.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row , int col);
}
