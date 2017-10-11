package dungeonhack;

public class Weapon {
    
    private String _name;   //name of weapon
    private String _action; //"slashes, stabs etc"
    private int _maxDamage; //maximum damage of weapon
    private int _critDamage;//critical damage
    private Die _die;       //for calling Die
    
    public Weapon(String name, String action, int maxDamage)
    {
        this._name = name;
        this._action = action;
        this._maxDamage = maxDamage;
        this._die = new Die(_maxDamage);
    }
    
    public int maxDamage(){
        return this._maxDamage;
    }
    public String action(){
        return this._action;
    }
    public String name(){
        return this._name;
    }
}


