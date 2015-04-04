package stack;

public interface Stack <Item> {

    public Item top();
    public Item pop();
    public int size();
    public boolean isEmpty();
    public void push(Item x);
    public void clear();
}
