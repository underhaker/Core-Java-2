package duplicateElements;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
public class DuplicateElements {
    
    public static Integer findUnique(Collection<Integer> collection){
        Integer answer=null;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        
        for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
             arr.add((Integer) iterator.next());
        }
        arr.sort(null);
        for(int i=0; i<arr.size()-2; i++){
            if(arr.get(i).equals(arr.get(i+1)))
                if(arr.get(i+1).equals(arr.get(i+2)));
                else {answer=arr.get(i+2);break;}
            else {answer=arr.get(i);break;}
        }
        return answer;
        
    }
    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
        System.out.println(findUnique(ints)); //2;
    }
}
