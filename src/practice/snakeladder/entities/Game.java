
package practice.snakeladder.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import practice.snakeladder.enums.GameStatus;

public class Game{
    private final Dice  dice;
    private final Board board;
    private Player winner;
    private final Queue<Player> players;
    private GameStatus status;

    public Game(Builder builder) {
        this.dice = builder.dice;
        this.board = builder.board;
        this.players = new LinkedList<>(builder.players);
        this.status = GameStatus.NOT_STARTED;
    }

    public void play(){
        if(players.size() < 2){
            System.out.println("Cannot start game. At least 2 players required");
            return;
        }

        this.status = GameStatus.IN_PROGRESS;
        System.out.println("Game Started");

        while(status == GameStatus.IN_PROGRESS){
            Player currentPlayer = players.poll();
            takeTurn(currentPlayer);

            if(status == GameStatus.IN_PROGRESS){
                players.add(currentPlayer);
            }
            
        }

        System.out.println("Game Finished");
        if(winner != null){
            System.out.printf("Winner is %s\n",winner.getName());
        }

    }

    private void takeTurn(Player player){
        int roll = dice.roll();
        System.out.printf("\n%s's turns. Rolled at %d.\n",player.getName(),roll);

        int nextPosition = player.getPosition() + roll;
        
        if(nextPosition > board.getSize()){
            System.out.printf("Oops, %s needs to land exactly at %d. Turn skipped. \n",player.getName(),board.getSize());
            return;
        }

        if(nextPosition == board.getSize()){
            player.setPosition(nextPosition);
            this.winner = player;
            this.status = GameStatus.FINISHED;
            System.out.printf("Hooray!, %s reached the final square %d and won!\n",player.getName(),board.getSize());
            return;
        }

        int finalPositions = board.finalPositions(nextPosition);
        if(finalPositions > nextPosition){
            System.out.printf("Wow!, %s found ladder at %d and climbed to %d. \n",player.getName(),nextPosition,finalPositions);
        } else if (finalPositions < nextPosition) {
            System.out.printf("Oh no!, %s found snake at %d and slide down to %d. \n",player.getName(),nextPosition,finalPositions);
        }else{
             System.out.printf("%s moved from %d to %d. \n",player.getName(),nextPosition,finalPositions);
        }

        player.setPosition(finalPositions);

        if(roll == 6){
            System.out.printf("%s got 6 and gets another turn. \n",player.getName());
            takeTurn(player);
        }
    }

    public static class Builder{
        private Board board;
        private Queue<Player> players;
        private Dice dice;

        public Builder setBoard(int size, List<BoardEntities> entitieses){
            this.board = new Board(size,entitieses);
            return this;
        }

        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }

        public Builder setPlayer(List<String> playerNames){
           this.players = new LinkedList<>();
           for(String playerName : playerNames){
               players.add(new Player(playerName));
           }
           return this;
        }


        public Game Build(){
            if(board == null || players == null || dice == null){
                throw new IllegalStateException("Board,Players or Dice must be set");
            }
            return new Game(this);
        }

    }
}