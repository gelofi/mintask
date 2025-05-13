package org.mintask;

import java.io.Serializable;

public class Handler implements Serializable {
    int taskNo;
    String task;
    String subject;

    // Constructor
    public Handler(int taskNo, String task, String subject) {
        this.taskNo = taskNo;
        this.task = task;
        this.subject = subject;
    }

    // To print task details in a clean format
    @Override
    public String toString() {
        return "#" + taskNo + ": " + task + " (" + subject + ")";
    }
}
