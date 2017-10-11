package dungeonhackrun;

import dungeonhack.*;
import java.util.Scanner;

public class DungeonHackRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        Weapon pKnife = new Weapon("Pocket Knife","stabs", 7);
        Weapon kKnife = new Weapon ("Kitchen Knife", "slashes", 8); 
        Weapon axe = new Weapon("Axe","axes",9);
        Weapon shotgun = new Weapon("Shotgun","shoots",12);
        Weapon spoon = new Weapon("Spoon","hits",1);
        Weapon[] weapons;
        weapons = new Weapon[5];
        weapons[0] = pKnife;
        weapons[1] = kKnife;
        weapons[2] = axe;
        weapons[3] = shotgun;
        weapons[4] = spoon;

        Die d5  = new Die(5);
        Die d10 = new Die(10);
        Die d15 = new Die(15);
        Die d20 = new Die(20);
        Die d30 = new Die(30);
        Die d40 = new Die(40);
        int on = 1;
        
        String action = "";
        String p1n = "";
        String p2n = "";
        int p1h = 0;
        int p2h = 0;
        int p1ac = 0;
        int p2ac = 0;
        Weapon p1w = pKnife;
        Weapon p2w = pKnife;
        
        System.out.println("Player 1, What is Your Name?");
        p1n = input.nextLine();
        p1h = 10 + d20.roll();
        p1ac = 5 + d15.rollnm();
        p1w = weapons[d5.rollnm()];
        System.out.printf("%s, your health is %d, your armor class is %d and your weapon is %s\n"
            , p1n,p1h,p1ac,p1w.name());
        
        Actor pl1 = new Actor(p1n,p1h,p1ac,p1w);
        int p1nac = pl1.armorClass();
        
        System.out.println("Player 2, What is Your Name?");
        p2n = input.nextLine();
        p2h = 10 + d20.roll();
        p2ac = 5 + d15.rollnm();
        p2w = weapons[d5.rollnm()];
        System.out.printf("%s, your health is %d, your armor class is %d and your weapon is %s\n"
            , p2n,p2h,p2ac,p2w.name());
        
        Actor pl2 = new Actor (p2n,p2h,p2ac,p2w);
        int p2nac = pl2.armorClass();
        
        
        while (pl2.health() >0 && pl1.health() > 0){
            on = 1;
            while (on == 1){
            System.out.printf("%s, input action:\n",p1n);
            action = input.nextLine();
            
            if (action.equals("attack")||action.equals("a")){
                on = 0;
                if (pl1.health() > 0){
                    System.out.printf("%s attacks!\n",p1n);
                    if (d20.roll() >= p2nac){
                        Die ddam = new Die(pl1.weapon().maxDamage());                        
                        pl2.takeDamage(ddam.roll());
                        if (pl2.health() > 0){
                            System.out.printf("%s %s %s! %s has %d health left.\n"
                                    , pl1.name(), pl1.weapon().action(), pl2.name(),pl2.name(), pl2.health());
                        }
                    }else{
                        System.out.println("Attack Failed!");
                    }
                }
                }else   {if (action.equals("defend")||action.equals("d")){
                    p1nac = p1nac + 5;
                    on = 0;
                }
            }
            }
            action = "";
            p2nac = pl2.armorClass();

            System.out.printf("%s, input action:\n",p2n);
            action = input.nextLine();
            if (action.equals("attack")||action.equals("a")){
                if (pl2.health() > 0){
                    System.out.printf("%s attacks!\n",pl2.name());
                    if (d20.roll() >= p1nac){
                        Die tdam = new Die(pl2.weapon().maxDamage());
                        pl1.takeDamage(tdam.roll());
                        if (pl1.health() > 0){
                            System.out.printf("%s %s %s! %s has %d health left.\n"
                                    , pl2.name(), pl2.weapon().action(), pl1.name(),pl1.name(), pl1.health());
                        }
                    }else{
                        System.out.println("Attack Failed!");
                    }
                }
            }else   {if (action.equals("defend")||action.equals("d")){
                    p2nac = p2nac + 5;
                }
                }    
        
        action = "";
        p1nac = pl1.armorClass();
        }
        
        if (pl2.health() <=0){
            System.out.printf("R.I.P %s\n",p2n);
        }else{
            System.out.printf("R.I.P %s\n",p1n);
        }
        
    }
    private static void attack1(){
        
    }
}
    

