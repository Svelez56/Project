/*
 * Simon Velez
 * 300361574
 * COSC 111 002
 * October 22nd, 2024
 * 
 * A programe that prompts the user for a text and it gives the respective
 * information such as sum of digits, number of letters, number of vowels
 * and if it has all the letters of the word awesome.
 */

//Step 1: Import a Scanner object
import java.util.Scanner;

public class Methods{
    public static void main(String[] args){
        //Step 2: Name out Scanner Object
        Scanner input = new Scanner(System.in);
        
        //Step 3: Prompt our user for a string of text
        System.out.println("Enter a line of text");
        String text = input.nextLine();
        
        //Step 5: Declare our variable and invoke oure methods
        int digitSum = digitSum(text);
        int lettersSum = numLetters(text);
        int vowelsSum = vowelsNum(text);
        boolean hasAwesome = isAwesome(text);
        
        //Step 6: Print the final result
        System.out.println("The number of letters is: " + lettersSum);
        System.out.println("The number of vowels is: " + vowelsSum);
        System.out.println("The sum of digits is: " + digitSum);
        if(hasAwesome){
            System.out.println("The sentence is awesome");
        }else{
            System.out.println("The sentence is not awesome");
        }
        
    }
    //Step 4: Create all our new methods
    public static int digitSum(String text){
        //Step 1: Declare our initial variable that we are going to return
        int sum = 0;
        
        //Step 2: Creat a loop that checks for each character
        for(int x = 0 ; x < text.length() ; x++){
            //Step 3: Declare our if statement to see if it's a digit, if so add that digit
            char c = text.charAt(x);
            if(Character.isDigit(c)){
                int i = c - '0';
                sum += i;
            }
        }
        //Step 4: Return our final result
        return sum;
    }
    public static int numLetters(String text){
        //Step 1: Declare our initial variable that we are going to return
        int sum = 0;

        //Step 2: Creat a loop that checks for each character
        for (int x = 0; x < text.length() ; x++){
            //Step 3: Check if the character is a letter an add 1 to the count.
            char c = text.charAt(x);
            if(Character.isLetter(c)){
                sum ++; 
            }
        }
        //Step 4: Return our final result
        return sum;
    }
    public static int vowelsNum(String text){
        //Step 1: Declare our initial variable that we are going to return
        int sum = 0;
        
        //Step 2: Create a test text to make it easier to check for vowels
        String testText = text.toLowerCase();
        
        //Step 3: Creat a loop that checks for each character
        for(int x = 0 ; x < text.length(); x++){
            //Step 4: Check if the character is a vowel and increment sum.
            char c = testText.charAt(x);
            if (c == ('a') || c == ('e') || c == ('i') || c == ('o') || c == ('u')){
                sum ++;
            }
        }
        //Step 5: Return our final result
        return sum;
    }
    public static boolean isAwesome(String text){
        //Step 1: Declare our initial variables that we are going to use in our method
        int count = 0;
        boolean a = false;
        boolean w = false;
        boolean e = false;
        boolean s = false;
        boolean o = false;
        boolean m = false;
        boolean awesome = false;
        
        //Step 2: Create a test text to make it easier to check for the word awesome
        String testText = text.toLowerCase();
        
        ////Step 3: Creat a loop that checks for each character
        for(int x = 0 ; x < text.length() ; x++){
            char c = testText.charAt(x);
            
            /* Step 4:
             * Set if conditions to assign the value true to the boolean variables 
             * if that character is on the String.
             */
            if (c == ('a')){
                a = true;
            }else if(c == ('w')){
                w = true;
            }else if(c == ('s')){
                s = true;
            }else if(c == ('o')){
                o = true;
            }else if (c == ('m')){
                m = true;
            }else if (c == ('e')){
                count ++;
                if (count >= 2){
                    e = true;
                }
            }
            if (a && w && s && o && m && e){
                awesome = true;
            }else{
                awesome = false;
            }
        }
        //Step 5: Return our final result
        return awesome;
    }
}