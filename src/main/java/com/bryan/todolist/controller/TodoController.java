package com.bryan.todolist.controller;

import com.bryan.todolist.model.entity.Todo;
import com.bryan.todolist.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 負責接收用戶請求、轉發、產生數據並返回結果
 */
@Controller
public class TodoController {
    @Autowired
    TodoService TService;
    @GetMapping("todos")
    public String getTodos(Model model) {
        Iterable<Todo> it = TService.getTodos();
        model.addAttribute("todolist", it);
        Todo todo = new Todo();
        model.addAttribute("todoObject", todo);
        return "todolist";
    }
    @PostMapping("todos")
    public String createTodo (@ModelAttribute Todo todo, Model model) {
        Iterable<Todo> it = TService.createTodos(todo);
        Todo td = new Todo();
        model.addAttribute("todolist", it);
        model.addAttribute("todoObject", td);
        return "redirect:/todos";
    }

    @ResponseBody
    @PutMapping("/todos/{id}")
    public String update (@PathVariable Integer id, @RequestBody Todo todo) {
        TService.update(id, todo);
        return "OK";
    }
    
    @ResponseBody
    @DeleteMapping("/todos/{id}")
    public String delect (@PathVariable Integer id) {
        TService.delect(id);
        return "OK";
    }
}
