/*
 * Simon Velez
 * 300361574
 * COSC 111 002
 * October 1st, 2024
 * 
 * A programe that prompts the user for a password and will keep promting
 * until it gets a proper aceptable password.
 */

//Step 1: Import a Scanner object
import java.util.Scanner;

public class Password{
    public static void main(String[] args){
        //Step 2: Name my Scanner object
        Scanner input = new Scanner(System.in);
        
        //Step 3: Declare all needed variables for all conditions and the loop
        int y = 0;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasPassword = false;
        boolean hasSpecialCharacters = false;       
        
        //Step 4: Set your loop and write all the conditions
        do{
            System.out.print("Write Password: ");
            String password = input.nextLine();
                
            if (password.length()<8){
                System.out.println("Password must contain at least 8 characters");
            }
            
            for (int x = 0;x < password.length();x++){
                if (Character.isUpperCase(password.charAt(x))){
                    x = password.length();
                    hasUpperCase = true;
                }
                }
            if(hasUpperCase == false){
                System.out.println("Password must contain at least 1 upper case letter");
            }
            
            for (int x = 0;x < password.length();x++){
                if (Character.isLowerCase(password.charAt(x))){
                    x = password.length();
                    hasLowerCase = true;
                }
            }
            if(hasLowerCase == false){
                System.out.println("Password must contain at least 1 lower case letter");
            }
            
            for (int x = 0;x < password.length();x++){
                if (Character.isDigit(password.charAt(x))){
                    x = password.length();
                    hasNumber = true;
                }
            }
            if(hasNumber == false){
                System.out.println("Password must contain at least 1 number");
            }
            
            String test = password.toLowerCase();
            if(test.contains("password")){
                System.out.println("Password must not contain the word \"password\"");
                hasPassword = true;
            }
            
            for (int x = 0;x < password.length();x++){
                if (!Character.isLetterOrDigit(password.charAt(x))){
                    x = password.length();
                    hasSpecialCharacters = true;
                }
            }
            if(hasSpecialCharacters){
                System.out.println("Password can not contain special characters or white characters");
            }
                
            if(hasUpperCase == true && hasLowerCase == true && hasNumber ==true && hasPassword == false && hasSpecialCharacters == false){
                //When all the conditions are followed the value of y changes to 1 and escapes the loop
                y = 1;
            }
            //Step 5: reset all conditions to their original value and test again
            hasUpperCase = false;
            hasLowerCase = false;
            hasNumber = false;
            hasPassword = false;
            hasSpecialCharacters = false;
            }while (y == 0);
        //Step 6: print the final result 
        System.out.println("Your password is valid");
            
        } 
        }
    

