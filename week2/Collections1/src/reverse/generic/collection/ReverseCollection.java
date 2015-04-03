package reverse.generic.collection;

import java.util.ArrayList;
import java.util.Collection;

public class ReverseCollection {
    public static <T> void reverse(Collection<T> collection) {
        Object arr[] = collection.toArray();
        for (int i = 0; i < arr.length / 2; i++) {
            Object tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        collection.clear();
        for (int i = 0; i < arr.length; i++)
            collection.add((T) arr[i]);

    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0; i<=10; i++){
            al.add(i);
        }
        reverse(al);
        for(int i=0; i<=10; i++){
            System.out.print(al.get(i)+" ");
            //al.add(i);
        }
    }
}
