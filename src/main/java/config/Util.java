package config;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import java.util.Properties;

public class Util {

    private static final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/java7");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");


        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");


        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);

        return configuration.buildSessionFactory();

    }
}
