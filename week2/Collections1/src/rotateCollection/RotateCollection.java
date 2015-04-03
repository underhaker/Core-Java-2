package rotateCollection;

import java.util.ArrayList;
import java.util.Collection;

public class RotateCollection {

    static void rotate(Collection<Integer> collection, int rotateStep) {
        Object arr[] = collection.toArray();
        Object arr_new[] = collection.toArray();
        if (rotateStep > 0) {
            for (int i = 0; i < arr.length; i++) {
                int j = i + rotateStep;
                if (j >= arr.length) {
                    while (j >= arr.length)
                        j -= arr.length;
                }
                arr_new[i] = arr[j];
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                int j = i + rotateStep;
                if (j < 0) {
                    while (j < 0)
                        j += arr.length;
                }
                arr_new[j] = arr[i];
                
            }
        }
        collection.clear();
        for (int i = 0; i < arr.length; i++)
            collection.add((Integer) arr_new[i]);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i <= 6; i++) {
            arr.add(i + 1);
        }
        rotate(arr, -1);
        for (int i = 0; i <= 6; i++)
            System.out.print(arr.get(i) + " ");
    }
}
