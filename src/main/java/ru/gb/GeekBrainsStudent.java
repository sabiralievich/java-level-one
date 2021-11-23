package ru.gb;

import java.util.ArrayList;
import java.util.List;

class GeekBrainsStudent implements Student {

    String name;
    List<Course> courses = new ArrayList();

    @Override
    public String getName() {
        return name;
    }


    @Override
    public List<Course> getAllCourses() {

        return courses;
    }

    public void addCourse (Course course) {
        courses.add(course);
    }

    public GeekBrainsStudent() {}

    public GeekBrainsStudent(String name) {
        this.name = name;
    }


}
