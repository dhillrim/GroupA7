/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Rimpal,Vishwa,Sakshi,Harsh
 * 4 March,2019
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @modifier Vishwa
 */
public class GroupOfCards {

    private ArrayList<Card> card;

    public GroupOfCards() {
        card = new ArrayList<>();
        String[] colors = {"RED", "BLUE", "GREEN", "YELLOW"};
        int[] numbers = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0}; 
        int[] specialnumbers = {2, 2, 4, 4}; 

        for (String c : colors) {
            for (int i : numbers) {
                card.add(new Card(i, c)); 
            }
        }

        for (int i : specialnumbers) 
        {
            card.add(new Card(i));
        }

    }

    public GroupOfCards(ArrayList<Card> c) {
        card = c;
    }

    public boolean isEmpty() {
    return card.size() <= 0;
    }

    public void shuffle() {
        Collections.shuffle(card);

    }

    public Card getTopCard() {
        return card.remove(card.size() - 1);
    }

    public Card peek() {

        return card.get(card.size() - 1);
    }

    @Override
    public String toString() {

        String deck = "";

        for (Card c : this.card) {

            deck = deck + c + " ";
        }

        return deck;

    }
}
