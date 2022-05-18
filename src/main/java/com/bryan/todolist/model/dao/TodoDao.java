package com.bryan.todolist.model.dao;
import com.bryan.todolist.model.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Integer>{
    
}
