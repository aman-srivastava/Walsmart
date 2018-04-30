package com.aman.controller;

import com.aman.model.Task;
import com.aman.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asriva26 on 04/25/18.
 */

@Controller
public class TasksController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    public String tasksList(Model model){
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @RequestMapping(value = "/savetask", method = RequestMethod.POST)
    @ResponseBody
    public String saveTask(@RequestBody Task task) {
        taskRepository.save(task);
        return task.getTaskId().toString();
    }

}
