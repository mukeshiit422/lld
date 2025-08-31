package practice.tictactoe.entities;

import java.util.List;
import practice.tictactoe.enums.GameStatus;
import practice.tictactoe.observer.GameSubject;
import practice.tictactoe.stategy.ColumnWinningStrategy;
import practice.tictactoe.stategy.DiagonalWinningStrategy;
import practice.tictactoe.stategy.RowWinningStrategy;
import practice.tictactoe.stategy.WinningStrategy;
import practice.tictactoe.states.GameState;
import practice.tictactoe.states.InProgressState;

public class Game extends GameSubject {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player winner;
    private GameState gameState;
    private GameStatus gameStatus;
    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2){
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; //player1 starts
        this.gameState = new InProgressState();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }

    public void makeMove(Player player, int row, int col){
        gameState.handleMove(this,player,row,col);
    }

    public boolean checkWinner(Player player){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.chekcWinnner(board,player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1 ;
    }

    public Board getBoard() {
        return board;
    }

    public Player getcurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner){
        this.winner = winner;

    }

    public GameState getGameState() {
        return gameState;
    }
    

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameStatus getGameStatus(){
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
        if(gameStatus != GameStatus.IN_PROGRESS){
            notifyObserver();
        }
    }
}
