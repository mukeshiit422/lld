package practice.snakeladder.entities;
public class Snake extends BoardEntities{

    public Snake(int start, int end) {
        super(start, end);
        if(start <= end){
            throw new IllegalArgumentException("Snake head must be at higher position");
        }
    }
    
}