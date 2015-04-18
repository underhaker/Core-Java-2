package checkedException;

public class User {
    private Integer service;
    private String[] streets;
    private String town;
    public User(String town,Integer service){
        this.town=town;
        //streets[0]=town;
        this.service=service;
    }
    public void breakService() throws ServiceNotAvailableAtTheMomentException{
        
        //int index=0;
        
        //System.out.println(town+" "+streets[index]);
        if(this.service==0)
        throw new ServiceNotAvailableAtTheMomentException("No service");
        else
            System.out.println(town);
        
    }
    public static void main(String[] args) throws ServiceNotAvailableAtTheMomentException{
        User b=new User("Pleven",0);
        try{
        b.breakService();
        }
        catch(ServiceNotAvailableAtTheMomentException e){
            //System.out.println(ServiceNotAvailableAtTheMomentExcepti);
            e.printStackTrace();
        }
    }
}
