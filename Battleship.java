/* Simon Velez
* 300361574
* COSC 111 002
* November 6th, 2024
* 
* A program that allows a user to play battleship.
*/

//Step 1: Import Scanner for User input
import java.util.Scanner;
public class Battleship{
    public static void main(String[] args){
        //Step 2: Name Scanner
        Scanner input = new Scanner(System.in);
        
        //Step 3: Create the initial Board which is an 2D array of ints.
        //It can be different sizes
        int[][] setBoard = new int[6][6];
        
        //Step 4: Locate your ships at the position you want.
        setBoard[0][0] = 2;
        setBoard[1][0] = 2;
        setBoard[1][4] = 3;
        setBoard[2][4] = 3;
        setBoard[3][4] = 3;
        setBoard[5][2] = 4;
        setBoard[5][3] = 4;
        setBoard[5][4] = 4;
        setBoard[5][5] = 4;
        
        //Step 5: Creat a 2D char Array with the same size as the int array and assign
        char[][] gameBoard = new char[6][6];
        //Step 6: Use a nested for loop to assign each character '_'
        for(int y = 0 ; y < gameBoard.length ; y++){
            for(int x = 0 ; x < gameBoard[y].length ; x++){
                gameBoard[y][x] = '_';
            }
        }
        
        //Extra to print the board so that the user has some Idea of the range of the game.
        printBoard(gameBoard);
        //Step 6: Call the play method to play
        play(input, gameBoard, setBoard);
    }
    public static void play(Scanner input, char[][] gameBoard, int[][] setBoard){
        /* Step 1:
         * Declare all needed variable so that the game work properly
         * mostly on the sinking ships part.
         */
        int countPB = 0;
        int countD = 0;
        int countB = 0;
        boolean patrolBoat = false;
        boolean destroyer = false;
        boolean battleship = false;
        boolean gameOver = false;
        
        //Step 2: Create a while loop that iterates through the process to play the game
        while(!gameOver){
            //Step 3: prompt the User for a guess.
            System.out.println("Enter a guess in 'b2' 'B2' form");
            String guess = input.nextLine();
            
            //Step 4: Extract the indexes of the user input so they can be used in the game
            char letter = Character.toUpperCase(guess.charAt(0));
            char number = guess.charAt(1);
            int row = letter - 'A';
            int colum = number - '0' - 1;
            
            //Step 6: Declare all if statements so that all the conditions of the game
            //are followed
            if(gameBoard[row][colum] != ('_')){
                System.out.println("Already guessed");
            }else{
                if(setBoard[row][colum] == 2){
                    gameBoard[row][colum] = 'X';
                    System.out.println("Hit");
                    countPB++;
                    if(countPB == 2){
                        System.out.println("You sunk the Patrol Boat");
                        patrolBoat = true;
                    }
                }else if(setBoard[row][colum] == 3){
                    gameBoard[row][colum] = 'X';
                    System.out.println("Hit");
                    countD++;
                    if(countD == 3){
                        System.out.println("You sunk the Destroyer");
                        destroyer = true;
                    }
                }else if(setBoard[row][colum] == 4){
                    gameBoard[row][colum] = 'X';
                    System.out.println("Hit");
                    countB++;
                    if(countB == 4){
                        System.out.println("You sunk the Destroyer");
                        battleship = true;
                    }
                }else{
                     gameBoard[row][colum] = 'O';
                     System.out.println("Miss");
                }
            }
            //Step 7: When all boats are sink end the game.
            if(destroyer && patrolBoat && battleship){
                System.out.println("Sunk all ships, You Won!!");
                gameOver = true;
            }
            //Step 8: Print the game board so the user can keep track of its guesses
            printBoard(gameBoard);
            System.out.println();
        }
    }
    public static void printBoard(char[][] arr){
        char letter = 'A';
        //Iterating through all the 2D array so it print with some aditional conditions
        //to draw a frame.
        System.out.println("0  1   2   3   4   5   6");
        for(int y = 0 ; y < arr.length ; y++){
            System.out.print(letter);
            for(int x = 0 ; x < arr[y].length ; x++){
                System.out.print("|_"+arr[y][x]+"_");
            }
            System.out.println();
            letter ++;
        }
    }
}