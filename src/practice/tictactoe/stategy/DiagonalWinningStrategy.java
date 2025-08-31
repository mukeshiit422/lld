package practice.tictactoe.stategy;

import practice.tictactoe.entities.Board;
import practice.tictactoe.entities.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean chekcWinnner(Board board, Player player) {
        //main diagonal
        boolean mainDiagonal = true;
        for(int i = 0; i < board.getSize(); i++){
                if(board.getCell(i,i).getSymbol() != player.getSymbol()){
                    mainDiagonal = false;
                    break;
                }
            }
        if(mainDiagonal ) return true;

        //anti diagonal
        boolean antiDiagonal = true;
        for(int i = 0; i < board.getSize(); i++){
            if(board.getCell(i,board.getSize()-i-1).getSymbol() != player.getSymbol()){
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }
}
