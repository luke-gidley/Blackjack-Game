/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;
import java.util.Scanner;
/**
 *
 * @author 98111
 */
public class Game {
    Player playerOne;
    Player playerTwo;
    boolean bust = false;
    boolean gameOver = false;
    boolean playerOneTurn = false;
    boolean playerTwoTurn = false;
    boolean test = true;
    String choice1 = "";
    String choice2 = "";   
    int playerOneBlackCards = 0;
    int playerTwoBlackCards = 0;
    Scanner sc=new Scanner(System.in); 
    
    public Game(){
        this.playerOne = new Player("Nigel", 1);
        this.playerTwo = new Player("Sean", 2);
    }
    

    public void setUp(){
        //make new deck
        //deal first 2 cards to each player
        Deck myDeck = new Deck();
        
        this.playerOne.takeCard(myDeck.deal());
        this.playerOne.takeCard(myDeck.deal());
        
        this.playerTwo.takeCard(myDeck.deal());
        this.playerTwo.takeCard(myDeck.deal());
        
        playerOneTurn = true;

    }
    

    
    
    public void gameLoop(Deck myDeck){
        setUp();
    while (gameOver == false){    
        
        while (playerOneTurn == true){
        //player one loop
            //show cards to player one
            
          if ("TWIST".equals(choice2.toUpperCase())){
              playerTwoTurn = true;


          }
            
        if("STICK".equals(choice1.toUpperCase()) && "STICK".equals(choice2.toUpperCase())){
        playerOneTurn = false;
        playerTwoTurn = false;} 
  
        for(int i = 0; i < playerOne.hand.size(); i++) {   
        System.out.print(this.playerOne.lookAtCard(i).getFullName());
        }  
        //add cards and show value
        System.out.println(this.playerOne.sumOfCards());

        //create bust loop
        
            //check for 21

            if (this.playerOne.sumOfCards() == 21){
            System.out.println("PlayerOne wins!");
            gameOver = true;
            System.exit(0);

            
            }
           
            //check for bust
            else if (this.playerOne.sumOfCards() > 21){
            System.out.println("PlayerOne has busted!");
            gameOver = true;
            playerTwoTurn = false;
            playerOneTurn = false;
            System.exit(0);
            
            }        
            else if (this.playerOne.sumOfCards() < 21){
            //ask to twist or stick
                System.out.println("Stick or Twist?");
                choice1 = sc.next();
                
                if ("TWIST".equals(choice1.toUpperCase())){
                    this.playerOne.takeCard(myDeck.deal());
                            
                    playerOneTurn = true;
                    playerTwoTurn = true;
                    if ("STICK".equals(choice2.toUpperCase())){
                        playerTwoTurn = false;
                    }
                    if (this.playerOne.sumOfCards() > 21){
                    for(int i = 0; i < playerOne.hand.size(); i++) {   
                    System.out.print(this.playerOne.lookAtCard(i).getFullName());
                    }
                    System.out.println(this.playerOne.sumOfCards());
                    System.out.println("PlayerOne has busted!");
                    gameOver = true;
                    playerOneTurn = false;
                    playerTwoTurn = false;
                    System.exit(0);

                    }        
            }
                else if("STICK".equals(choice1.toUpperCase())){
                    System.out.println("PlayerOne sticks with a score of: " + playerOne.sumOfCards());
                    playerTwoTurn = true;
                    playerOneTurn = false;
                        if ("STICK".equals(choice2.toUpperCase())){
                        playerTwoTurn = false;
                        playerOneTurn = false;

                    }
                }
            }  

        //restart loop
        }
        //de comment depending on johns email playerTwoTurn = true;
        

        
                //player two loop
                while (playerTwoTurn == true){
                 
                if("STICK".equals(choice1.toUpperCase())){
                    playerOneTurn = false;
                }
                    
                if ("STICK".equals(choice2.toUpperCase())){
                playerTwoTurn = false;
                }                
                    
        for(int i = 0; i < playerTwo.hand.size(); i++) {   
        System.out.print(this.playerTwo.lookAtCard(i).getFullName());
        }         

        System.out.println(this.playerTwo.sumOfCards());


            if (this.playerTwo.sumOfCards() == 21){
            System.out.println("PlayerTwo wins!");
            gameOver = true; 
            System.exit(0);

            
            }
            //check for bust
            else if (this.playerTwo.sumOfCards() > 21){
            System.out.println("PlayerTwo has busted!");
            gameOver = true;
            playerOneTurn = false;
            playerTwoTurn = false;
            System.exit(0);
            
            }        
            else if (this.playerTwo.sumOfCards() < 21){
                System.out.println("Stick or Twist?");
                choice2 = sc.next();
                
                if ("TWIST".equals(choice2.toUpperCase())){
                this.playerTwo.takeCard(myDeck.deal());
                System.out.println(this.playerTwo.sumOfCards());
                playerTwoTurn = false;
                playerOneTurn = true; 
                if ("STICK".equals(choice1.toUpperCase())){
                playerOneTurn = false;
                playerTwoTurn = true;
                }
                if (this.playerTwo.sumOfCards() > 21){
                System.out.println("PlayerTwo has busted!");
                gameOver = true;
                playerOneTurn = false;
                playerTwoTurn = false;
                System.exit(0);

                }
                }
                else if("STICK".equals(choice2.toUpperCase())){
                System.out.println("PlayerTwo sticks with a score of:" + this.playerTwo.sumOfCards());
                playerTwoTurn = false;
                playerOneTurn = true;
                

                if("STICK".equals(choice1.toUpperCase()) && "STICK".equals(choice2.toUpperCase())){
                    playerOneTurn = false;
                    playerTwoTurn = false;


                }
                    break;
                    } 
                }
            }

 

        //de comment depending on johns email playerTwoTurn = true;
        while(playerOneTurn == false && playerTwoTurn == false){
            if (this.playerOne.sumOfCards() > this.playerTwo.sumOfCards()){
                System.out.println("Player One wins!!!!");
                gameOver = true;
                playerOneTurn = true;
                System.exit(0);
              
            }
            else if(this.playerOne.sumOfCards() < this.playerTwo.sumOfCards()){
                System.out.println("Player Two wins!!!!");
                gameOver = true;
                playerOneTurn = true;
                    System.exit(0);
                    
                  
            }
            else if(this.playerOne.sumOfCards() == this.playerTwo.sumOfCards()){
                for(int i = 0; i < playerOne.hand.size(); i++){
                if(this.playerOne.lookAtCard(i).getColour() == Card.colour.black ){
                  playerOneBlackCards = playerOneBlackCards + 1;  
                }
                }
                for(int i = 0; i < playerTwo.hand.size(); i++){
                if(this.playerTwo.lookAtCard(i).getColour() == Card.colour.black ){
                  playerTwoBlackCards = playerTwoBlackCards + 1;  
                }
                }
            if (playerOneBlackCards > playerTwoBlackCards){
                System.out.println("Player One wins!");
            
            }
            else if (playerTwoBlackCards > playerOneBlackCards){
                System.out.println("Player Two wins!");
            }
            }
        }
        
    }
    }           
    }     
    
    
    



   