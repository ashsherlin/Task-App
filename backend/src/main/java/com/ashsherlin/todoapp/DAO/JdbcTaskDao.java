package com.ashsherlin.todoapp.DAO;

import com.ashsherlin.todoapp.exception.DaoException;
import com.ashsherlin.todoapp.model.Task;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTaskDao implements TaskDAO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Task getTaskById(int taskId) {
        Task task = null;
        String sql = "SELECT * FROM tasks WHERE task_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, taskId);
            if (results.next()) {
                task = mapRowToTask(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks ORDER BY date_added;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Task task = mapRowToTask(results);
                tasks.add(task);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        String sql = "INSERT INTO tasks (name, status, notes, tag) VALUES (?, ?, ?, ?) RETURNING task_id;";

        int newId = jdbcTemplate.queryForObject(sql, Integer.class, task.getName(), task.getStatus(), task.getNotes(), task.getTag());
        task.setId(newId);

        return task;
    }

    @Override
    public int deleteTaskById(int taskId) {
        String sql = "DELETE FROM tasks WHERE task_id = ?;";
        return jdbcTemplate.update(sql, taskId);
    }

    @Override
    public Task updateTask(Task modifiedTask) {
        String sql = "UPDATE tasks SET name = ?, status = ?, notes = ?, tag = ? WHERE task_id = ?;";

        jdbcTemplate.update(sql, modifiedTask.getName(), modifiedTask.getStatus(), modifiedTask.getNotes(), modifiedTask.getTag(), modifiedTask.getId());
        return getTaskById(modifiedTask.getId());
    }


    private Task mapRowToTask(SqlRowSet rs) {
        Task task = new Task();
        task.setId(rs.getInt("task_id"));
        task.setName(rs.getString("name"));
        task.setStatus(Boolean.parseBoolean(rs.getString("status")));
        task.setNotes(rs.getString("notes"));
        task.setDateAdded(rs.getDate("date_added").toLocalDate());
        task.setTag(rs.getString("tag"));
        return task;
    }
}
