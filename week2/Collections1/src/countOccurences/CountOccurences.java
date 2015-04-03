package countOccurences;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountOccurences {
    private static int numberOfOccurences(String source,String sentence){
        int occurences=0;
        if(source.contains(sentence)){
            int originalLength=source.length();
            int withoutLength=source.replace(sentence, " ").length();
            occurences=(originalLength-withoutLength)/sentence.length();
        }
        return occurences+1;
    }
    public static Map countOccurences(String str){
        Map<String,Integer> result=new LinkedHashMap<String,Integer>();
        String[] stringArray=str.split(" ");
        //for(int i=0; i<stringArray.length; i++)
        //        System.out.println(stringArray[i]);
        for(int i=0; i<stringArray.length; i++){
            result.put(stringArray[i], numberOfOccurences(str,stringArray[i]));
        }
        return result; 
    }
    public static void main(String[] args) {
        Map<String,Integer>m=CountOccurences.countOccurences("Ninjas are all over the place! We are all going to die!");
        System.out.println(MapToString.convertToString(m));
    }
}
