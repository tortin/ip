import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task, boolean toPrint) {
        this.taskList.add(task);
        if (toPrint) {
            addTaskMessage(task, this.taskList.size());
        }
    }

    public void deleteTask(int idx) {
        try {
            Task task = this.taskList.get(idx);
            this.taskList.remove(idx);
            printResp(String.format("Noted. I've removed this task:\n    %s\n    Now you have %d tasks in the list.", task.describe(), taskList.size()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task specified doesn't exist!");
        }
    }

    public void markTask(int idx) {
        try {
            this.taskList.get(idx).markTask();
            printResp(String.format("Nice! I've marked this task as done:\n    %s", this.taskList.get(idx).describe()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task specified doesn't exist!");
        }
    }

    public void unmarkTask(int idx) {
        try {
            this.taskList.get(idx).unmarkTask();
            printResp(String.format("Nice! I've marked this task as undone:\n    %s", this.taskList.get(idx).describe()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task specified doesn't exist!");
        }
    }

    public void listTasks() {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= this.taskList.size(); i++) {
            output.append(String.format("    %d. ", i));
            output.append(this.taskList.get(i - 1).describe());
            if (i != this.taskList.size()) {
                output.append("\n");
            }
        }
        printResp(output.toString());
    }

    public String writeFormat() {
        StringBuilder output = new StringBuilder();
        for (Task task : this.taskList) {
            output.append(task.toString());
            output.append("\n");
        }
        return output.toString();
    }

    private static void printResp(String msg) {
        System.out.println("    ____________________________________________________________");
        System.out.print("    ");
        System.out.println(msg);
        System.out.println("    ____________________________________________________________");
    }

    private static void addTaskMessage(Task task, int numTasks) {
        printResp(String.format("Got it. I've added this task:\n    %s\n    Now you have %d tasks in the list.", task.describe(), numTasks));
    }


}
