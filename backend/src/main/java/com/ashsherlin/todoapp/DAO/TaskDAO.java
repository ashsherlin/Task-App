package com.ashsherlin.todoapp.DAO;

import com.ashsherlin.todoapp.model.Task;
import java.util.List;

public interface TaskDAO {

    Task getTaskById(int taskId);
    //gets task by specific ID

    List<Task> getAllTasks();
    //gets All tasks

    Task createTask(Task newTask);
    //Creates a task

    int deleteTaskById(int taskId);
    //Deletes task by specific ID

    Task updateTask(Task modifiedTask);
    //Updates task
}
