/* Define a Deque interface. */
public interface Deque<Item> {
    public void addFirst(Item a);
    public void addLast(Item a);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
}
