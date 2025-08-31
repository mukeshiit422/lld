package practice.tictactoe.observer;

import practice.tictactoe.entities.Game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Scoreboard implements GameObserver {
    private final Map<String,Integer> scores;
    public Scoreboard(){
      this.scores = new ConcurrentHashMap<>();
    }
    @Override
    public void update(Game game) {
        if(game.getWinner() != null){
            String winner = game.getWinner().getName();
            scores.put(winner,scores.getOrDefault(winner, 0) + 1);
            System.out.println("");
        }
    }

    public void printScores() {
        System.out.println("\n--- Overall Scoreboard ---");
        if (scores.isEmpty()) {
            System.out.println("No games with a winner have been played yet.");
            return;
        }
        scores.forEach((playerName, score) ->
                System.out.printf("Player: %-10s | Wins: %d%n", playerName, score)
        );
        System.out.println("--------------------------\n");
    }

}
