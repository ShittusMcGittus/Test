package dungeonhack;

import java.util.Scanner;

public class NSidedDiceRun {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Roll a 6 sided die? y/n");
        //boolean yesNo = input.nextBoolean();
        String noYes = input.nextLine();
        if (noYes == "y"){
            Die auto = new Die(6);
            System.out.printf("Rolling %d sided die\n",auto.getSides());
            System.out.printf("%d\n",auto.roll());
        
        }else{
            //if (yesNo = false){
            System.out.println("How many sides?");
            int dieSides = input.nextInt();
            
            Die manual = new Die(dieSides);
        
            System.out.printf("Rolling %d sided die\n",manual.getSides());
            System.out.printf("%d\n",manual.roll());
            //}
        }
        
        
    }
    
}
