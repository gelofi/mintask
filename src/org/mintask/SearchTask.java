package org.mintask;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import org.mintask.Handler;

public class SearchTask {

    public static void searchTask() {
        try {
            Scanner num = new Scanner(System.in);
            File file = new File("data.txt");
            ArrayList<Handler> handler = new ArrayList<>();
            ObjectInputStream ois = null;

            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                handler = (ArrayList<Handler>) ois.readObject();
                ois.close();

                System.out.print("Enter task number to search: ");
                int taskNo = num.nextInt();

                boolean found = false;
                ListIterator<Handler> li = handler.listIterator();
                while (li.hasNext()) {
                    Handler e = li.next();
                    if (e.taskNo == taskNo) {
                        System.out.println(e);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("404: Task not found.");
                }
            } else {
                System.out.println("Save file does not exist! Create a task to make one.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while searching for the task. Restarting...");
            Main.main(null);  // Restart the program in case of an error
        }
    }
}
