package org.mintask;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner act = new Scanner(System.in);
            int action = -1;

            // Main loop to show menu
            do {
                System.out.println("""
                        Mintask 1.0
                        Welcome to Mintask - your personal to-do manager on your command line.
                        Please select an action:
                        
                        1. Add a new task
                        2. View all saved tasks
                        3. Search for a task
                        4. Remove a task
                        5. Edit task details
                        0. Exit program
                        """);

                System.out.print("Action: ");
                action = act.nextInt();

                switch (action) {
                    case 1:
                        AddTask.addNewTask();  // Call AddTask
                        break;
                    case 2:
                        ViewTasks.viewAllTasks();  // Call ViewTasks
                        break;
                    case 3:
                        SearchTask.searchTask();  // Call SearchTask
                        break;
                    case 4:
                        RemoveTask.removeTask();  // Call RemoveTask
                        break;
                    case 5:
                        EditTask.editTask();  // Call EditTask
                        break;
                    case 0:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                        break;
                }
            } while (action != 0);

        } catch (Exception e) {
            System.out.println("An unexpected error has occurred. Restarting program...");
            main(null);  // Restart the program if any error occurs
        }
    }
}
