package immutableList;

public class ImmutableException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public ImmutableException(String msg){
        super(msg);
    }
    /*public String getMessage(){
        return "Immutable list:cannot modify elements.";
    }*/
}
