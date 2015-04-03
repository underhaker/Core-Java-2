package duplicateSets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DuplicatedElements {
    static Set getDuplicatedElements(Set... sets){
        Set min_set=new HashSet();
        Set new_set=new HashSet();
        int min_size=sets[0].size();
        for(Set set: sets){
            if(set.size()<min_size){min_size=set.size(); min_set=set;}
        }
        Iterator<Integer> iterator_min = min_set.iterator();
        Integer k1=0;
        while(iterator_min.hasNext()) {
            Integer min_setElement = iterator_min.next();
            boolean isDuplicate=true;
            for(Set set: sets){
                if(min_set!=set){
                        
                        if(!set.contains(min_setElement)){isDuplicate=false;break;}
                }
            }
            if(isDuplicate==true)new_set.add(min_setElement);
        }
        return new_set;
    }

    public static void main(String[] args) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        Set s3 = new HashSet();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);
        s1.add(5);
        s2.add(4);
        s2.add(5);
        s2.add(1);
        s3.add(5);
        s3.add(6);
        s3.add(7);
        s3.add(1);
        Set s4 = new HashSet();
        s4 = getDuplicatedElements(s1, s2, s3);
        System.out.println(s4.size());
    }
    /*
     * A = {1,2,3,4,5} B = {4,5,6} C = {5,6,7,8}
     */
}
