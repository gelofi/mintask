package org.mintask;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;

import org.mintask.Handler;

public class ViewTasks {

    public static void viewAllTasks() {
        try {
            File file = new File("data.txt");
            ArrayList<Handler> handler = new ArrayList<>();
            ObjectInputStream ois = null;

            if (file.isFile()) {
                ois = new ObjectInputStream(new FileInputStream(file));
                handler = (ArrayList<Handler>) ois.readObject();
                ois.close();

                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
                String formattedDate = date.format(myFormatObj);

                System.out.println("---------------------------");
                System.out.println("Saved Tasks | " + formattedDate + "\n");

                ListIterator<Handler> li = handler.listIterator();
                while (li.hasNext()) {
                    System.out.println(li.next());
                }

                System.out.println("---------------------------");
            } else {
                System.out.println("Save file does not exist! Create a task to make one.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while viewing tasks. Restarting...");
            Main.main(null);  // Restart the program in case of an error
        }
    }
}
