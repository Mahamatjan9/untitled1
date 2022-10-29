package service;

import model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);

    void updateCourse(Long id,Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void deleteCourseById(Long id);

    Course getCourseByName(String name);
}
