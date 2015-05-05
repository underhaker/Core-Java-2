package test;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import properties.PropertiesParser;


public class TestProperties1 {
    File file;
    Map<String,String> m=new HashMap<String,String>();
    PropertiesParser p=new PropertiesParser();
    @Before
    public void init() throws IOException{
        
        file=new File("rsc/a.properties");
        String str="# this=comment\na1=b1\na2 =b2\na3    =    b3\n   a4 = b4\na5=b6=b7=b8\na6=b9 #comment\na7==b10\n";
        try(PrintWriter os = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            os.write(str);
        }
    }
    @Test
    public void testCase1() {
        try {
            String result="";
            m=p.parseProperties(file);
            Set<Map.Entry<String, String>> set = m.entrySet();
            int i=0;
            for (Map.Entry<String, String> entry : set){
                if(i!=0)result+=new StringBuffer("\n").toString();
                String key = entry.getKey();
                String value = entry.getValue();
                result+=new StringBuffer(key+" " + value).toString();
                i++;
            }        
            String expected="a1 b1\na2 b2\na3     b3\na4  b4\na5 b6=b7=b8\na6 b9 #comment\na7 =b10";
            assertEquals(expected,result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
