package com.ashsherlin.todoapp.service;

import com.ashsherlin.todoapp.DAO.TaskDAO;
import com.ashsherlin.todoapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskDAO taskDao;

    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    public Task getTaskById(int id) {
        return taskDao.getTaskById(id);
    }

    public Task createTask(Task task) {
        return taskDao.createTask(task);
    }

    public Task updateTask(Task task) {
        return taskDao.updateTask(task);
    }

    public void deleteTaskById(int id) {
        taskDao.deleteTaskById(id);
    }
}
