/**
 * Deck List class, an ADT used to store objects of the Card class
 * Implemented by the Deck Interface.
 * COM498 Coursework 2
 * B00757542
 * John Lee O'Connell
 * @param <T> The Data type you want to use.
 */

public class Deck<T> implements DeckInterface<T> {

    // Private Method variables:
    private Node firstNode;
    private int currentSize;

    /**
     * Main contructor for the list, will init the list with null values.
     */
    public Deck(){
        //init a empty list
        init();
    }

    /**
     * Public method to add a new entry into the list.
     * @param newEntry the data you want to add into the list.
     */
    public void addNew(T newEntry){

        Node tempNode = new Node(newEntry);
        // Check if the contains nodes, if not then add entry to the end of the list
        if(isEmpty()){
            firstNode = tempNode;
        } else {
            Node last = getNodeAt(currentSize);
            last.setNext(tempNode);
        }
        currentSize++;
    }

    /**
     * Public method used to remove the last node in the list.
     * If only one entry in list the list will be set to null.
     */
    // TODO: Need to add a last varible in the Node class to make this process more efficent.
    // TODO: This works but not very well lol. 
    public void remove(){
        if (isEmpty()){
            init();
        } else {
            Node Newlast = getNodeAt(currentSize - 1);
            currentSize--;

        }
    }

    /**
     * Public method to print the entire contents of the list to the console.
     */
    public void show(){
        System.out.println("The Deck contains: ");

        // Set the current node to the first node in the list
        Node current = firstNode;

        //loop through all the entries in the list and display their contents
        for(int i = 0; i < currentSize; i++){
            System.out.print(current.getData());
            // set the current node to be the next node in the list
            current = current.getNext();
        }
    }

    /**
     * Public method to get the current size of the List.
     * @return int value of the current list size.
     */
    public int getSize(){
        return currentSize;
    }

    /**
     * Method to get the node at a integer position within the list.
     * @param position the position of the node you want to find within the list as a Integer.
     * @return the data of the node at the specified position.
     */
    public T getNode(int position){
        if((position <= currentSize) && (position > 0)){
            return getNodeAt(position).getData();
        }else{
            throw new IndexOutOfBoundsException("Position is not valid.");
        }
    }

    /**
     *  Public Method to show the top card in the deck.
     */
    public void reveal(){
        assert (getSize() > 0);
        if(getSize() > 0) {
            T showNode = getNode(1);
            try {
                Card showCard = (Card) showNode;    //cast the ADT to a card to use its show method.
                showCard.show();
            } catch (Exception IllegalArgumentException) {
                System.out.println("\nIncorrect Data type, expected type of class Card.");
            }
        } else {
            throw new IndexOutOfBoundsException("\nList has not been created.");
        }
    }


    /**
     * Private helper method to return the node at certain index value.
     * @param position int used to define what node you need to find
     * @return the Node specified from the given int position.
     */
    private Node getNodeAt(int position){
        Node current = firstNode;

        for (int i = 1; i < position; i++){
            current = current.getNext();
        }
        // Make sure current node isnt null
        assert current != null;
        return current;
    }


    /**
     * Private helper method to initialize the list.
     * Sets the construction variables to default values for an empty list.
     * Also used to clear the list.
     */
    private void init(){
        firstNode = null;
        currentSize = 0;
        System.out.println("List Created.");
    }


    /**
     * Checks if the current list is empty.
     * @return boolean value, true for the list being empty.
     */
    private boolean isEmpty(){
        boolean result;
        if (currentSize == 0){
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        }
        return result;

    }


    /**
     * Private Node class used to hold the Linked list data.
     */
    private class Node {

        //instance variables
        private T nodeData;
        private Node next;

        /*
        Private constructors for new nodes
         */
        private Node(T data){
            this.nodeData = data;
            this.next = null;
        }

        private Node(T data, Node link){
            this.nodeData = data;
            this.next = link;
        }

        /*
        Getter and Setters
         */
        private T getData(){
            return this.nodeData;
        }

        private void setData(T data){
            this.nodeData = data;
        }

        private Node getNext(){
            return this.next;
        }

        private void setNext(Node next){
            this.next = next;
        }
    }
}
