package junit;

public class User {
    private String name;
    private int age;
    public User(){
        
    }
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void doubleAge(){
        String name=this.name;
        int age=this.age;
        System.out.println(name + "," + age*2);
    }
}
