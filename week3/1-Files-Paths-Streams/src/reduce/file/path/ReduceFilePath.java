package reduce.file.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReduceFilePath {
    public static Path reducePath(Path path){
        return path.normalize();
    }
    public static void main(String[] args) {
        Path path=Paths.get("/home//radorado/code/./hackbulgaria/week0/../");
        System.out.println(reducePath(path).toString());
    }
}
