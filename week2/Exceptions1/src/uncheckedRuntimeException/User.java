package uncheckedRuntimeException;

public class User {
    private String username;
    private String password;
    public User(String username,String password){
        //if(username=="")throw new DatabaseCorruptedException();
        this.username=username;
        this.password=password;
    }
    public void logIn(String username,String password) throws DatabaseCorruptedException{
        if(this.username=="")throw new DatabaseCorruptedException();
        if(username.equals(this.username))
            if(password.equals(this.password))
                System.out.println("Logged in successfuly!");
            else System.out.println("Wrong password!");
        else System.out.println("Wrong username");
    }
    public static void main(String[] args) {
        User b=new User("","kondio");
        b.logIn("", "kondio");
    }
}
