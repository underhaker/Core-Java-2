package stack;

public class StackImpl<Item> implements Stack<Item> {
    private Item stackArray[];
    private int top;
    public StackImpl(int s){
        stackArray=(Item[])new Object[s];
        top=-1;
    }
    public int size(){
        return (top+1);
    }
    public boolean isEmpty(){
        if(top==-1)return true;
        return false;
    }
    public Item top(){
       // if(top==-1)
         //   return null;
        return stackArray[top];
    }
    public void push(Item x){
        if(top==stackArray.length-1)
            resize(2*stackArray.length);
        stackArray[++top]=x;
    }
    public Item pop(){
        if(top==-1)
            return null;
        Item x=stackArray[top];
        stackArray[top--]=null;
        if(top>0 && top==stackArray.length/4)
            resize(stackArray.length/2);
        return x;
        
    }
    public void clear(){
        while(top!=0){
            stackArray[top--]=null;
        }
    }
    private void resize(int NewSize){
        Item tmp[]=(Item[]) new Object[NewSize];
        for(int i=0; i<=top; i++)
            tmp[i]=stackArray[i];
        stackArray=tmp;
    }
    public static void main(String [] args){
        
    }
}
