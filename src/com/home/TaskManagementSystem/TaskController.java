package com.home.TaskManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskController {

	Map<String, Task> listOfTasks;
	Map<String, List<Task>> userTasks;

	TaskController() {
		listOfTasks = new ConcurrentHashMap<>();
		userTasks = new ConcurrentHashMap<>();
	}
	
	public void createTask(Task task) {
		listOfTasks.put(task.getId(), task);
        assignTaskToUser(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask) {
        Task existingTask = listOfTasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setStatus(updatedTask.getStatus());
                User previousUser = existingTask.getAssignedUser();
                User newUser = updatedTask.getAssignedUser();
                if (!previousUser.equals(newUser)) {
                    unassignTaskFromUser(previousUser, existingTask);
                    assignTaskToUser(newUser, existingTask);
                }
            }
        }
    }

    public void deleteTask(String taskId) {
        Task task = listOfTasks.remove(taskId);
        if (task != null) {
            unassignTaskFromUser(task.getAssignedUser(), task);
        }
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : listOfTasks.values()) {
            if (task.getDescription().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

//    public List<Task> filterTasks(TaskStatus status, Date startDate, Date endDate, int priority) {
//        List<Task> filteredTasks = new ArrayList<>();
//        for (Task task : tasks.values()) {
//            if (task.getStatus() == status &&
//                    task.getDueDate().compareTo(startDate) >= 0 &&
//                    task.getDueDate().compareTo(endDate) <= 0 &&
//                    task.getPriority() == priority) {
//                filteredTasks.add(task);
//            }
//        }
//        return filteredTasks;
//    }

    public void markTaskAsCompleted(String taskId) {
        Task task = listOfTasks.get(taskId);
        if (task != null) {
            synchronized (task) {
                task.setStatus(TaskStatus.COMPLETED);
            }
        }
    }

    public List<Task> getTaskHistory(User user) {
        return new ArrayList<>(userTasks.getOrDefault(user.getId(), new ArrayList<>()));
    }

    private void assignTaskToUser(User user, Task task) {
        userTasks.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>()).add(task);
    }

    private void unassignTaskFromUser(User user, Task task) {
        List<Task> tasks = userTasks.get(user.getId());
        if (tasks != null) {
            tasks.remove(task);
        }
    }
}
