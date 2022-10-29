package daoimpl;

import config.Util;
import dao.LessonDao;
import model.Course;
import model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void saveLesson(Long course_id, Lesson lesson) {
        try(Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            Course course = session.get(Course.class,course_id);
            lesson.setCourse(course);
            session.save(lesson);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("error save lesson");
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson1 = session.get(Lesson.class,id);
            if (lesson1 == null){
                System.out.println("no such course!!! (assignInstructorToCourse)");
            }else {
                lesson1.setCourse(lesson.getCourse());
                lesson1.setName(lesson.getName());
                lesson1.setTask(lesson.getTask());
               lesson1.setVideoLink(lesson.getVideoLink());
                session.merge(lesson1);
            }
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("error update lesson");
        }

    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson = session.find(Lesson.class,id);
            if (lesson == null){
                System.out.println("no such identifier!!!");
            }

            session.getTransaction().commit();
            session.close();
            return lesson;
        }catch (Exception e){
            System.out.println("no such identifier!!!");
        }
        return null;
    }

    @Override
    public List<Lesson> getAllCogetLessonsByCoursedurse(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return lessons;
        }catch (Exception e){
            System.out.println("error getAll Coget Lessons!!!!");
        }
        return null;
    }
}
