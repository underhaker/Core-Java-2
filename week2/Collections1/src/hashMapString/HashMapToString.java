package hashMapString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapToString extends HashMap{
    public static String convertToString(HashMap hm){
        String result="{ ";
        int i=0;
        Set<Map.Entry<Object, Object>> set = hm.entrySet();
        for (Map.Entry<Object, Object> entry : set){
            Object key = entry.getKey();
            Object value = entry.getValue();
            i++;
            result+=new StringBuffer(key+","+value+" ").toString();
            // ...
        }
        return result+" }";
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        hm.put("Pesho", 112);
        hm.put("Kondio", 255);
        hm.put("Nu Pagadi", 76);
        hm.put("Strahil",5);
        String result=HashMapToString.convertToString(hm);
        System.out.println(result);
    }
}
