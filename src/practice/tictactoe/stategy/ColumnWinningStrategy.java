package practice.tictactoe.stategy;

import practice.tictactoe.entities.Board;
import practice.tictactoe.entities.Player;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean chekcWinnner(Board board, Player player) {
        for(int col = 0; col < board.getSize(); col++){
            boolean colWin = true;
            for(int row = 0; row < board.getSize(); row++){
                if(board.getCell(row,col).getSymbol() != player.getSymbol()){
                    colWin = false;
                    break;
                }
            }
            if(colWin) return true;
        }
        return false;
    }
}
