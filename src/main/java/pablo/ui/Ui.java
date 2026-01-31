package pablo.ui;

import java.util.Scanner;

import pablo.task.TaskList;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void lineSeparator() {
        System.out.println("    ____________________________________________________________");
    }

    public void indent() {
        System.out.print("    ");
    }

    public void showResponse(String message) {
        this.lineSeparator();
        this.indent();
        System.out.println(message);
        this.lineSeparator();
    }

    public void showWelcome() {
        this.showResponse("Hello! I'm Pablo!\n    What can I do for you?");
    }

    public void listTasks(TaskList tasks) {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= tasks.size(); i++) {
            output.append(String.format("    %d. ", i));
            output.append(tasks.getTask(i - 1).describe());
            if (i != tasks.size()) {
                output.append("\n");
            }
        }
        this.showResponse(output.toString());
    }

    public void showGoodbye() {
        this.showResponse("Bye. Hope to see you again soon!");
    }

    public void showLoadingError() {
        System.out.println("Unable to load list! List is set to empty.");
    }

    public void showWriteError() {
        System.out.println("Unable to write to pablo.txt!");
    }

    public void showDateTimeFormatError() {
        System.out.println("Date and time information must be specified using dd-mm-yyyy_hh:mm");
    }

    public void showDeadlineError() {
        System.out.println("You must specify a complete by timing for a deadline task using the \"by\" tag!");
    }

    public void showEventError() {
        System.out.println("You must specify a to and from timing for a pablo.task.Event task" +
                " using the \"/from\" and \"/to\" tags!");
    }

    public void showIndexError() {
        System.out.println("The specified task does not exist! Specify a number corresponding to a task!");
    }

    public void showNumFormatError() {
        System.out.println("You must specify an number corresponding to a task to mark/unmark/delete!");
    }

    public void showCommandError() {
        System.out.println("I don't understand that command!");
    }
}
