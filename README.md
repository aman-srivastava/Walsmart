# Walsmart
A Full-stack Replenisher Task List Application


### Prerequisites 
* JDK 1.7 or later: [link](https://docs.oracle.com/javase/7/docs/webnotes/install/windows/jdk-installation-windows.html)
* Maven 3 or later: [link](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)


## Installing & Running the App

* Clone the repository
```
git clone https://github.com/aman-srivastava/Walsmart.git
```

### Install using Maven:
* First, navigate to 'Walsmart' folder and build the project as:
```
Walsmart>mvn clean install
```

### Running the generated .war file:
* Next, execute the file generated inside the 'target' folder as:
```
Walsmart>java -jar target/walsmart-0.0.1-SNAPSHOT.war
```

### Running the application:
* Finally, navigate to the following URL, using your web browser:

http://localhost:8080


## Instructions for using the application

* On the [homepage](http://localhost:8080/index.html), click 'Let's get started'.
* The application is divided into the following three main screens:

### Assignments:[link](http://localhost:8080/assignments)

* Select a Task from the dropdown options
* Select a User from the dropdown options
* Click 'Create New Assignment', to assign the selected Task to the selected User

### Users:[link](http://localhost:8080/users)

* To add a new user to the application, enter First Name in the input field
* Next, enter Last Name for the new user
* Select User Group from the dropdown options
* Click 'Create New User'

### Tasks:[link](http://localhost:8080/tasks)

* To add a new template task to the application, enter Task Name in the input field
* Next, select Task Priority from the dropdown options
* Select Estimated Completion Time (ETA) for this template task
* Click 'Create New Task'

## Running Tests:

### Get Test Summary during installation using Maven:
* First, navigate to 'Walsmart' folder and build the project as:
```
Walsmart>mvn clean install
```
* This will print a Test summary of all Tests

### Running individual Tests from the Command Line:
* Navigate to 'Walsmart' folder:
* The following tests are available for running:
```
Walsmart>mvn -Dtest=com.aman.WalsmartTests test

Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest test
Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest#tasksList test
Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest#saveAssignment test
Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest#removeAssignment test
Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest#closeAssignment test
Walsmart>mvn -Dtest=com.aman.controller.AssignmentsControllerTest#updateAssignment test

Walsmart>mvn -Dtest=com.aman.controller.TasksControllerTest test
Walsmart>mvn -Dtest=com.aman.controller.TasksControllerTest#tasksList test
Walsmart>mvn -Dtest=com.aman.controller.TasksControllerTest#saveTask test

Walsmart>mvn -Dtest=com.aman.controller.UsersControllerTest test
Walsmart>mvn -Dtest=com.aman.controller.UsersControllerTest#usersList test
Walsmart>mvn -Dtest=com.aman.controller.UsersControllerTest#saveUser test

```

## Application Screenshots

![Screenshot_1](http://amansrivastava.me/Content/Walsmart/1.jpg)

![Screenshot_2](http://amansrivastava.me/Content/Walsmart/2.png)

![Screenshot_3](http://amansrivastava.me/Content/Walsmart/3.png)

![Screenshot_4](http://amansrivastava.me/Content/Walsmart/4.png)



