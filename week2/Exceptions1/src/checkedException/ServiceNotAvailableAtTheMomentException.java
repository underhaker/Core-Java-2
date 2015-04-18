package checkedException;

public class ServiceNotAvailableAtTheMomentException extends Exception{
    private String reason;
    public ServiceNotAvailableAtTheMomentException(String reason) {
        this.reason=reason;
    }
    public String ExceptionMessage(){
        return "Service is not Available at the moment,because "+ reason; 
    }
}
