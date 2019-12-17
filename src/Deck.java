/**
 * Deck List class, an ADT used to store objects of the Card class
 * Implemented by the Deck Interface.
 * COM498 Coursework 2
 * B00757542
 * John Lee O'Connell
 * @param <T> The Data type you want to use.
 */

import java.util.Random;

public class Deck<T> implements DeckInterface<T> {

    // Private Method variables:
    private Node firstNode;
    private int currentSize;

    /**
     * Main constructor for the list, will init the list with null values. And create a deck of card objects within the
     * list that has been created.
     */
    public Deck(){
        init();
        if(true) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 13; j++) {
                    Card tempCard = new Card(j, i);  // creates a new card using int constructor
                    addNew((T)tempCard);
                }
            }
        }
    }

    public Deck(boolean empty){
        if (empty == true) {
            init();
        } else {
            throw new IllegalArgumentException("Cannot init list, try using default constructor. i.e Deck()");
        }
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
     * Public method to add a new entry at a given position into the list.
     * @param position int for the position to be added to
     * @param newEntry the data to be added into the list
     */
    public void addNew(T newEntry, int position) {
        if ((position >= 1) && (position <= currentSize + 1)) {
            assert position > 0;
            Node newNode = new Node(newEntry);

            if (position == 1) {
                // Add node to first position in the list:
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(position - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            currentSize++;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
    }

    /**
     * Public method used to remove the last node in the list.
     * If only one entry in list the list will be set to null.
     */
    // TODO: Need to add a last variable in the Node class to make this process more efficent.
    // TODO: This works but not very well lol.
    public void remove(){

        if (isEmpty()) {
            init();
        } else {
            Node Newlast = getNodeAt(currentSize - 1);
            currentSize--;
        }
    }

    /**
     * Public method to remove a node at a given int index position.
     * @param position int index of the node to be removed.
     */
    //TODO: Add a new removeAt method to remove a node at a given index.
    public void removeAt(int position){
        if(isEmpty()){
            init();
        } else if ((position > 0) && (position <= currentSize) && (!isEmpty())){

        } else {
            throw new IndexOutOfBoundsException("Position isn't valid.");
        }
    }


    /**
     * Public method to print the entire contents of the list to the console.
     */
    public void show(){
        assert !isEmpty();
        if (!isEmpty()) {
            System.out.println("The Deck contains: \n");

            // Set the current node to the first node in the list
            Node current = firstNode;

            //loop through all the entries in the list and display their contents
            for (int i = 0; i < currentSize; i++) {
                try {
                    Card tempCurrent = (Card) current.getData();
                    Card showCard = tempCurrent;    //cast the ADT to a card to use its show method.
                    showCard.show();
                } catch (Exception IllegalArgumentException) {
                    System.out.println(current.getData());
                }
                current = current.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException("List is empty");
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
    public T reveal(){
        assert (getSize() > 0);
        if(getSize() > 0) {
            T showNode = getNode(1);
            try {
                Card showCard = (Card) showNode;    //cast the ADT to a card to use its show method.
                System.out.println("The top card in the deck is:");
                showCard.show();
                return (T)showCard;
            } catch (Exception IllegalArgumentException) {
                System.out.println("\nIncorrect Data type, expected type of class Card.");
            }
        } else {
            throw new IndexOutOfBoundsException("\nList has not been created.");
        }
        return null;
    }

    /**
     * Public method to randomly shuffle the deck.
     */
    //TODO: Clean up the code, find a way to make sure the two random ints dont match and stay within bounds.
    public void shuffle(){
//        Random rand = new Random();
        for(int i = 1; i < currentSize; i++){
            int rand = (int)(Math.random() * currentSize) + 1;
            int rand2 = (int)(Math.random() * currentSize) + 1;
//            System.out.println("random= " + rand + "random2 = " + rand2);
            try {
                swapNode(rand, rand2);
            } catch (Exception E){
                swapNode(13,44);
            }
        }

    }


    /**
     * Private helper method to swap two nodes in the list
     * @param firstIndex the index of the first node to be swapped.
     * @param secondIndex the index of the second node to be swapped.
     */
    public void swapNode(int firstIndex, int secondIndex){
        assert !isEmpty();

        if(firstIndex > 0 && firstIndex <= currentSize && secondIndex > 0
                && secondIndex <= currentSize && firstIndex != secondIndex){

            //get the nodes data.
            Node firstNode = getNodeAt(firstIndex);  //DATA OF THE NODES ie card
            Node secondNode = getNodeAt(secondIndex);
            // swap the data of the two nodes not the node links
            T firstData = firstNode.getData();
            T secondData = secondNode.getData();
            firstNode.setData(secondData);
            secondNode.setData(firstData);

        } else {
            throw new IndexOutOfBoundsException("Invalid index used.");
        }
    }

    public int find(T data){
        return sequentialSearch(data,firstNode,1);
    }

    /**
     * Private method for recursively searching the list for a given nodes data.
     * @param data the node to be found
     * @param currentNode current node being searched
     * @param index int current index of the node being searched
     * @return index of the data in the list, if not found will return with 0;
     */
    private int sequentialSearch(T data, Node currentNode, int index){

        assert !isEmpty();
        boolean found = false;

        if (found){
            return index;
        }
        if(currentNode == null){
            found = false;
        } else if(data.equals(currentNode.getData())){
            found = true;
            return index;
        } else {
            index = sequentialSearch(data, currentNode.getNext(), index);
            index++;
            return index;
        }
        return 0;   // returns a invalid value if it isnt found.
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
        // Make sure current node isn't null
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
