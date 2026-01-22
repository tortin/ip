import java.util.Scanner;
import java.lang.StringBuilder;

public class Pablo {
    public static String list_tasks(Task[] tasks, int len) {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= len; i++) {
            output.append(String.format("    %d. ", i));
            output.append(tasks[i - 1].describe());
            if (i != len) {
                output.append("\n");
            }
        }
        return output.toString();
    }

    public static void print_resp(String msg) {
        System.out.println("    ____________________________________________________________");
        System.out.print("    ");
        System.out.println(msg);
        System.out.println("    ____________________________________________________________");
    }

    public static void addTask(Task task, int numTasks) {
        print_resp(String.format("Got it. I've added this task:\n    %s\n    Now you have %d tasks in the list.", task.describe(), numTasks));
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int task_idx = 0;

        print_resp("Hello! I'm Pablo!\n    What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String action = input.split(" ")[0];

        while (!input.equals("bye")) {
            if (action.equals("list")) {
                print_resp(list_tasks(tasks, task_idx));
            } else if (action.equals("todo")) {
                tasks[task_idx] = new ToDo(input.substring("todo ".length()), false);
                addTask(tasks[task_idx], task_idx + 1);
                task_idx++;
            } else if (action.equals("deadline")) {
                String[] parts = input.split(" /by ", 2);
                String task = parts[0].substring("deadline ".length());
                try {
                    String deadline = parts[1];
                    tasks[task_idx] = new Deadline(task, false, deadline);
                    addTask(tasks[task_idx], task_idx + 1);
                    task_idx++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You must specify a complete by timing for a deadline task using the \"by\" tag!");
                }
            } else if (action.equals("event")) {
                String[] parts = input.split(" /from | /to ", 3);
                try {
                    String name = parts[0];
                    String from = parts[1];
                    String to = parts[2];
                    tasks[task_idx] = new Event(name, false, from, to);
                    addTask(tasks[task_idx], task_idx + 1);
                    task_idx++;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You must specify a to and from timing for a Event task using the \"/from\" and \"/to\" tags!");
                }
            } else if (action.equals("mark")) {
                try {
                    tasks[Integer.parseInt(input.split(" ")[1]) - 1].markTask();
                    print_resp(String.format("Nice! I've marked this task as done:\n    %s", tasks[Integer.parseInt(input.split(" ")[1]) - 1].describe()));
                } catch (NullPointerException e) {
                    System.out.println("The task specified doesn't exist!");
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer corresponding to a task to mark as complete!");
                }
            } else if (action.equals("unmark")) {
                try {
                    tasks[Integer.parseInt(input.split(" ")[1]) - 1].unmarkTask();
                    print_resp(String.format("OK, I've marked this task as not done yet:\n    %s", tasks[Integer.parseInt(input.split(" ")[1]) - 1].describe()));
                } catch (NullPointerException e) {
                    System.out.println("The task specified doesn't exist!");
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer corresponding to a task to mark as incomplete!");
                }
            }
            input = scanner.nextLine();
            action = input.split(" ")[0];
        }
        print_resp("Bye. Hope to see you again soon!");
    }
}
