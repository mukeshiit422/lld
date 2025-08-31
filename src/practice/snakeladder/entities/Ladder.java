package practice.snakeladder.entities;
public class Ladder extends BoardEntities{

    public Ladder(int start, int end) {
        super(start, end);
        if(start >= end){
            throw new IllegalArgumentException("Ladder start must be low position.");
        }
    }
    
}