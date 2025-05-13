package org.mintask;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.mintask.Handler;

public class AddTask {

    public static void addNewTask() {
        try {
            Scanner num = new Scanner(System.in);
            Scanner str = new Scanner(System.in);
            File file = new File("data.txt");

            ArrayList<Handler> handler = new ArrayList<>();
            ObjectOutputStream oos = null;
            boolean isUnique;
            int taskNo;

            // Check if file exists and read from it
            if (file.isFile()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                handler = (ArrayList<Handler>) ois.readObject();
                ois.close();
            }

            do {
                System.out.print("Enter task number: ");
                taskNo = num.nextInt();

                // Check if the task number already exists
                isUnique = true;
                for (Handler h : handler) {
                    if (h.taskNo == taskNo) {
                        System.out.println("Task number already exists. Please enter a unique task number.");
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);

            System.out.print("Enter task name: ");
            String task = str.nextLine();

            System.out.print("Enter task's subject: ");
            String subject = str.nextLine();

            handler.add(new Handler(taskNo, task, subject));

            // Save the updated list
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(handler);
            oos.close();

            System.out.println("Task successfully added!");

        } catch (Exception e) {
            System.out.println("Error occurred while adding the task. Restarting...");
            Main.main(null);  // Restart the program in case of an error
        }
    }
}
