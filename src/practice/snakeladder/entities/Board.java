package practice.snakeladder.entities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board{
    private final int size;
    private final Map<Integer, Integer> snakeLadders;

    public Board(int size, List<BoardEntities> entities) {
        this.size = size;
        this.snakeLadders = new HashMap<>();

        for(BoardEntities boardEntity : entities){
            snakeLadders.put(boardEntity.getStart(), boardEntity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int finalPositions(int position){
        return snakeLadders.getOrDefault(position, position);
    }
}