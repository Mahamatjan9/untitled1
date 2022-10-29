package service;

import model.Task;

import java.util.List;

public interface TaskServic {

    void saveTask(Long id, Task task);

    void updateTask(Long id,Task task);
    List<Task> getAllTaskByLessonId(Long id);

    void deleteTaskById(Long id);
}
