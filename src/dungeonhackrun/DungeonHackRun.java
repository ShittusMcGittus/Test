package dungeonhackrun;

import dungeonhack.*;

public class DungeonHackRun {
    public static void main(String[] args) {
    
        Weapon pKnife = new Weapon("Pocket Knife","stabs", 7);
        Weapon kKnife = new Weapon ("Kitchen Knife", "slashes", 8);
        Actor dave = new Actor("Dave",30,10,pKnife);
        Actor tyler = new Actor ("Tyler",40,5,kKnife);
        Die d20 = new Die(20);
        
        
        while (tyler.health() >0 && dave.health() > 0){
            if (dave.health() > 0){
                System.out.println("Dave attacks!");
                if (d20.roll() >= tyler.armorClass()){
                    Die ddam = new Die(dave.weapon().maxDamage());                        
                    tyler.takeDamage(ddam.roll());
                    if (tyler.health() > 0){
                        System.out.printf("%s %s %s! %s has %d health left.\n"
                                , dave.name(), dave.weapon().action(), tyler.name(),tyler.name(), tyler.health());
                    }
                }else{
                    System.out.println("Attack Failed!");
                }
            }
            if (tyler.health() > 0){
                System.out.printf("%s attacks!\n",tyler.name());
                if (d20.roll() >= dave.armorClass()){
                    Die tdam = new Die(tyler.weapon().maxDamage());
                    dave.takeDamage(tdam.roll());
                    if (dave.health() > 0){
                        System.out.printf("%s %s %s! %s has %d health left.\n"
                                , tyler.name(), tyler.weapon().action(), dave.name(),dave.name(), dave.health());
                    }
                }else{
                    System.out.println("Attack Failed!");
                }
            }    
        }
        if (tyler.health() <=0){
            System.out.println("R.I.P Tyler");
        }else{
            System.out.println("R.I.P Dave");
        }
        
    }
}
