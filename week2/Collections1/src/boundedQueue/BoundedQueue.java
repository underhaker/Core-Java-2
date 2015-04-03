package boundedQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
public  class BoundedQueue<T> implements Queue<T>{
    private int m_size;
    private Node front=null;
    private Node rear=null;
    private int c_size;
    public BoundedQueue(int size) {
        m_size=size;
        c_size=0;
    }
    
    @Override
    public boolean offer(T e) {
        //System.out.println(size() + " " + m_size);
        if(size()>=m_size){remove();}
        Node n=new Node(e);
        if(front == null && rear==null)
            front=rear=n;
        else{
            rear.next=n;
            rear=rear.next;
        }
        c_size++;
        return true;
    }
    @Override
    public String toString(){
        String result="";
        while(size()!=0){
            //System.out.println(size());
            if(size()==0)break;
            result+=new StringBuffer(remove().toString()+" ").toString();
            //System.out.println(result);
            
        }
        return result;
    }
    @Override
    public T remove() {
        //System.out.println(size() + " " + m_size);
        Node temp;
        if(front==null && rear==null)throw new NoSuchElementException();
        if(front==rear && front.next==null){
            temp=front;
            front=rear=null;
            return (T)temp.data;
        }
        else
        {
            temp=front;
           
            front=front.next;
           // System.out.println(front.next.data.toString());
            c_size--;
            return  (T)temp.data;
        }
    }
    @Override
    public int size() {
        if(front==null && rear==null)return 0;
        return c_size;
    }
    public static void main(String[] args) {
        BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(3);
        boundedQueue.offer(1);
        boundedQueue.offer(2);
        boundedQueue.offer(3);
        boundedQueue.offer(4);
        boundedQueue.offer(5);
        System.out.println(boundedQueue.toString());
    }
    

    @Override
    public void clear() {
        while(size()!=0){
            //System.out.println(size());
            if(size()==0)break;
            remove();
            //System.out.println(result);
            
        }
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(c_size==0)return true;
        return false;
    }

    

    @Override
    public boolean remove(Object arg0) {
        
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(T e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T peek() {
        if(front==null)throw new NoSuchElementException();
        return (T)front.data;
    }

    @Override
    public T poll() {
        return remove();
    }

   
    
}

