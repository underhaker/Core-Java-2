package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PropertiesParser {
    //private Map<String, String> hm = new HashMap<String, String>();
    private static List<String> al = new ArrayList<String>();

    public static Map<String, String> parseProperties(File file) throws IOException {
        String str = "", currentLine = "";
        Map<String, String> hm = new HashMap<String, String>();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            while ((currentLine = inputStream.readLine()) != null) {
                al.add(currentLine);
            }
            return parse(al);
            
        }

    }

    private static  Map<String, String> parse(List<String> al) {
        // currentLine=currentLine.replaceAll(" ", "");
        Map<String, String> hm = new HashMap<String, String>();
        String currentLine = "";
        for (int i = 0; i < al.size(); i++) {
            currentLine = new StringBuffer(al.get(i)).toString();
            
            if(currentLine.startsWith("#"))continue;
            int index = currentLine.indexOf('=');
            String key = currentLine.substring(0, index);
            key=key.trim();
            String value = currentLine.substring(index + 1, currentLine.length());
            hm.put(key, value);
        }
        return hm;
    }
//    public static void main(String[] args) {
//        Map<String,String> m=new HashMap<String,String>();
//        File file=new File("rsc/a.properties");
//        try {
//            m=parseProperties(file);
//            Set<Map.Entry<String, String>> set = m.entrySet();
//            for (Map.Entry<String, String> entry : set){
//                String key = entry.getKey();
//                String value = entry.getValue();
//            }        
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}

// # this=comment
// a1=b1
// a2=b2
// a3=b3
// a4=b4
// a5=b6=b7=b8
// a6=b9#comment
// a7==b10