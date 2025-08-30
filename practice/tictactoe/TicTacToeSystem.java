package practice.tictactoe;

import practice.tictactoe.entities.Game;
import practice.tictactoe.entities.Player;
import practice.tictactoe.exceptions.InvalidMoveException;
import practice.tictactoe.observer.Scoreboard;

public class TicTacToeSystem {
    private static volatile TicTacToeSystem instance;
    private Game game;
    private final Scoreboard scoreboard;

    private TicTacToeSystem(){
        this.scoreboard = new Scoreboard();
    }

    public static synchronized TicTacToeSystem getInstance(){
        if(instance == null){
            instance = new TicTacToeSystem();
        }
        return instance;
    }

    public void makeMove(Player player, int row, int col) {
        if (game == null) {
            System.out.println("No game in progress. Please create a game first.");
            return;
        }
        try {
            System.out.printf("%s plays at (%d, %d)%n", player.getName(), row, col);
            game.makeMove(player, row, col);
            printBoard();
            System.out.println("Game Status: " + game.getGameState());
            if (game.getWinner() != null) {
                System.out.println("Winner: " + game.getWinner().getName());
            }
        } catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void createGame(Player player1, Player player2){
        this.game = new Game(player1,player2);
        this.game.addObserver(this.scoreboard);
        System.out.println("Game started between X & O");
    }

    public void printBoard(){
        game.getBoard().printBoard();
    }
    public void printScoreBoard(){
        scoreboard.printScores();
    }
}
