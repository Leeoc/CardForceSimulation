public interface DeckInterface<T> {
    public void addNew(T entry);
    public void show();
    public int getSize();
    public T getNode(int position);
    public void reveal();
    public void remove();
//    public void Deck(boolean cardDeck);
}
