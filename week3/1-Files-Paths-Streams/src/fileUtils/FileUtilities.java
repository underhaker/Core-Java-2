package fileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilities {
    private FileUtilities(){
        
    }
    public static String readFrom(File file) throws FileNotFoundException,IOException{
        String str="",currentLine="";
        try(BufferedReader inputStream = new BufferedReader(new FileReader(file))){
            while((currentLine=inputStream.readLine())!=null)
            str+=new StringBuffer(currentLine).toString();
            return str;
        } 
    }
    public static String readFrom(Path path) throws FileNotFoundException,IOException{
        return readFrom(new File(path.toString()));
    }
    public static void writeTo(String str,File file) throws IOException{
        try(PrintWriter os = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            os.write(str);
        }
    }
    public static void writeTo(String str,Path path) throws IOException{
        writeTo(str,new File(path.toString()));
    }
    public static void main(String[] args) {
        File file=new File("rsc/test.txt");
        try {
            System.out.println(readFrom(file));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Path path= Paths.get("rsc/abv.txt");
        String str="chushkopek\nmeso";
        try {
            writeTo(str,path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
