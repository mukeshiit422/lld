package practice.snakeladder.entities;
abstract public class BoardEntities{
    private int start;
    private int end;

    public BoardEntities(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }
}