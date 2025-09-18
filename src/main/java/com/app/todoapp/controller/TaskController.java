package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// make sures all the endpoints are here

/**
 * Controller responsible for handling all web requests related to tasks
 * it maps incoming http requests to the appropriate service methods and
 * returns the view names for rendering UI
 */
@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Handles GET requests to the root ("/").
     * Fetches all tasks and passes them to the Thymeleaf template.
     * @param model Model to hold task list data for the view
     * @return "tasks" - name of the HTML template to render
     */
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    /**
     * Handles POST requests to create a new task
     * @param title of new task
     * @return Redirects back to the main page after saving
     */
    @PostMapping
    public String createTasks(@RequestParam String title){
        taskService.createTasks(title);
        return "redirect:/";
    }

    /**
     * Handles GET requests to delete a task by its ID.
     * @param id ID of the task to delete
     * @return Redirects back to the main page after deletion
     */
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    /**
     * Handles GET requests to toggle a task's completion status.
     * @param id ID of the task to toggle
     * @return Redirects back to the main page after update
     */
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
