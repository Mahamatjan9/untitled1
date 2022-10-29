package daoimpl;

import config.Util;
import dao.TaskDao;
import model.Lesson;
import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void saveTask(Long id, Task task) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Lesson lesson = session.find(Lesson.class,id);
            task.setLesson(lesson);
            session.save(task);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("error save task");
        }

    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task1 = session.find(Task.class,id);
            if (task1 == null){
                System.out.println("error");
            }else {
                task1.setDeadline(task.getDeadline());
                task1.setTask(task.getTask());
                task1.setName(task.getName());
                session.merge(task1);
                session.getTransaction().commit();
                session.close();
            }
        }catch (Exception e){
            System.out.println("error update task!!");
        }

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Lesson lesson = session.find(Lesson.class,id);
            List<Task> list = lesson.getTask();
            session.getTransaction().commit();
            session.close();
            return list;
        }catch (Exception e){
            System.out.println("error getAll task by Lesson id!!!");
        }
        return null;

    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.find(Task.class,id);
            task.setLesson(null);
            session.remove(task);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("error delete task by id");
        }

    }
}
