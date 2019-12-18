import sun.tools.java.SyntaxError;

import java.util.Scanner;

/**
 * Public class for the Card Force Client Application
 */

public class CardForceClient {

    public static void main(String[] args){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Card Force Client******");
        System.out.println("Instantiating the Deck.");
        DeckInterface<Card> cardDeck = new Deck<>();
        System.out.println("----------------------------------------------------------------------------------");
        cardDeck.show();
        System.out.println("----------------------------------------------------------------------------------");
        cardDeck.reveal();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("---Shuffling the Deck---");
        cardDeck.shuffle();
        cardDeck.show();
        System.out.println("----------------------------------------------------------------------------------");
        Card top = cardDeck.reveal();
        //TODO: Add In and out shuffles:
        System.out.println("----------------------------------------------------------------------------------");
//        System.out.println("---In Shuffle---");
//        cardDeck.inShuffle();
//        cardDeck.show();
//        System.out.println("----------------------------------------------------------------------------------");
//        System.out.println("---Out Shuffle---");
//        cardDeck.outShuffle();
//        cardDeck.shuffle();
//        System.out.println("Shuffled deck:");
        cardDeck = cardForce(cardDeck);
        cardDeck.show();
        System.out.println("----------------------------------------------------------------------------------");
        // Double check position is correct using the find method:
        int index = cardDeck.find(top);
        System.out.println("Top card is at index: " + index);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Card force Client Finished******");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("John Lee O'Connell\nB00757542\nCW2 COM498\n2nd Year Software Engineering");



    }

    private static DeckInterface cardForce(DeckInterface deck){
        int pos = getInput();
        //convert the int into a binary string
        String binaryInt = Integer.toBinaryString(pos);

        for(char letter: binaryInt.toCharArray()){
            if(letter == '0'){
                deck.inShuffle();
            } else if (letter == '1'){
                deck.outShuffle();
            } else {
                throw new IllegalArgumentException("Incorrect type supplied, expected type int.");
            }
        }
        return deck;
    }

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

