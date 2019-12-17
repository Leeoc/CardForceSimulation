import java.util.Scanner;

/**
 * Public class for the Card Force Client Application
 */

public class CardForceClient {

    public static void main(String[] args){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Card Force Client");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Instantiating the Deck.");
        DeckInterface<Card> cardDeck = new Deck<>();
        cardDeck.show();
        cardDeck.reveal();
        // CARD FORCE TRICK
        getInput();
        cardDeck.show();
        // FIND CARD IN DECK
        getInput();


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

