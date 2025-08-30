package practice.tictactoe.observer;

import practice.tictactoe.entities.Game;

import java.util.ArrayList;
import java.util.List;

abstract public class GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver gameObserver){
        observers.add(gameObserver);
    }

    public void removeObserver(GameObserver gameObserver){
        observers.remove(gameObserver);
    }

    public void notifyObserver(){
        for(GameObserver gameObserver : observers){
            gameObserver.update((Game) this);
        }
    }

}
