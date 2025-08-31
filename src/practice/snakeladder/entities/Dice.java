package practice.snakeladder.entities;
public class Dice{
    private final int  minValue;
    private final int maxValue;

    public Dice(int minValue, int maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public int roll(){
        return (int)(Math.random() * (maxValue - minValue + 1) + minValue);
    }
}