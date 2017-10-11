package dungeonhack;

import java.util.Random;

public class Die {
    
    private int sides;
    private int value;
    private Random generator;
    
    public Die(int sides){
        this.sides = sides;
        this.generator = new Random ();
        this.roll();
    }
    public Die(int sides, int seed){
        this.sides = sides;
        this.generator = new Random(seed);
    }
    public int roll() {
        value = generator.nextInt(sides) + 1;
        return value;
    }
    public int rollnm(){
        value = generator.nextInt(sides);
        return value;
    }
    public int getSides(){
        return this.sides;
    }
   
}
