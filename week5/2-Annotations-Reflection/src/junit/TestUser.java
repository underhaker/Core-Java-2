package junit;

public class TestUser {
    User user;
    String name;
    int age;
    @Before
    public void init(){
//        System.out.println("init runned!");
        user = new User();
    }
    @Execute
    public void test(){
//        System.out.println("test runned!");
        user.setAge(2);
        user.setName("Pesho");
        user.doubleAge();
    }
    @After
    public void tearDown(){
//        System.out.println("tearDown runned!");
        user=null;
    }
}
