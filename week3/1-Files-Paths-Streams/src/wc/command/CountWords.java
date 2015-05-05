package wc.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountWords extends WordCountResult {
    public CountWords(int word_count, int lines_count, int characters_count) {
        super(0,0,0);
        // TODO Auto-generated constructor stub
    }

    public static WordCountResult wordCount(Path path) throws IOException{
        return wordCount(new File(path.toString()));
    }
    public static WordCountResult wordCount(File file) throws IOException{
        String str="",currentLine=null;
        int word_count=0,lines_count=0,character_count=0;
        int line_counter=0;
        try(BufferedReader inputStream = new BufferedReader(new FileReader(file))){
            while((currentLine=inputStream.readLine())!=null){
                line_counter++;
                str+=new StringBuffer(currentLine+" ").toString();
            }
            character_count=str.length()-line_counter;
            lines_count=line_counter;
            word_count=str.split(" ").length;
            WordCountResult wcr=new WordCountResult(word_count,lines_count,character_count);
            return wcr;
        } 
    }
    public static void main(String[] args) {
        File file = new File("rsc/test.txt");
        Path path = Paths.get("rsc/test.txt");
        try {
            String result=wordCount(path).toString();
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
