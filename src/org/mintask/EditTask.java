package org.mintask;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import org.mintask.Handler;

public class EditTask {

    public static void editTask() {
        try {
            Scanner num = new Scanner(System.in);
            Scanner str = new Scanner(System.in);
            File file = new File("data.txt");
            ArrayList<Handler> handler = new ArrayList<>();
            ObjectInputStream ois = null;

            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                handler = (ArrayList<Handler>) ois.readObject();
                ois.close();

                boolean found = false;
                System.out.print("Enter task number to edit: ");
                int taskNo = num.nextInt();

                ListIterator<Handler> li = handler.listIterator();
                while (li.hasNext()) {
                    Handler e = li.next();
                    if (e.taskNo == taskNo) {
                        System.out.println("Enter new task details:");

                        System.out.print("New Task name: ");
                        String newTask = str.nextLine();

                        System.out.print("New Task subject: ");
                        String newSubject = str.nextLine();

                        li.set(new Handler(taskNo, newTask, newSubject));
                        found = true;
                    }
                }

                if (found) {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(handler);
                    oos.close();
                    System.out.println("Task successfully updated!");
                } else {
                    System.out.println("Task not found!");
                }
            } else {
                System.out.println("Save file does not exist! Create a task to make one.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while editing the task. Restarting...");
            Main.main(null);  // Restart the program in case of an error
        }
    }
}
