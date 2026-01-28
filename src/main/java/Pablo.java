import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class Pablo {

    public static void printResp(String msg) {
        System.out.println("    ____________________________________________________________");
        System.out.print("    ");
        System.out.println(msg);
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Get current list of tasks from ./data/pablo.txt
        DataLoader dl = new DataLoader("./data/pablo.txt");
        TaskList tasks = dl.readFile();

        printResp("Hello! I'm Pablo!\n    What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String action = input.split(" ")[0];

        while (!input.equals("bye")) {
            if (action.equals("list")) {
                tasks.listTasks();
            } else if (action.equals("todo")) {
                tasks.addTask(new ToDo(input.substring("todo ".length()), false), true);
            } else if (action.equals("deadline")) {
                String[] parts = input.split(" /by ", 2);
                String task = parts[0].substring("deadline ".length());
                try {
                    String deadline = parts[1];
                    tasks.addTask(new Deadline(task, false, deadline), true);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You must specify a complete by timing for a deadline task using the \"by\" tag!");
                }
            } else if (action.equals("event")) {
                String[] parts = input.split(" /from | /to ", 3);
                try {
                    String name = parts[0];
                    String from = parts[1];
                    String to = parts[2];
                    tasks.addTask(new Event(name, false, from, to), true);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You must specify a to and from timing for a Event task using the \"/from\" and \"/to\" tags!");
                }
            } else if (action.equals("mark")) {
                try {
                    int markIdx = Integer.parseInt(input.split(" ")[1]) - 1;
                    tasks.markTask(markIdx);
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer corresponding to a task to mark as complete!");
                }
            } else if (action.equals("unmark")) {
                try {
                    int unmarkIdx = Integer.parseInt(input.split(" ")[1]) - 1;
                    tasks.unmarkTask(unmarkIdx);
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer corresponding to a task to mark as incomplete!");
                }
            } else if (action.equals("delete")) {
                try {
                    int idxToDelete = Integer.parseInt(input.split(" ")[1]) - 1;
                    tasks.deleteTask(idxToDelete);
                } catch (NumberFormatException e) {
                    System.out.println("Enter an integer corresponding to a task to delete!");
                }
            } else {
                System.out.println("I don't understand that command!");
            }

            input = scanner.nextLine();
            action = input.split(" ")[0];
        }

        try {
            dl.writeFile(tasks);
        } catch (IOException e) {
            System.out.println("Something went wrong writing to pablo.txt");
        }

        printResp("Bye. Hope to see you again soon!");
    }
}
