package service.impl;

import dao.CourseDao;
import daoimpl.CourseDaoImpl;
import model.Course;
import service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id,course);

    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);

    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }
}
