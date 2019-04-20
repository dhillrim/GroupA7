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
 * 
 * @modifier Vishwa
 */
public class Card {

    private String color;
    private int value;
    private int specialValue;
    private boolean special;

    public Card(int value, String color) 
    {
        this.color = color;
        this.value = value;
        this.specialValue = 0;
        this.special = false;
    }

    public Card(int specialValue) 
    { 
        this.color = "";
        this.specialValue = specialValue;
        this.value = 0;
        this.special = true;
    }

    public String getColor() 
    {
        return this.color;
    }

    public int getValue() 
    {
        if (!this.special) {
            return this.value;
        } else {
            return this.specialValue;
        }
    }

    public String toString() {
        String[] card = {" ***** ", "|      |", "|      |", " ***** "};
        String c = "";

        for (int i = 0; i < card.length; i++) {

            for (int j = 0; j < 1; j++) {

                if (!this.isSpecial()) {
                    if (i == 1) {

                        c = c + "| " + this.getColor() + " |" + " ";

                    } else if (i == 2) {

                        c = c + "|  " + this.getValue() + "  |" + " ";
                    } else {
                        c = c + card[i] + " ";
                    }

                } else if (this.isSpecial()) {

                    if (i == 1) {

                        c = c + "| " + "+" + this.getValue() + "  |" + " ";

                    } else {
                        c = c + card[i] + " ";
                    }

                }

            }

            c += "\n";

        }
        return c;
    }

    public boolean isSpecial() {
        if (special) {
            return true;
        }

        return false;
    }
}





