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
        System.out.println("The top card is:");
        cardDeck.reveal();
        System.out.println("----------------------------------------------------------------------------------");
        // CARD FORCE TRICK
//        DeckInterface shuffle =
        System.out.println("Shuffling the Deck:\n");
        cardDeck.shuffle();
        cardDeck.reveal();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("******Card force Client Finished******");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("John Lee O'Connell\nB00757542\nCW2 COM498\n2nd Year Software Engineering");
        // FIND CARD IN DECK
//        getInput();


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

