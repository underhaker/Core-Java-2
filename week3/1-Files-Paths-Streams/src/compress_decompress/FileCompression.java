package compress_decompress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import fileUtils.FileUtilities;

public class FileCompression {
    private static String[] wordsOriginal;
    private static LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
    public static void compress(Path filePath) throws FileNotFoundException, IOException{
        String currentLine="",str="";
        
        try(BufferedReader inputStream = new BufferedReader(new FileReader(filePath.toFile()))){
            int j=0;
            while((currentLine=inputStream.readLine())!=null){
                if(j!=0)
                str+=new StringBuilder(String.format("%n%s", currentLine)).toString();
                else str+=new StringBuilder(currentLine).toString();
                j++;
            }
            
            wordsOriginal=str.split(" ");
            Set<String> s=new LinkedHashSet<String>();
            Collections.addAll(s, wordsOriginal);
            int compressionCounter=0;
            for(String word1: s){
                    str=str.replaceAll(word1, "~"+compressionCounter);
                    compressionCounter++;
            }
            String[] wordsCompressed=str.split(" ");
//            for(String word1: wordsOriginal){
//                System.out.print(word1+" ");
//            }
////            System.out.println();
//            for(String word1: wordsCompressed){
//                System.out.print(word1+" ");
//            }
            for(int i=0; i<wordsOriginal.length; i++){
//                System.out.println(wordsOriginal[i]+ " " +wordsCompressed[i]);
                hm.put(wordsOriginal[i], wordsCompressed[i]);
            }
            String orgCmprStr="";
            for (Map.Entry<String, String> entry : hm.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                orgCmprStr+=new StringBuilder(String.format("%s %s%n", key,value)).toString();
                // ...
            }
            File file=new File(filePath+".compr");
            File compressedFile=new File(filePath+".org");
            FileUtilities.writeTo(orgCmprStr, compressedFile);
            try(PrintWriter os = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
                os.write(str);
            }
        }
    }
    //decompress
    public static void decompress(Path filePath){
        
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file=new File("rsc/file1.txt");
        compress(file.toPath());
    }
}
