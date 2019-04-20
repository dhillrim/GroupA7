/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Rimpal,Vishwa,Sakshi,Harsh
 * 4 March,2019
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 * @modifier Vishwa
// */

public class Game {

    private Card current; 
    private GroupOfCards deck; 
    private final ArrayList<Card> cardpile; 
    private int penalty; 
    private final Scanner choice;
    private final Player p1; 
    private final Player p2;
    private int pick;

    public Game() 
    {
        deck = new GroupOfCards();
        deck.shuffle();
        penalty = 0;
        current = getStartingCard();
        cardpile = new ArrayList<>();
        cardpile.add(current);
        choice = new Scanner(System.in);
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        distributecards();

    }

    public void game() {
        int turn = 0;
        while (!gameOver(p1, p2)) {
            if (turn % 2 == 0) {
                playGame(p1);
            } else {
                playGame(p2);
            }
            turn++;
        }

    }

    private void distributecards() {
        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {
                p1.pickCards(deck.getTopCard());
            } else {
                p2.pickCards(deck.getTopCard());
            }

        }
    }

    public void playGame(Player p) {
        System.out.println(p + ", It is your turn\nThe current card on play is:\n" + current);

        showBoard(p);

        if (current.isSpecial()) {
            penalty += current.getValue();
            Card pick;
            if (!canOverride(p)) {
                System.out.println("You dont have a card to override the current special card, so you are penalised");
                for (int i = 0; i < penalty; i++) {

                    if (deck.isEmpty()) {
                        deck = new GroupOfCards(cardpile);
                    }
                    pick = deck.getTopCard();
                    p.pickCards(pick);
                    System.out.println("You picked: \n" + pick);
                    pause();

                }
                penalty = 0;
                current = deck.getTopCard();
                System.out.println("The new current card is: \n" + current);
            }
        }
        if (!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {
            Card pick1 = null;
            System.out.println("You dont have a valid card to play, so you have to pick cards.");
            while (!hasColor(p) && !hasValue(p) && !hasSpecial(p)) {

                pause();
                pick1 = deck.getTopCard();
                p.pickCards(pick1);
                System.out.println("You picked:\n" + pick1);

            }

            System.out.println("You recieved a valid card!");
            pause();
            System.out.println("You have the following cards: ");
            p.showCards();
        }

        System.out.println("Please enter a card number:");
        pick = choice.nextInt() - 1;

        while (!isValidChoice(p, pick)) {

            System.out.println("Invalid pick. Please pick a valid card.");
            pick = choice.nextInt() - 1;

        }

        Card play = p.throwCard(pick);

        p.sayUno();
        current = play;
        cardpile.add(current);
    }

    private boolean hasSpecial(Player p) {
        return p.PlayerCards().stream().anyMatch((c) -> (c.isSpecial()));
    }

    private boolean isValidChoice(Player p, int choice) {
        if (choice <= p.PlayerCards().size()) {
             if (p.PlayerCards().get(choice).getColor().equals(current.getColor()) || p.PlayerCards().get(choice).getValue() == current.getValue() || p.PlayerCards().get(choice).isSpecial()) {
                return true;
            }

        }

        return false;
    }

    private void pause() {
        System.out.println("Press enter to continue......");
        choice.nextLine();
    }

    private boolean hasColor(Player p) {
        return p.PlayerCards().stream().anyMatch((c) -> (c.getColor().equals(current.getColor())));
    }

    private boolean hasValue(Player p) {
        return p.PlayerCards().stream().anyMatch((c) -> (c.getValue() == current.getValue()));
    }

    private boolean canOverride(Player p) 
    {
        return p.PlayerCards().stream().filter((c) -> (c.isSpecial())).anyMatch((c) -> (c.getValue() >= current.getValue()));
    }
    private Card getStartingCard() {
        Card temp = deck.peek();
        while (temp.isSpecial()) {
            deck.shuffle();
            temp = deck.peek();
        }

        temp = deck.getTopCard();
        return temp;
    }

    public boolean gameOver(Player p1, Player p2) {
        if (p1.hasWon()) {
            System.out.println("##################################################");
            System.out.println("Player 1 has won");
            System.out.println("##################################################");
            return true;
        } else if (p2.hasWon()) {
            System.out.println("##################################################");
            System.out.println("Player 2 has won");
            System.out.println("##################################################");
            return true;
        }
        return false;
    }

    public void showBoard(Player p) {

        if (p.toString().equals("Player 1")) {
            System.out.println("                Player 1");
            p1.showCards();
            p2.hideCards();
            System.out.println("                Player 2");
            System.out.println("");
        } else {
            System.out.println("                Player 1");
            p1.hideCards();
            p2.showCards();
            System.out.println("                Player 2");
            System.out.println("");
        }
    }
}
