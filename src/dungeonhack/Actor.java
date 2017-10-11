package dungeonhack;

public class Actor {
    private String _name;       //actor name
    private int _health;        //actor health
    private int _armorClass;    //actor armor class
    private Weapon _weapon;     //actor weapon 
    
    /*
    creates new actor 
    */    
    public Actor(String name, int health, int armorClass, Weapon weapon)
       {
           this._name = name;
           this._health = health;
           this._armorClass = armorClass;
           this._weapon = weapon;
       }
    
    public Weapon weapon(){
        return this._weapon;
    }
    
    public int takeDamage(int amount){
        this._health = this._health - amount;
        return this._health;
    }
    
    public boolean isDead(){
        return this._health <=0;
    }
    
    public int armorClass(){
        return _armorClass;
    }
    
    public int health(){
        return _health;
    }
    
    public String name(){
        return this._name;
    }
}
