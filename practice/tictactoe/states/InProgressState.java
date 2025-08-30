package practice.tictactoe.states;

import practice.tictactoe.entities.Game;
import practice.tictactoe.entities.Player;
import practice.tictactoe.enums.GameStatus;
import practice.tictactoe.enums.Symbol;
import practice.tictactoe.exceptions.InvalidMoveException;

public class InProgressState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if(game.getcurrentPlayer() != player){
            throw new InvalidMoveException("Not your turn");
        }

        game.getBoard().placeSymbol(row,col,player.getSymbol());

        if(game.checkWinner(player)){
            game.setWinner(player);
            game.setGameState(new WinningState());
            game.setGameStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
        }else if(game.getBoard().isFull()){
            game.setGameStatus(GameStatus.DRAW);
            game.setGameState(new DrawState());
        }else{
            game.switchPlayer();
        }
    }
}
