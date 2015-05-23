package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImpl implements StudentOperations {
    List<Student> students;

    public StudentOperationsImpl(List<Student> listStudents) {
        students = listStudents;
    }

    @Override
    public double getAverageMark() {
        return students.stream().mapToDouble(Student::getGrade).average().getAsDouble();
    }

    @Override
    public List<Student> getAllPassing() {
        return students.stream().filter(s -> s.getGrade() >= 3.0f).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllFailing() {
        return students.stream().filter(s -> s.getGrade() < 3.0f).collect(Collectors.toList());
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        Map<Boolean, List<Student>> m = new HashMap<Boolean, List<Student>>();
        students.stream()
                .filter(s -> s.getGrade() > splitMark)
                .forEach(
                        student -> m.put(true,
                                students.stream().filter(s -> s.getGrade() >= splitMark).collect(Collectors.toList())));
        students.stream()
                .filter(s -> s.getGrade() > splitMark)
                .forEach(
                        student -> m.put(false,
                                students.stream().filter(s -> s.getGrade() < splitMark).collect(Collectors.toList())));
        return m;
    }

    @Override
    public List<Student> orderByMarkDescending() {

        return students.stream().sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> orderByMarkAscending() {
        return students.stream().sorted(Comparator.comparingDouble(Student::getGrade)).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
        List<Student> l = this.orderByMarkDescending();
        OptionalDouble min = l.stream().mapToDouble(Student::getGrade).min();
        return l.stream().filter(s -> s.getGrade() == min.getAsDouble()).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        List<Student> l = this.orderByMarkAscending();
        OptionalDouble max = l.stream().mapToDouble(Student::getGrade).max();
        return l.stream().filter(s -> s.getGrade() == max.getAsDouble()).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        Map<Integer, List<Double>> m = new HashMap<Integer, List<Double>>();
        students.stream()
                .mapToInt(Student::getAge)
                .distinct()
                .forEach(
                        age -> m.put(age, students.stream().filter(ag -> ag.getAge() == age).map(Student::getGrade)
                                .collect(Collectors.toList())));
        return m;
    }

    @Override
    public Map<Gender, java.lang.Double> getAverageMarkByGender() {
        OptionalDouble maleMark = students.stream().filter(s -> s.getGender() == Gender.MALE)
                .mapToDouble(Student::getGrade).average();
        OptionalDouble femaleMark = students.stream().filter(s -> s.getGender() == Gender.FEMALE)
                .mapToDouble(Student::getGrade).average();
        Map<Gender, Double> m = new HashMap<Gender, Double>();
        m.put(Gender.MALE, maleMark.getAsDouble());
        m.put(Gender.FEMALE, femaleMark.getAsDouble());
        return m;
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
        Map<Double, Integer> m = new HashMap<Double, Integer>();
        students.stream()
                .mapToDouble(Student::getGrade)
                .distinct()
                .forEach(
                        grade -> m.put(grade,
                                (int) students.stream().mapToDouble(Student::getGrade).filter(g -> g == grade).count()));
        return m;
    }

    @Override
    public String getEmailToHeader() {
        StringBuilder s = new StringBuilder();
        students.stream().map(Student::getEmail).forEach(str -> s.append(str + ","));
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
        Map<Integer, List<Student>> mapMale = new HashMap<Integer, List<Student>>();
        Map<Integer, List<Student>> mapFemale = new HashMap<Integer, List<Student>>();
        Map<Gender, Map<Integer, List<Student>>> mapGender = new HashMap<Gender, Map<Integer, List<Student>>>();
        students.stream()
                .filter(s -> s.getGender() == Gender.MALE)
                .map(Student::getAge)
                .distinct()
                .forEach(
                        age -> mapMale.put(
                                age,
                                students.stream().filter(s -> s.getGender() == Gender.MALE)
                                        .filter(ag -> ag.getAge() == age).collect(Collectors.toList())));

        students.stream()
                .filter(s -> s.getGender() == Gender.FEMALE)
                .map(Student::getAge)
                .distinct()
                .forEach(
                        age -> mapFemale.put(
                                age,
                                students.stream().filter(s -> s.getGender() == Gender.FEMALE)
                                        .filter(ag -> ag.getAge() == age).collect(Collectors.toList())));

        mapGender.put(Gender.FEMALE, mapFemale);
        mapGender.put(Gender.MALE, mapMale);
        return mapGender;
    }

}
