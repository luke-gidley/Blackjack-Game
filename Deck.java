/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 98111
 */
public class Deck {
    static final int CARDS_IN_PACK =52;
    ArrayList<Card> newDeck;
    ArrayList<Card> shuffledDeck;
    String[] cardNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    Random rand;

    
    public Deck(){
        newDeck = new ArrayList<Card>();
        shuffledDeck = new ArrayList<Card>();
        rand = new Random();
        makeDeck();//generate a new deck
        shuffle(); //shuffle cards from new deck
    }
    
    public Card deal(){
        return this.shuffledDeck.remove(shuffledDeck.size() - 1);
    }
    
    private void makeDeck(){
        for (Card.suit s:Card.suit.values()){
            for (int i = 0;i<cardNames.length;i++){

                this.newDeck.add(new Card(s, cardNames[i],i));
                
                }
        }

    }
    
    private void shuffle(){

        for(int i = 0; i < CARDS_IN_PACK;i++){
            int randomCard = rand.nextInt(newDeck.size());
            this.shuffledDeck.add(newDeck.remove(randomCard));


        }

        
    }
            public int getRemainingCards(){
                return this.shuffledDeck.size();
            }

}


