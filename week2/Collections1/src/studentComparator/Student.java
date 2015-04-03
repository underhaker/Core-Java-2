package studentComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Student {
    private String name;
    private double grade;
    public Student(String name,double grade){
        this.name=name;
        this.grade=grade;
    }
    public double getGrade(){
        return this.grade;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+","+this.grade;
    }
    public static void main(String[] args) {
        List<Student> l=Arrays.asList(
                new Student("Pesho",4),
                new Student("Zedo",6),
                new Student("Stoqn",6),
                new Student("Damqn",5)
                );
            //System.out.println(l);
        Collections.sort(l, new GradeComparator());
        System.out.print(l);
    }
}
