package dao;

import model.Instructor;


import java.util.List;

public interface InstructorDao {

    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id, Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long course_id,Long instructor_id);

}
