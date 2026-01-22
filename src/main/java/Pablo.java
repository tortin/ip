import java.util.Scanner;
import java.lang.StringBuilder;

public class Pablo {
    public static String list_tasks(String[] tasks, int len) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= len; i++) {
            output.append(String.format("%d: %s\n", i, tasks[i - 1]));
        }
        return output.toString();
    }

    public static void print_resp(String msg) {
        System.out.println("____________________________________________________________");
        System.out.println(msg);
        System.out.println("____________________________________________________________");
    }
    public static void main(String[] args) {
        String[] tasks = new String[100];
        int task_idx = 0;

        print_resp("Hello! I'm Pablo!\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            if (!input.equals("list")) {
                tasks[task_idx] = input;
                task_idx++;
                print_resp("added: " + input);
            } else {
                print_resp(list_tasks(tasks, task_idx));
            }
            input = scanner.nextLine();
        }

        print_resp("Bye. Hope to see you again soon!");
    }
}
