public interface DeckInterface<T> {
    void addNew(T entry);
    void show();
    int getSize();
    T getNode(int position);
    T reveal();
    void remove();
    void shuffle();
    void swapNode(int firstIndex, int secondIndex);
    int find(T data);
//    public void Deck(boolean cardDeck);
//    public void Deck(boolean cardDeck);
}
