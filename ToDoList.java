package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);             
        ArrayList<String>  tasks = new ArrayList<>();
        ArrayList<Boolean> done  = new ArrayList<>();
        boolean running = true;

        do {
            System.out.println("\n---- ToDo List ----");
            System.out.println("add      – Add task");
            System.out.println("delete   – Delete task");
            System.out.println("status   – Mark / unmark task as done");
            System.out.println("list     – Show all tasks");
            System.out.println("update    – update  task");
            System.out.println("quit     – Exit");
            System.out.print("Enter choice: ");

            String choice = sc.next().toLowerCase();

            switch (choice) {
                case "add":
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter the task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    done.add(false); // default: pending
                    System.out.println(" Task added.");
                    break;

                case "delete":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to delete.");
                        break;
                    }
                    System.out.print("Enter task number (1" + tasks.size() + "): ");
                    int idx = sc.nextInt();
                    if (idx >= 1 && idx <= tasks.size()) {
                        String removed = tasks.remove(idx - 1);
                        done.remove(idx - 1);
                        System.out.println(" Deleted: " + removed);
                    } else {
                        System.out.println("Invalid number.");
                    }
                    break;

                case "status":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to update.");
                        break;
                    }
                    System.out.print("Enter task number to toggle status (1" + tasks.size() + "): ");
                    int sIdx = sc.nextInt();
                    if (sIdx >= 1 && sIdx <= tasks.size()) {
                        boolean newStatus = !done.get(sIdx - 1);
                        done.set(sIdx - 1, newStatus);
                        System.out.println(" Task \"" + tasks.get(sIdx - 1) + "\" marked as "
                                + (newStatus ? "Completed" : "Pending"));
                    } else {
                        System.out.println("Invalid number.");
                    }
                    break;

                case "list":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks added yet.");
                    } else {
                        System.out.println("Your tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            String statusText = done.get(i) ? "Completed" : "Pending";
                            System.out.println((i + 1) + ". " + tasks.get(i) + " [" + statusText + "]");
                        }
                    }
                    break;
                case "update":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks added yet.");
                        break;
                    }

                    System.out.print("Enter task number to update (1-" + tasks.size() + "): ");
                    int uIdx = sc.nextInt();

                    if (uIdx >= 1 && uIdx <= tasks.size()) {
                        sc.nextLine(); 
                        System.out.print("Enter the updated task: ");
                        String newTask = sc.nextLine();

                        tasks.set(uIdx - 1, newTask);
                        done.set(uIdx - 1, false); 

                        System.out.println("Task updated: " + newTask + " [Pending ]");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case "quit":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid option.");
            }

        } while (running);

        sc.close(); 
    }
}
