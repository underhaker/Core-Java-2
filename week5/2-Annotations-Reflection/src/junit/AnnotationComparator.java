package junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Comparator;

public class AnnotationComparator implements Comparator<Method> {

    @Override
    public int compare(Method m1, Method m2) {
        Before b1 = m1.getAnnotation(Before.class);
        Before b2 = m2.getAnnotation(Before.class);
        if(b1.priority()<b2.priority())return -1;
        else return 1;
        // TODO Auto-generated method stub
    }

    

    

    
    
}
