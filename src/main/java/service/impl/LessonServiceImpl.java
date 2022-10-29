package service.impl;

import dao.LessonDao;
import daoimpl.LessonDaoImpl;
import model.Instructor;
import model.Lesson;
import service.InstructorService;
import service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDao lessonDao = new LessonDaoImpl();

    @Override
    public void saveLesson(Long course_id, Lesson lesson) {
    lessonDao.saveLesson(course_id,lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
    lessonDao.updateLesson(id,lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public List<Lesson> getAllCogetLessonsByCoursedurse(Long id) {
        return lessonDao.getAllCogetLessonsByCoursedurse(id);
    }
}
