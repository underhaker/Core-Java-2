package junit;

public class TestUser {
    User user;
    String name;
    int age;
    @Before(priority = 1)
    public void init(){
        System.out.println("init1 runned!");
        user = new User();
    }
    @Before(priority = 2)
    public void init2(){
        System.out.println("init2 runned!");
//        user = new User();
    }
    @Execute
    public void test(){
        System.out.println("test runned!");
        user.setAge(2);
        user.setName("Pesho");
        user.doubleAge();
    }
    @After
    public void tearDown(){
        System.out.println("tearDown runned!");
        user=null;
    }
}
