package stack;

public class StackV2<Item> implements Stack<Item>{
    private Item stackArray[];
    private int top;
    private final static int DEFAULT_SIZE = 10;
    public StackV2(){
        this(DEFAULT_SIZE);
    }
    public StackV2(int s){
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
        for(Item itm:stackArray){
            if(x==itm){System.out.println("No duplicates allowed! Push another element!");return;}
        }
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
        Stack <Integer> s = new StackV2<Integer>();
        s.push(20);
        s.push(20);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
     
        System.out.println("Size of the stack: " + s.size());
    }
}
