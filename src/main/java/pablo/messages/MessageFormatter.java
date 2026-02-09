package pablo.messages;

import pablo.task.TaskList;

/**
 * Contains several messages for known errors.
 */
public class MessageFormatter {
    public MessageFormatter() {

    }

    /**
     * Returns the welcome message.
     */
    public static String welcomeMessage() {
        return "Hello! I'm Pablo! What can I do for you?";
    }

    /**
     * Returns the current task list.
     *
     * @param tasks The current task list.
     */
    public static String listTasks(TaskList tasks) {
        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= tasks.size(); i++) {
            output.append(String.format("    %d. ", i));
            output.append(tasks.getTask(i - 1).describe());
            if (i != tasks.size()) {
                output.append("\n");
            }
        }
        return output.toString();
    }

    /**
     * Returns the goodbye message.
     */
    public static String goodbyeMessage() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Returns the error message when the list is unable to be loaded from disk.
     */
    public static String loadingErrorMessage() {
        return "Unable to load list! List is set to empty.";
    }

    /**
     * Returns the error message when the task list cannot be written to disk.
     */
    public static String writeErrorMessage() {
        return "Unable to write to pablo.txt!";
    }

    /**
     * Returns the error message when the user does not enter a date time in the correct format.
     */
    public static String dateTimeFormatErrorMessage() {
        return "Date and time information must be specified using dd-mm-yyyy_hh:mm";
    }

    /**
     * Returns the error message when a deadline command was issued, but cannot be parsed properly.
     */
    public static String deadlineErrorMessage() {
        return "You must specify a complete by timing for a deadline task using the \"by\" tag!";
    }

    /**
     * Returns the error message when a event command was issued, but cannot be parsed properly.
     */
    public static String eventErrorMessage() {
        return "You must specify a to and from timing for a pablo.task.Event task" +
                " using the \"/from\" and \"/to\" tags!";
    }

    /**
     * Returns the error message when the user tries to access an index larger than the size of the task list.
     */
    public static String indexErrorMessage() {
        return "The specified task does not exist! Specify a number corresponding to a task!";
    }

    /**
     * Returns the error message when an integer is not specified.
     */
    public static String numFormatErrorMessage() {
        return "You must specify an number corresponding to a task to mark/unmark/delete!";
    }

    /**
     * Returns the error message when the command issued is not recognised.
     */
    public static String commandErrorMessage() {
        return "I don't understand that command!";
    }

    /**
     * Returns the error message when the task is already in the task list.
     */
    public static String taskDuplicateMessage() {
        return "The task is already in the task list!";
    }
}
