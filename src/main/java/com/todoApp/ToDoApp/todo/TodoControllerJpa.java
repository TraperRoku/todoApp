package com.todoApp.ToDoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @RequestMapping("listTodos")
    public String listAllTodos(ModelMap map){
        String user = getLoggedInUsername(map);
        List<Todo> todos = todoRepository.findByUser(user);
        map.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "addTodo", method = RequestMethod.GET)
    public String addTodo(ModelMap map){
        String user = getLoggedInUsername(map);
        Todo todo = new Todo(0,user,"", LocalDate.now().plusYears(1),false);
        map.put("todo",todo);
        return "addTodo";
    }

    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    public String addTodoPost(ModelMap map, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        String user = getLoggedInUsername(map);
        todo.setUser(user);
        //todo.setId(124 + todoRepository.findLastId());
        todoRepository.save(todo);
        return "redirect:/listTodos";
    }

    @RequestMapping("deleteTodo")
    public String deleteTodo(int id){
        todoRepository.deleteById(id);
        return "redirect:/listTodos";}



    @RequestMapping(value = "updateTodo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap model){

        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "addTodo";
    }

    @RequestMapping(value = "updateTodo", method = RequestMethod.POST)
    public String updateTodoPost(@Valid Todo todo, ModelMap map, BindingResult result){
        if(result.hasErrors()){
            return "updateTodo";
        }
        String username = getLoggedInUsername(map);
        todo.setUser(username);
        todoRepository.save(todo);
        return "redirect:/listTodos";
    }

    private String getLoggedInUsername(ModelMap map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}