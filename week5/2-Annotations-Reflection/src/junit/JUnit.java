package junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JUnit {
    public static void run(Class<?> classToTest) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Method[] methods=classToTest.getMethods();
        TestUser testUserInstance=new TestUser();
//        Object object = null;
        List<Method> listBefore =new ArrayList<Method>();
        List<Method> listExecute =new ArrayList<Method>();
        List<Method> listAfter =new ArrayList<Method>();
        for(Method method : methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            //before
            for(Annotation annotation: annotations){
                if(annotation instanceof Before){
                    listBefore.add(method);
                }
            }
            //execute
            for(Annotation annotation: annotations){
                if(annotation instanceof Execute){
                    listExecute.add(method);
                }
            }
            //after
            for(Annotation annotation: annotations){
                if(annotation instanceof After){
                    listAfter.add(method);
                }
            }
        }
        //before
        Collections.sort(listBefore,new AnnotationComparator());
        for(Method method: listBefore){
            method.invoke(testUserInstance);
        }
        //execute
        for(Method method: listExecute){
            method.invoke(testUserInstance);
        }
        //after
        for(Method method: listAfter){
            method.invoke(testUserInstance);
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
