package classinfo;

import java.lang.annotation.Annotation;

@ClassInfo(author = "Yoan",related={String.class,Double.class})
public class User {
    private String value;
    User(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
    public void setValue(String value){
        this.value=value;
    }
    public static void main(String[] args) {
      User user = new User("Pesho");
//      ClassType classType = user.getClass();
      Annotation[] annotations=user.getClass().getAnnotations();
      for(Annotation annotation: annotations){
          System.out.println(annotation.toString());
      }
      ClassInfo annotation =user.getClass().getAnnotation(ClassInfo.class);
      System.out.println(annotation.checked());
    }
}
