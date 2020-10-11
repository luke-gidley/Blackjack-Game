/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

/**
 *
 * @author 98111
 */
public class Card {


public enum suit{hearts,clubs,diamonds,spades};
private suit mySuit;
public enum colour{black,red};
private colour myColour;
private String cardName;
private String fullName;
private int pointValue;
public colour colourName;

public Card(Card.suit mySuit, String cardName, int points){
this.mySuit = mySuit;
this.cardName = cardName;
setFullName(cardName,mySuit);
setColour(mySuit);
setPoints(points);



}

public suit getSuit(){
return this.mySuit;
}
public String getcardName(){
return this.cardName;
}
public colour getColour(){
return this.myColour;
}
public String getFullName(){
return this.fullName;
}
private void setFullName(String cardName, suit mySuit) {
this.fullName=this.getcardName()+" of "+this.getSuit().toString();
}



private void setColour(suit mySuit) {
if (mySuit == suit.clubs || mySuit == suit.spades){
    this.myColour = colour.black;
    }else{
    this.myColour = colour.red;
}
}
    private void setPoints(int points) {
     this.pointValue = points+1;
     if(this.pointValue > 10){
         this.pointValue = 10;
     }
    }
    
    public int getPointValue(){
        return this.pointValue;
    }

}