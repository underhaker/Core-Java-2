package find.broken.links;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindBrokenLinks {
    public static void findBrokenLinks(Path directoryPath) throws IOException{
        File directory=directoryPath.toFile();
        File[] fList=directory.listFiles();
        for(File file: fList){
            if(file.isFile()){
                boolean isBroken=Files.isSymbolicLink(file.toPath());
                if(isBroken==true){
                    Path link=Files.readSymbolicLink(file.toPath());
                    System.out.println("Broken link:"+file.getAbsolutePath()+"\\"+link);
                }
            }
            else if(file.isDirectory()){
                findBrokenLinks(file.toPath());
            }
        }
    }
    public static void main(String[] args) {
        Path path=Paths.get("C:/users/Joni/desktop/NewFolder");
        try {
            findBrokenLinks(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
