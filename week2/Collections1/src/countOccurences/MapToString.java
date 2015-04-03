package countOccurences;

import java.util.Map;
import java.util.Set;

public class MapToString {
    public static String convertToString(Map<String,Integer> hm){
        String result="{ ";
        int i=0;
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        for (Map.Entry<String, Integer> entry : set){
            String key = entry.getKey();
            Integer value = entry.getValue();
            i++;
            if(i<hm.size()-1)
            result+=new StringBuffer(key+":"+value+", ").toString();
            else
            result+=new StringBuffer(key+":"+value).toString();
            // ...
        }
        return result+" }";
    }
}
