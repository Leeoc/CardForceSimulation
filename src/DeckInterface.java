/**
 * Public interface Deck Interface
 * Implemented by the Deck class, an ADT linked list.
 * @param <T> the data type to instantiate the list with.
 * COM498 Coursework 2
 * B00757542
 * John Lee O'Connell
 */
public interface DeckInterface<T> {

    /**
     * addNew, adds a new entry to the end of the current list.
     * @param entry T the data to be added to the list.
     */
    void addNew(T entry);

    /**
     * addNew, adds a new entry to the list at a given position.
     * @param entry T the data to be added to the list.
     * @param position int the position in the list where the data will be added.
     */
    void addNew(T entry, int position);

    /**
     * show, displays the full contents of the list printing them to the console.
     */
    void show();

    /**
     * getSize, returns the current size of the list.
     * @return int of the current list size.
     */
    int getSize();

    /**
     * getNode, gets the node at a user specified position
     * @param position int the position of the node in the list.
     * @return T the data of the node.
     */
    T getNode(int position);

    /**
     * reveal, displays the top item in the list.
     * @return T the data of the top node.
     */
    T reveal();

    /**
     * remove, removes the node at the end of the list.
     */
    void remove();

    /**
     * shuffle, randomly shuffles items in the list.
     */
    void shuffle();

    /**
     * swapNode, used to swap two nodes in the list.
     * @param firstIndex int index of the first node to swap.
     * @param secondIndex int index of the second node to swap.
     */
    void swapNode(int firstIndex, int secondIndex);

    /**
     * find, used to find a certain node within the list containing data.
     * @param data T the data to be found.
     * @return int the index of the node containing the data.
     */
    int find(T data);

    /**
     * inShuffle, used to perform an in shuffle on the list.
     * Will create 2 new lists during execution.
     */
    void inShuffle();

    /**
     * outShuffle, used to perform an out shuffle on the list.
     * Will create 2 new lists during execution.
     */
    void outShuffle();

}
