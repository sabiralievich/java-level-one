package ru.gb;

import java.util.List;

public interface Student {
    String getName();
    List<Course> getAllCourses();
    void addCourse(Course course);

}

