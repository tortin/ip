package pablo.ui;

import java.util.Scanner;

import pablo.task.TaskList;

/**
 * Reads user inputs and prints responses to the terminal.
 */
public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the user's input.
     *
     * @return The user's input in a String format.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints a line separator.
     */
    public void lineSeparator() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Prints an indentation represented by 4 spaces.
     */
    public void indent() {
        System.out.print("    ");
    }

    /**
     * Formats a message with 1 leading and 1 trailing line separator, with the message indented by 4 spaces.
     *
     * @param message The message to be formatted and printed.
     */
    public void showResponse(String message) {
        this.lineSeparator();
        this.indent();
        System.out.println(message);
        this.lineSeparator();
    }

    /**
     * Prints the welcome message.
     */
    public void showWelcome() {
        this.showResponse("Hello! I'm Pablo!\n    What can I do for you?");
    }

    /**
     * Prints the current task list.
     *
     * @param tasks The current task list.
     */
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

    /**
     * Prints the goodbye message.
     */
    public void showGoodbye() {
        this.showResponse("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the error message when the list is unable to be loaded from disk.
     */
    public void showLoadingError() {
        System.out.println("Unable to load list! List is set to empty.");
    }

    /**
     * Prints the error message when the task list cannot be written to disk.
     */
    public void showWriteError() {
        System.out.println("Unable to write to pablo.txt!");
    }

    /**
     * Prints the error message when the user does not enter a date time in the correct format.
     */
    public void showDateTimeFormatError() {
        System.out.println("Date and time information must be specified using dd-mm-yyyy_hh:mm");
    }

    /**
     * Prints the error message when a deadline command was issued, but cannot be parsed properly.
     */
    public void showDeadlineError() {
        System.out.println("You must specify a complete by timing for a deadline task using the \"by\" tag!");
    }

    /**
     * Prints the error message when a event command was issued, but cannot be parsed properly.
     */
    public void showEventError() {
        System.out.println("You must specify a to and from timing for a pablo.task.Event task" +
                " using the \"/from\" and \"/to\" tags!");
    }

    /**
     * Prints the error message when the user tries to access an index larger than the size of the task list.
     */
    public void showIndexError() {
        System.out.println("The specified task does not exist! Specify a number corresponding to a task!");
    }

    /**
     * Prints the error message when an integer is not specified.
     */
    public void showNumFormatError() {
        System.out.println("You must specify an number corresponding to a task to mark/unmark/delete!");
    }

    /**
     * Prints the error message when the command issued is not recognised.
     */
    public void showCommandError() {
        System.out.println("I don't understand that command!");
    }
}
