package hashMap;

public class NullKeyException extends NullPointerException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String getMessage(){
        return "This HashMap is designed to not have a null key or value.Change this by using the setNull method.";
    }
}
