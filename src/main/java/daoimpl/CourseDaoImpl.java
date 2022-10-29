package daoimpl;

import config.Util;
import dao.CourseDao;

import model.Course;
import model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void saveCourse(Course course) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("save Course error");
        }

    }

    @Override
    public void updateCourse(Long id, Course course) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Course course1 = session.find(Course.class,id);
            course1.setName(course.getName());
            course1.setDescription(course.getDescription());
            course1.setDuration(course.getDuration());
            course1.setInstructors(course.getInstructors());
            course1.setLessons(course.getLessons());
            course1.setCreateAt(course.getCreateAt());
            course1.setImagineLink(course.getImagineLink());
            session.merge(course1);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("update course exseption!!!");
        }

    }

    @Override
    public Course getCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            if (course==null){
                System.out.println("no such identifier!!!");
            }
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            System.out.println("no such identifier!!!");
        }
        return null;
    }



    @Override
    public List<Course> getAllCourse() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courses = session.createQuery("select p from Course p ",Course.class).list();
            session.getTransaction().commit();
            session.close();
            return courses;
        }catch (Exception e){
            System.out.println("getAll course exseption!!");
        }

        return null;
    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Course course = session.find(Course.class,id);
            for (Instructor instructor : course.getInstructors()) {
                instructor.setCourse(null);
            }
            session.remove(course);
            session.getTransaction().commit();

            System.out.println("Course deleteCourseById  exseption!");
            session.close();
        } catch (Exception e) {
            System.out.println("no such identifier (deleteCourseById)!!!");
        }



    }

    @Override
    public Course getCourseByName(String name) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c", Course.class).list();
            for (Course course : courses) {
                if (course.getName().equals(name)) {
                    return course;
                } else {
                    System.out.println("error getCourseBy name");
                }

            }
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            System.out.println("error get corse by name");
        }
        return null;
    }
}
