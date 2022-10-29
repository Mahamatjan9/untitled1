package service.impl;

import dao.InstructorDao;
import daoimpl.InstuctorDaoImpl;
import model.Instructor;
import service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private InstructorDao instructorDao = new InstuctorDaoImpl();
    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);


    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);

    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);

    }

    @Override
    public void assignInstructorToCourse(Long course_id, Long instructor_id) {
        instructorDao.assignInstructorToCourse(course_id,instructor_id);

    }
}
