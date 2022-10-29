package service.impl;

import dao.TaskDao;
import daoimpl.TaskDaoImpl;
import model.Task;
import service.TaskServic;

import java.util.List;

public class TaskServpiceImpl implements TaskServic {
    private TaskDao taskDao = new TaskDaoImpl();
    @Override
    public void saveTask(Long id, Task task) {
        taskDao.saveTask(id,task);

    }

    @Override
    public void updateTask(Long id, Task task) {
    taskDao.updateTask(id,task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskDao.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskDao.deleteTaskById(id);

    }
}
