package com.home.TaskManagementSystem;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskController taskController = new TaskController();
		 // Create users
        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("1", "Description 1", 1,TaskStatus.IN_PROGRESS, user1);
        Task task2 = new Task("2", "Description 2", 2, TaskStatus.IN_PROGRESS,  user2);
        Task task3 = new Task("3", "Description 3", 1, TaskStatus.IN_PROGRESS,  user1);

        // Add tasks to the task manager
        taskController.createTask(task1);
        taskController.createTask(task2);
        taskController.createTask(task3);

        // Update a task
        task2.setDescription("Updated description");
        taskController.updateTask(task2);

        // Search tasks
        List<Task> searchResults = taskController.searchTasks("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getDescription());
        }

        // Filter tasks
//        List<Task> filteredTasks = taskController.filterTasks(TaskStatus.PENDING, 1);
//        System.out.println("Filtered Tasks:");
//        for (Task task : filteredTasks) {
//            System.out.println(task.getDescription());
//        }

        // Mark a task as completed
        taskController.markTaskAsCompleted("1");

        // Get task history for a user
        List<Task> taskHistory = taskController.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getDescription());
        }

        // Delete a task
        taskController.deleteTask("3");
    }

}
