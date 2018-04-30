package com.aman.controller;

import com.aman.model.Assignment;
import com.aman.model.Task;
import com.aman.repository.UserRepository;
import com.aman.repository.AssignmentRepository;
import com.aman.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


/**
 * Created by asriva26 on 04/25/18.
 */

@Controller
public class AssignmentsController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/assignments", method = RequestMethod.GET)
    public String tasksList(Model model){

        // Create TreeSet for computing Task Rank each time the assignments page is requested
        TreeSet<Long> assignmentTreeSet= new TreeSet<>();

        for(Assignment assignment: assignmentRepository.findAll()){
            Date date = new Date(assignment.getDeadline());
            Date date2 = new Date();
            Long diffInMillies = (date.getTime() - date2.getTime());
            assignment.setRank(diffInMillies);
            assignmentTreeSet.add(diffInMillies);
        }

        for(Assignment assignment: assignmentRepository.findAll()){
            assignment.setRank(Long.valueOf(assignmentTreeSet.headSet(assignment.getRank()).size()+1));
            assignmentRepository.save(assignment);
        }

        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("assignments", assignmentRepository.findAll());
        return "assignments";
    }

    @RequestMapping(value="/createassignment", method = RequestMethod.POST)
    @ResponseBody
    public String saveAssignment(@RequestParam Long userId, @RequestParam Long taskId, @RequestParam String date){

        Assignment assignment = new Assignment();
        assignment.setUser(userRepository.findOne(userId));
        assignment.setTask(taskRepository.findOne(taskId));
        assignment.setStatus("Open");
        assignment.setNotes("");
        assignment.setDateAssigned(Long.parseLong(date));
        assignment.setDeadline(Long.parseLong(date)+(taskRepository.findOne(taskId).getTaskEstimatedTime()*86400000));
        assignmentRepository.save(assignment);

        return assignment.getAssignmentId().toString();
    }

    @RequestMapping(value = "/removeassignment", method = RequestMethod.POST)
    @ResponseBody
    public String removeAssignment(@RequestParam Long Id){
        assignmentRepository.delete(Id);
        return Id.toString();
    }

    @RequestMapping(value = "/closeassignment", method = RequestMethod.POST)
    @ResponseBody
    public String closeAssignment(@RequestParam Long Id){
        Assignment assignment = assignmentRepository.findOne(Id);
        assignment.setStatus("Closed");
        assignmentRepository.save(assignment);
        return Id.toString();
    }

    @RequestMapping(value = "/updateassignment", method = RequestMethod.POST)
    @ResponseBody
    public String updateAssignment(@RequestParam Long Id, @RequestParam String notes){
        Assignment assignment = assignmentRepository.findOne(Id);
        assignment.setNotes(notes);
        assignmentRepository.save(assignment);
        return Id.toString();
    }
}