package studentComparator;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        String name1=s1.getName();
        String name2=s2.getName();
        double grade1=s1.getGrade();
        double grade2=s2.getGrade();
        if(grade1<grade2)return -1;
        else if(grade1>grade2) return 1;
        else return name1.compareToIgnoreCase(name2);
        //return grade1<grade2 ? -1 : grade1==grade2 ? s1.getName().equals(s2.getName()) ? :1;
    }

}
