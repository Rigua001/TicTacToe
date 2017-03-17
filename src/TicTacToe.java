/**
 *COPYRIGHT (C) 2016 Rijkard Igualas. All Rights Reserved.
 *Class to play Tic Tac Toe.
 *Solves COP 3337 homework assignment #3
 *@author Rijkard Igualas
 *@version 2.00 2016-02-15
 * Rijkard Igualas
 * 3321856
 * COP 3337
 * section U02
 * I affirm that this program is entirely my own work and none 
 * of it is the work of any other person.
 *	___________________
 * 	(your signature)
 *
 */

import java.util.Scanner;

public class TicTacToe {
    //Declare variables
    private final int ROW = 3;
    private final int COLUMN = 3;
    private char [][] t3 = new char [ROW][COLUMN];
    private Scanner input  = new Scanner(System.in);
    private boolean p1 = true;
    
    /**
     * Creates TicTacToe array and set them all to '-'. 
     */
    public TicTacToe()
    {
        //Initialize array
        for (int cIndex = 0; cIndex < COLUMN; cIndex++)
        {
            for (int rIndex = 0; rIndex < ROW; rIndex++)
            {
                t3[rIndex][cIndex] = '-' ;
            }
        }      
    }
    
    
    
    
    /**
     * Displays TicTacToe board.
     */
    public void DisplayBoard()
    {
        //Displays all elements of array
        for (int cIndex = 0; cIndex < COLUMN; cIndex++)
        {
            System.out.print(cIndex + " | ");
            for (int rIndex = 0; rIndex < ROW; rIndex++)
            {
                System.out.print( t3[rIndex][cIndex] );
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println ("    0   1   2 ");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    
    
    
    
    /**
     * Verifies the outcome of the game
     * @return the winner of the game
     */
    public char isWinner()
    {
      //Checks if three columns contain same element
      for (int cIndex = 0; cIndex < COLUMN; cIndex++)
       {
           if (t3[0][cIndex] == t3[1][cIndex] && t3[0][cIndex] ==
                   t3[2][cIndex]
                   && t3[0][cIndex] != '-')
               {
                    return t3[0][cIndex];
               }
       } 
       //Checks if three rows contain same element
       for (int rIndex = 0; rIndex < ROW; rIndex++)
       {
           if (t3[rIndex][0] == t3[rIndex][1] && t3[rIndex][0] ==
                   t3[rIndex][2]
                   && t3[rIndex][0] != '-')
               {
                    return t3[rIndex][0];
               }  
       }
       //Checks if three elements match diagonally.
       if (t3[0][0] == t3[1][1] && t3[0][0] == t3[2][2]
               && t3[0][0] != '-')
       {
           return t3[0][0];
       }
       //Checks if three elements match diagonally.
       if (t3[0][2] == t3[1][1] && t3[0][2] == t3[2][0]
               && t3[0][2] != '-')
       {
           return t3[0][2];
       }
       //Checks if game is a tie.
       if (Tie() == true){
           return 'T';
       }
       return '-';
    }
    
    /**
     *Checks to see if the move is valid given the users input.
     */
    public void Valid()
    {
        boolean valid = false;
        int rIndex = 0;
        int cIndex = 0;
        //Prompts user for valid input
        while(valid == false)
        {
            System.out.println("Enter coordinates for the next move: ");
            //checks row
            if(!input.hasNextInt()){
                
                System.out.println("Enter two numbers between 0 - 2 "
                       + "seperated by a space: ");
              input.nextLine();  
            }
            rIndex = input.nextInt();
            //Checks column
            while(!input.hasNextInt()){
                System.out.println("Enter two numbers between 0 - 2 "
                       + "seperated by a space: ");
               input.nextLine();
            }
            cIndex = input.nextInt();
            
            //Checks range of input
            while((rIndex > 2 || cIndex > 2) || (rIndex < 0 ||
                    cIndex < 0) ){
                System.out.println("Enter two numbers between 0 - 2 "
                       + "seperated by a space: ");
                rIndex = input.nextInt();
                cIndex = input.nextInt();
            }
            //Check if input valid
            if ((rIndex >= 0 || rIndex <= 2) && (cIndex >= 0 ||
                    cIndex <= 2))
            {   //Check if slot available
                if (t3[rIndex][cIndex] == '-')
                {
                    valid = true;
                }
                else
                {
                    System.out.println("This slot is already taken");   
                }
            }
            
            else{
                System.out.println("Input " +rIndex 
                        + " " + cIndex + "not valid" );
                 
                 System.out.println("Please enter valid coordinates "
                       + "(Enter two numbers between 0 - 2 "
                       + "seperated by a space): ");
                    input.nextLine();
            } 
        }
        //Replaces input in array based on players turn
        if (p1 == true){
            t3[rIndex][cIndex] = 'X';
        }
        else{
            t3[rIndex][cIndex] = 'O'; 
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Determines if the game is a Tie.
     * @return the state of tie
     */
    public boolean Tie()
    {
        int slots = 0;
        boolean tie = false;
        //Search array for available slots
         for (int cIndex = 0; cIndex < COLUMN; cIndex++)
        {
            for (int rIndex = 0; rIndex < ROW; rIndex++)
            {
                if (t3[rIndex][cIndex] != '-' )
                {
                    slots++;
                }
            }
        }
       //If no slots available then tie game
       if(slots == 9)
       {
           return tie = true;
       }
       else
       {
           return tie;
       }        
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Plays game by using user input and prompts winner.
     */
    public void PlayGame()
    {
        //Loop until winner is determined
        do
        {
            DisplayBoard();
            Valid();
            p1 = !p1;
            }while(isWinner() == '-' );
        DisplayBoard();
        //If game is a tie display tie
        if(isWinner()== 'T')
        {
            System.out.println("TIE!!");
        }
        //Display winner
        else
        {
            System.out.println(isWinner() + " won!!");
        }
            
    }
       
    
}
