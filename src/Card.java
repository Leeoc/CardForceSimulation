public class Card<T>{

    // Constructor variables:
    private int value;
    private String suit;
    private boolean face;
    private String colour;

    // Card Suits
    final String clubs = "Clubs";
    final String diamonds = "Diamonds";
    final String hearts = "Hearts";
    final String spades = "Spades";

    // Card Colours
    final private String black = "Black";
    final private String red = "Red";

    // Default Constructor variables:
    final private String colourDefault = black;
    final private int valueDefault = 1;
    final private boolean faceDefault = true;
    final private String suitDefault = clubs;


    /**
     * Default constructor for objects of CardUtil class
     * Value = 1
     * Suit = clubs
     * Face = True
     */
    public Card(){
        this.value = valueDefault;
        this.suit = suitDefault;
        this.face = faceDefault;
        this.colour = colourDefault;
    }


    /**
     * Alternative constructor for objects of CardUtil class
     * Takes params to create a specific card
     * @param value = Value of the card
     * @param suit = Suit of the card
     * @param face = bool value if the card is a face or show card
     */
    public Card(int value,String suit, boolean face, String colour){
        this.value = value;
        this.suit = suit;
        this.face = face;
        this.colour = colour;
    }


    /**
     * Alternative constructor for objects of CardUtil class
     * Takes params to create a specific card
     * @param value = Value of the card
     * @param suitInt = Suit of the card converted for creating a Deck of cards
     */
    public Card(int value,int suitInt){
        this.value = value;
        intConstruct(suitInt,value);
    }


    /**
     * Public method to show the suit, value, face and colour of the card.
     */
    public void show(){
        if(value >= 10 || value == 1) {
            String tempFaceName = "";
            if (value == 1) {
                tempFaceName = "Ace";
            } else if (value == 10) {
                tempFaceName = "Jack";
            } else if (value == 11) {
                tempFaceName = "Queen";
            } else if (value == 12) {
                tempFaceName = "King";
            }
            System.out.printf("The %s of %s. Face: %b, Colour: %s\n", tempFaceName, suit, face, colour);
        } else {
            System.out.printf("The %d of %s. Face: %b, Colour: %s\n", value, suit, face, colour);
        }
    }

    /**
     * Set current cards value.
     * @param val int to set value too.
     */
    public void setValue(int val){
        this.value = val;
    }

    /**
     * Set current cards suit
     * @param suit String to set suit too.
     */
    public void setSuit(String suit){
        this.suit = suit;
    }

    /**
     * Get the suit of the current card.
     * @return String containing the suit of the card.
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * Get the value of the current card.
     * @return int containing the value of the card.
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Private Method to convert Int input to card value, card colour, card face
     * @param suitInt suit number value from constructor
     * @param val card number value from constructor
     */
    private void intConstruct(int suitInt, int val){
        if ((val <= 13) && (suitInt <= 4)) {
            // Convert int to a suit string:
            if (suitInt == 0) {
                this.suit = clubs;
                this.colour = black;
            } else if (suitInt == 1) {
                this.suit = diamonds;
                this.colour = red;
            } else if (suitInt == 2) {
                this.suit = hearts;
                this.colour = red;
            } else if (suitInt == 3) {
                this.suit = spades;
                this.colour = black;
            }

            // Automatically set Face depending on value of card:
            this.face = value < 10 && value != 1;
        } else {
            throw new IndexOutOfBoundsException("Card/Suit value out of bounds");
        }
    }
}
