package service;

import model.Lesson;

import java.util.List;

public interface LessonService {

    void saveLesson(Long course_id, Lesson lesson);

    void updateLesson(Long id, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getAllCogetLessonsByCoursedurse(Long id);
}
