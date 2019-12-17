public class Test {
    public static void main (String[] args) {
        System.out.println("***Testing Started***");

        //set to null so the constructor can init the list as empty
        DeckInterface<Card> testingDeck= new Deck<>();
        DeckInterface<Integer> testInt = new Deck<>(true);
        Integer[] array = {10, 20, 30, 40};
        for(int i = 0; i < array.length; i++) {
            testInt.addNew(array[i]);
        }
        testInt.show();
        testInt.swapNode(1,2);
        testInt.show();
        int hello = testInt.find(20);

//        testingDeck = deck();
//        String tempSuit = "";
//        for(int i = 1; i < testingDeck.getSize(); i++){
//            Card temp;
//            temp = testingDeck.getNode(i);
//            tempSuit = temp.getSuit();
//            if(temp.getValue() > 0) {
//                temp.show();
//            } else {
//                System.out.println("\n\n");
//            }
//        }
        //TODO REMOVE THIS FOR TESTS
//        for(int i = 1; i < testingDeck.getSize(); i++){
//            Card temp = testingDeck.getNode(i);
//            temp.show();
//        }
        // show the top card in the deck
//        testingDeck.reveal();
//        testingDeck.shuffle();
//        testingDeck.show();


//        //test try catch
//        System.out.println("\n\n\n");
//        DeckInterface<Integer> incorrect = new Deck<>();
//        incorrect.addNew(10);
//        incorrect.addNew(27);
//        incorrect.show();
//        incorrect.remove();
//        incorrect.remove();
//        incorrect.show();

//        incorrect.reveal();
    }

//    public static DeckInterface deck(){
//            DeckInterface<Card> cardDeck = new Deck<>();
//            System.out.println("Creating Deck of Cards.");
//            // loop adding the cards to the list
//            for (int i = 0; i < 4; i++) {
//                for (int j = 1; j < 14; j++) {
//                    Card tempCard = new Card(j, i);  // creates a new card using int constructor
//                    cardDeck.addNew(tempCard);
//                }
//            }
//        System.out.println(cardDeck.getSize());
//            return cardDeck;
//    }
}


