package daoimpl;

import config.Util;
import dao.InstructorDao;
import model.Course;
import model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InstuctorDaoImpl implements InstructorDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void saveInstructor(Instructor instructor) {
        try(Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
           session.save(new Instructor(instructor.getFirstName(),instructor.getLastName(),
                   instructor.getEmail(),instructor.getPhoneNumber()));
            session.getTransaction().commit();
        }

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instuctor = session.find(Instructor.class,id);

            instuctor.setCourse(instuctor.getCourse());
            instuctor.setEmail(instuctor.getEmail());
            instuctor.setLastName(instuctor.getLastName());
            instuctor.setFirstName(instuctor.getFirstName());
            instuctor.setPhoneNumber(instuctor.getPhoneNumber());
            session.merge(instuctor);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("update instuctor error");
        }

    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instuctor = session.find(Instructor.class,id);
            if (instuctor == null){
                System.out.println("no such identifier!!!");
            }
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("error getInstuctor by id!!!");
        }
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Instructor> instuctors = session.createQuery("select a from Instructor a"
                    , Instructor.class).list();

            session.beginTransaction().commit();
            session.close();
            return instuctors;
        } catch (Exception e){
            System.out.println("error get Instuctor by Course id");
        }
       return null;
    }

    @Override
    public void deleteInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instuctor = session.find(Instructor.class,id);
            session.remove(instuctor);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("delete instuctor error");
        }

    }

    @Override
    public void assignInstructorToCourse(Long course_id, Long instructor_id) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Course course = session.get(Course.class, course_id);
            if (course == null) {
                System.out.printf("no such course!!! (assignInstructorToCourse)");
            }
            else{
                Instructor instructor = session.get(Instructor.class, instructor_id);
                if (instructor == null){
                    System.out.println("no such instructor!!! (assignInstructorToCourse)");
                }
                else{
                    instructor.getCourse().add(course);
                    session.merge(instructor);
                }
            }
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            System.out.println("assignInstructorToCourse course error");
        }
    }


    }

