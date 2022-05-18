package com.bryan.todolist.service;
import com.bryan.todolist.model.dao.TodoDao;
import com.bryan.todolist.model.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author bryan
 * CRUD
 */
@Service
public class TodoService {
    @Autowired
    TodoDao TDD;

    public Iterable<Todo> getTodos () {
        return TDD.findAll();
    }

    public Iterable<Todo> createTodos(Todo todo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String todoDate = sdf.format(new Date());
        todo.setCreateTime(todoDate);
        todo.setUpdateTime(todoDate);
        TDD.save(todo);
        return getTodos();
    }

    public Todo update (Integer id, Todo todo) {
        try {
            Todo resTodo = findId(id);
            Integer status = todo.getStatus();
            resTodo.setStatus(status);
            return TDD.save(resTodo);
        }catch (Exception exception) {
            return null;
        }
    }

    public Todo findId (Integer id) {
        Todo todo = TDD.findById(id).get();
        return todo;
    }

    public Boolean delect (Integer id) {
        try {
            //Todo resTodo = findId(id);
            TDD.deleteById(id);
            return true;
        }catch (Exception exception) {
            return false;
        }
    }
}
