package com.aman;

import com.aman.model.Assignment;
import com.aman.model.User;
import com.aman.model.Task;
import com.aman.repository.UserRepository;
import com.aman.repository.AssignmentRepository;
import com.aman.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Walsmart implements CommandLineRunner {

	@Autowired
    TaskRepository taskRepository;

	@Autowired
    UserRepository userRepository;

	@Autowired
    AssignmentRepository assignmentRepository;



    public static void main(String[] args) {
		SpringApplication.run(Walsmart.class, args);
	}


    @Override
    public void run(String... strings) throws Exception {

        // Initialize 3 Tasks when server starts

        Task moveBoxes = new Task("Move Boxes","Medium",2L);
        Task arrangeShelfItems = new Task("Arrange Shelf Items","Low",3L);
        Task deliverGoods = new Task("Deliver Goods", "High", 1L);

        taskRepository.save(moveBoxes);
        taskRepository.save(deliverGoods);
        taskRepository.save(arrangeShelfItems);

        // Initialize 3 Users when server starts

        User amanSrivastava = new User("Aman", "Srivastava", "Employee");
        User johnDoe = new User("John", "Doe", "Employee");
        User aliceBob = new User("Alice", "Bob", "Manager");


        userRepository.save(amanSrivastava);
        userRepository.save(johnDoe);
        userRepository.save(aliceBob);

        Assignment assignment = new Assignment();
        assignment.setUser(amanSrivastava);
        assignment.setTask(moveBoxes);
        assignment.setStatus("Open");
        assignment.setNotes("");
        assignment.setDateAssigned(Long.parseLong("1525941863000"));
        assignment.setDeadline(Long.parseLong("1525941863000")+(taskRepository.findOne(1L).getTaskEstimatedTime()*86400000));
        assignmentRepository.save(assignment);
    }


}
