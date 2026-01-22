import java.util.Scanner;
import java.lang.StringBuilder;

public class Pablo {
    public static String list_tasks(Task[] tasks, int len) {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n    ");
        for (int i = 1; i <= len; i++) {
            output.append(String.format("%d. [%s] %s\n    ", i, tasks[i - 1].getDone() ? "X" : " ", tasks[i - 1].getName()));
        }
        return output.toString();
    }

    public static void print_resp(String msg) {
        System.out.println("    ____________________________________________________________");
        System.out.print("    ");
        System.out.println(msg);
        System.out.println("    ____________________________________________________________");
    }
    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int task_idx = 0;

        print_resp("Hello! I'm Pablo!\n    What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                print_resp(list_tasks(tasks, task_idx));
            } else if (input.substring(0, 4).equals("mark")) {
                tasks[input.charAt(5) - '0' - 1].markTask();
                print_resp(String.format("Nice! I've marked this task as done:\n    [X] %s", tasks[input.charAt(5) - '0' - 1].getName()));
            } else if (input.substring(0, 6).equals("unmark")) {
                print_resp(String.format("OK, I've marked this task as not done yet:\n    [ ] %s", tasks[input.charAt(7) - '0' - 1].getName()));
                tasks[input.charAt(7) - '0' - 1].unmarkTask();
            } else {
                tasks[task_idx] = new Task(input, false);
                task_idx++;
                print_resp("added: " + input);
            }
            input = scanner.nextLine();
        }

        print_resp("Bye. Hope to see you again soon!");
    }
}
