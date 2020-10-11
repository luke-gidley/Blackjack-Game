/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;


import java.util.ArrayList;

/**
 *
 * @author 98111
 */
public class Player {
    ArrayList<Card> hand;
    public int position;
    //public enum status{stick, twist, bust};
    //public status playerStatus;
    public String playerName;
    
    public Player(String name, int position){
        this.playerName = name;
        this.position = position;
        hand = new ArrayList<Card>();
        //playerStatus = status.twist;
    }
    
    
    public int sumOfCards(){
        int pointValue = 0;
        for (Card aCard:hand){
            pointValue = pointValue + aCard.getPointValue();
        }
        return pointValue;
    }
    
    
    public void takeCard(Card newCard){
        this.hand.add(newCard);
    }
    
    
    public Card discard(int cardPos){
        return this.hand.remove(cardPos);
    }
    
    public Card lookAtCard(int cardPos){
        return this.hand.get(cardPos);
    }
    
    public Card lookAtCardColour(int colourName){
        return this.hand.get(colourName);
    }
    
   // public status getStatus(){
    ///    return this.playerStatus;
   // }
    
    public int getPosition(){
        return this.position;
    }
  
    public String getName(){
        return this.playerName;
    }
 //   public void setName(String name){
   //     this.name = name;
    //}
    

    









}
