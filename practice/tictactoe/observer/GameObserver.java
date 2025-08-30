package practice.tictactoe.observer;

import practice.tictactoe.entities.Game;

public interface GameObserver {
    void update(Game game);
}
