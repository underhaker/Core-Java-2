package uncheckedRuntimeException;

public class DatabaseCorruptedException extends RuntimeException{
    
    public String getMessage(){
        return "Corrupted Database! The username has an invalid format.";
    }
}
