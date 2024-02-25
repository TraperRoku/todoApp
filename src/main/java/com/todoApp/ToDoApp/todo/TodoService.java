package com.todoApp.ToDoApp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int licznik = 0;
    static{
        todos.add(new Todo(++licznik,"Filip","Do Portfolio Github", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++licznik,"Filip","Do 100 pushups", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++licznik,"Filip","Kupic koszulke Realu Madryt", LocalDate.now().plusYears(1),false));
    }
    public List<Todo> findByUser(String user){
        List<Todo> result = new ArrayList<>();
        todos.stream().filter(todo -> todo.getUser().equals(user)).forEach(result::add);
        return result;
    }
    public void addTodo(String user, String desc, LocalDate targetDate, boolean done){
        todos.add(new Todo(++licznik,user,desc,targetDate,done));
    }
    public void deleteTodoById(int id){
       todos.remove(todos.stream()
               .filter(todo -> todo.getId() == id).findFirst().get());
       licznik--;
    }
   public Todo findById(int id){
        return todos.stream().filter(tood->tood.getId() == id).findFirst().get();
   }
   public void update(Todo todo){
        todos.remove(todos.stream().filter(
                todo1 -> todo1.getId() == todo.getId()).findFirst().get());
        todos.add(todo);
   }
}
