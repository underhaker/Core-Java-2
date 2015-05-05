package junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnit {
    public static void run(Class<?> classToTest) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Method[] methods=classToTest.getMethods();
        TestUser testUserInstance=new TestUser();
        Object object = null;
        for(Method method : methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            //before
            for(Annotation annotation: annotations){
                if(annotation instanceof Before){
                    object=method.invoke(testUserInstance);
                    break;
                }
            }
            //execute
            for(Annotation annotation: annotations){
                if(annotation instanceof Execute){
                    object=method.invoke(testUserInstance);
                    break;
                }
            }
            //after
            for(Annotation annotation: annotations){
                if(annotation instanceof After){
                    object=method.invoke(testUserInstance);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            JUnit.run(TestUser.class);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
