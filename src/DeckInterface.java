public interface DeckInterface<T> {
    void addNew(T entry);
    void show();
    int getSize();
    T getNode(int position);
    void reveal();
    void remove();
    void shuffle();
    void swapNode(int firstIndex, int secondIndex);
//    public void Deck(boolean cardDeck);
//    public void Deck(boolean cardDeck);
}
