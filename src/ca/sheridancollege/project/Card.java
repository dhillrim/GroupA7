/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Rimpal,Vishwa,Sakshi,Harsh
 * 4 March,2019
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */




public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public enum Suit{RED,YELLOW,GREEN,BLUE};
        public enum Value{ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,SKIP,REVERSE,DRAWTWO,DRAWFOUR ,WILDCARD};
    
	private final Value value;
	private final Suit suit;
        public Card(Suit s, Value gVal){
            suit=s;
            value=gVal;
        }
	public Value getValue() {
		return this.value;
	}

	

	public Suit getSuit() {
		return this.suit;
	}

    @Override
    public abstract String toString();
    
}
