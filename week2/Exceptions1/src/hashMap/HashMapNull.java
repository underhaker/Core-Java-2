package hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapNull extends HashMap {
    private boolean allowNull=false;
    public HashMapNull(Map<String, Integer> m) {
        this.putAll(m);
    }
    public void setNull(boolean allowNull){
        this.allowNull=allowNull;
    }
    @Override
    public Object put(Object key, Object value){
        //try {
             if (this.allowNull == false) {
                 if(key==null || value==null)
                     throw new NullKeyException();
                 return super.put(key, value);
             }
             else return super.put(key, value);
        //}
        //catch (NullKeyException e) {
        //    throw new NullKeyException();
        //}
    }
    @Override
    public Object get(Object key){
        if(this.allowNull==false){
            if(key==null)throw new NullKeyException();
            else return super.get(key);
        }
        else return super.get(key);
    }
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        HashMapNull hm = new HashMapNull(m);
        hm.setNull(false);
        //hm.seeNull();
        //hm.get(key)
        hm.put(null, 5);
        hm.get(null);
    }
}
