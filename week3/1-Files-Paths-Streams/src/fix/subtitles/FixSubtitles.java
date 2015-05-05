package fix.subtitles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FixSubtitles {
    
    public static void fixEncoding(Path path) throws IOException{
        File file=new File(path.toString());
//        System.out.println(path+".backup");
        File fileBackup=new File(path+".backup");
        if(!fileBackup.exists()){
        Files.copy( file.toPath(), fileBackup.toPath() );
        fileBackup.createNewFile();
        }
//        String currentLine="",str="";
//        FileUtils.write(file, "");
//        try(BufferedReader inputStream = new BufferedReader(Paths.get(fileBackup), Charset.forName("ISO-8859-1")){
//            try(BufferedReader inputStream = new BufferedReader(new FileReader(fileBackup))){
//            while((currentLine=inputStream.readLine())!=null){
//                str+=new StringBuilder(String.format("%s%n", currentLine)).toString();
//            }
//            FileUtils.write(file, convertEncoding(str), true);
//        }
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))){
                bw.write(new String(encoded,"windows-1251"));
        }
//      try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("dest.txt")), "UTF-8")))
    }
//    private static String convertEncoding(String str){
//        try{
//            byte[] utf8Bytes=str.getBytes("UTF-8");
//            String newString=new String(utf8Bytes,"U");
////            System.out.println(newString);
//            return String.format("%s%n", newString);
//        }
//        catch(UnsupportedEncodingException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
    public static void main(String[] args) {
        File file=new File("rsc/lost.s04e11.hdtv.xvid-2hd.srt");
        try {
            fixEncoding(file.toPath());
            File filehtml=new File(file.toPath()+".html");
            if(filehtml.exists())filehtml.delete();
            Files.copy( file.toPath(), filehtml.toPath() );
            filehtml.createNewFile();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
