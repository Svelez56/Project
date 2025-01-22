/*
 * Simon Velez
 * 300361574
 * COSC 111 002
 * September 25th, 2024
 * 
 * A programe that plays the gambling game of craps.
 */

public class CrapsGame{
    public static void main(String[] args){
        
        // Step #1 Declare all variables used
        int random;
        int point;
        int dice1;
        int dice2;
        boolean playing = true;
        
        // Step #2 Start up my randomizer using 2 dice
        dice1 = 1 + (int)(Math.random() * 6);
        dice2 = 1 + (int)(Math.random() * 6);
        
        // Step #3 Assign a final value to play
        random = dice1 + dice2;
        
        
        // Step #4 Add if to set the game conditions for first round
        if ((random == 7)||(random == 11)){
            System.out.println("You rolled a " +random+ " you win!");
            random = 0;
        }else if (((random == 2)||(random == 3))||(random == 12)){
            System.out.println("You rolled " +random+ ". You lose.");
            random = 0;
        } else{
            System.out.println("You rolled " +random+ ". Point is "+random);
            point = random;
            
            // Step #5 Add while to repeat the dice roll
            while (playing){
                
                dice1 = 1 + (int)(Math.random() * 6);
                dice2 = 1 + (int)(Math.random() * 6);
        
                random = dice1 + dice2;
                
                // Step #6 Add if to execute conditions for all the other rounds.
                if (random == point){
                    System.out.println("You rolled a " +random+ ". You win!");
                    playing = false;
                }else if (random == 7){
                    System.out.println("You rolled a " +random+ ". Craps. You lose.");
                    playing = false;
                }else{ 
                    System.out.println("You rolled a " +random+ ".");
                }
            }
        }
    }
}