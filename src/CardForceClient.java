/**
 * Public class for the Card Force Client Application
 * COM498 Coursework 2
 * B00757542
 * John Lee O'Connell
 */

import java.util.Scanner;

public class CardForceClient {

    public static void main(String[] args){
        // Step 1
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Card Force Client******");
        System.out.println("Instantiating the Deck.");
        DeckInterface<Card> cardDeck = new Deck<>();

        // step 2
        System.out.println("----------------------------------------------------------------------------------");
        cardDeck.show();

        // step 3
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Shuffling the Deck");
        cardDeck.shuffle();
        cardDeck.show();

        //step 4
        System.out.println("----------------------------------------------------------------------------------");
        Card top = cardDeck.reveal();

        // step 5
        System.out.println("----------------------------------------------------------------------------------");
        cardDeck = cardForce(cardDeck);
        cardDeck.show();
        System.out.println("----------------------------------------------------------------------------------");

        // step 6
        int index = cardDeck.find(top);
        System.out.println("Top card is at index: " + index);

        // end
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Card force Client Finished******");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("John Lee O'Connell\nB00757542\nCW2 COM498\n2nd Year Software Engineering");

    }

    /**
     * Private helper method cardForce, used to perform the card force trick on the deck.
     * @param deck the deck to be used for the trick.
     * @return DeckInterface of the card force shuffled deck.
     */
    private static DeckInterface cardForce(DeckInterface deck){
        int pos = getInput();
        //convert the int into a binary string
        String binaryInt = Integer.toBinaryString(pos);
        System.out.println(binaryInt);

        for(char letter: binaryInt.toCharArray()){
            if(letter == '0'){
                deck.outShuffle();
            } else if (letter == '1'){
                deck.inShuffle();
            } else {
                throw new IllegalArgumentException("Incorrect type supplied, expected type int.");
            }
        }
        return deck;
    }

    /**
     * Private helper method getInput, used to get the user input in the form of a int.
     * @return int of the users input.
     */
    private static int getInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter value:");
        int input = in.nextInt();
        if(input > 0){
            return input;
        } else {
            throw new NumberFormatException("Incorrect Type");
        }
    }



}

