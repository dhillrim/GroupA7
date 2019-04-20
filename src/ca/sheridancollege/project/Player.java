/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Rimpal,Vishwa,Sakshi,Harsh
 * 4 March,2019
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye, 2018
 * @modifier Vishwa
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private final ArrayList<Card> playercards;
    private final String name; 

    public Player(String name) {
        playercards = new ArrayList<>();
        this.name = name;

    }

    public int numberOfCards() {
        return playercards.size();
    }

    public ArrayList<Card> PlayerCards() {
        return playercards;
    }

    public void pickCards(Card c) {
        playercards.add(c);

    }

    public Card throwCard(int c) {
        return playercards.remove(c);
    }

    public void sayUno() {
        Scanner s = new Scanner(System.in);

        if (playercards.size() == 1) {

            System.out.println("Uno");
            System.out.println("Press Enter...");
            s.nextLine();
        }
    }

    public void showCards() {
        String[] card = {" ***** ", "|      |", "|      |", " ***** "};
        String c = "";

        for (int i = 0; i < card.length; i++) {

            for (int j = 0; j < playercards.size(); j++) 
            {
                if (!playercards.get(j).isSpecial()) {
                    switch (i) {
                        case 1:
                            c = c + "| " + playercards.get(j).getColor() + " |" + " ";
                            break;
                        case 2:
                            c = c + "|  " + playercards.get(j).getValue() + "  |" + " ";
                            break;
                        default:
                            c = c + card[i] + " ";
                            break;
                    }
                } else if (playercards.get(j).isSpecial()) {
                    if (i == 1) {
                        c = c + "| " + "+" + playercards.get(j).getValue() + "  |" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }
                }
            }
            c += "\n";
        }
        System.out.print(c);
    }

    public void hideCards() 
    {
        String[] card = {" ***** ", "|      |", "|      |", " ***** "};
        String c = "";

        for (String card1 : card) {
            for (Card playercard : playercards) {
                c = c + card1 + " ";
            }
            c += "\n";
        }

        System.out.print(c);
    }

    public boolean hasWon() 
    {
        return playercards.isEmpty();
    }

    @Override
    public String toString() {
        return this.name;
    }

}
