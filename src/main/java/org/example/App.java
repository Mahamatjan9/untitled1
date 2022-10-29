package org.example;

import model.Course;
import model.Instructor;
import model.Lesson;
import model.Task;
import service.impl.CourseServiceImpl;
import service.impl.InstructorServiceImpl;
import service.impl.LessonServiceImpl;
import service.impl.TaskServpiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        InstructorServiceImpl instructorService = new InstructorServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServpiceImpl taskServpice = new TaskServpiceImpl();



       Course course1 = new Course("Js","asdsfd", LocalDate.of(2000,9,10),"sldkfd","sdfd");
        courseService.saveCourse(course1);
//        courseService.deleteCourseById(1L);

        Course course2 = new Course("Java","asdsfd", LocalDate.of(2000,9,10),"ads","sdd");
        courseService.saveCourse(course2);



        Instructor instructor1 = new Instructor("Mahamatjan", "Islamidinov", "mahamatjan@gmail.com", "+99677098709");
        instructorService.saveInstructor(instructor1);
//       instructorService.deleteInstructorById(2L);
//        instructorService.assignInstructorToCourse(1L,1L);


        Instructor instructor2 = new Instructor("Zhanarbek", "Abdurasulov", "zhanarbek@gmail.com", "+996222020211");
        instructorService.saveInstructor(instructor2);

        Lesson lesson1 =  new Lesson("soft-skil","sdfdhgfh//sdf");
        lessonService.saveLesson(1L,lesson1);

        Lesson lesson2 = new Lesson("English","ghgfd//sdf");
        lessonService.saveLesson(1L,lesson2);

        Lesson lesson3 =  new Lesson("practic","sdfdhgfh//sdf");
        lessonService.saveLesson(2L,lesson3);


        Task task = new Task("OOP",LocalDate.of(2022,9,9),"OOP");
        taskServpice.saveTask(2L,task);

        Task task1 = new Task("Hibernate",LocalDate.of(2023,2,8),"hibernate");
        taskServpice.saveTask(1L,task1);
//        taskServpice.deleteTaskById(2L);


    }
}
