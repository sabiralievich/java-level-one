package ru.gb;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final List<Student> listOfStudents = new ArrayList<>();

    public static void main(String[] args) {
        setData();

        getDistinctCoursesList(listOfStudents);

        getMostCurious(listOfStudents);

        getStudentsOnCourse(listOfStudents, new JavaCore());
    }

    private static void getStudentsOnCourse(List<Student> listOfStudents, JavaCore javaCore) {
    }

    private static void getDistinctCoursesList(List<Student> listOfStudents) {
        List<Course> coursesList = listOfStudents.stream()
                .map(Student::getAllCourses)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        for(Course s : coursesList) {
            System.out.println(s.getName());
        }
    }

    private static void getMostCurious(List<Student> listOfStudents) {
        //System.out.println(getListOfStudents().get(0).getAllCourses().get(0).getName());
        List<String> stream = getListOfStudents().stream()
                .map((Function<Student, String>) student -> student.getName())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(stream);
    }



    public static List<Student> getListOfStudents() {
        return listOfStudents;
    }

    private static void setData() {
        JavaCourse javaCourse = new JavaCourse();
        JavaCore javaCore = new JavaCore();
        PythonCourse pythonCourse = new PythonCourse();
       // List<Student> listOfStudents = null;

        Student student1 = new GeekBrainsStudent("John");
        Student student2 = new GeekBrainsStudent("Bill");
        Student student3 = new GeekBrainsStudent("Bob");
        Student student4 = new GeekBrainsStudent("Alice");

        student1.addCourse(javaCourse);
        student1.addCourse(pythonCourse);

        student2.addCourse(javaCore);

        student3.addCourse(pythonCourse);
        student3.addCourse(javaCourse);
        student3.addCourse(javaCore);

        student4.addCourse(pythonCourse);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);

    }

    private static void addStudent(Student student) {

        listOfStudents.add(student);
    }


}
