package implement.collection;

import java.util.ArrayList;

public class ImplementCollection<T> extends ArrayList<T>{
    ArrayList<T> arr = new ArrayList<T>();
    
    @Override
    public boolean add(T e) {
        
            if(this.contains(e)){
                this.remove(e);}
             return super.add(e);
        }
        // TODO Auto-generated method stub
    
    public static void main(String[] args) {
        
    }

}
