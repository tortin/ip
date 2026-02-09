package pablo.messages;

import pablo.task.TaskList;

/**
 * Contains several messages for known errors.
 */
public class MessageFormatter {
    public static final String WELCOME_MESSAGE = "Hello! I'm Pablo! What can I do for you?";
    public static final String GOODBYE_MESSAGE = "Bye. Hope to see you again soon!";
    public static final String LOADING_ERROR_MESSAGE = "Unable to load list! List is set to empty.";
    public static final String WRITE_ERROR_MESSAGE = "Unable to write to pablo.txt!";
    public static final String DATE_TIME_FORMAT_ERROR_MESSAGE = "Date and time information must be specified " +
            "using dd-mm-yyyy_hh:mm";
    public static final String DEADLINE_ERROR_MESSAGE = "You must specify a complete by timing for a deadline" +
            " task using the \"by\" tag!";
    public static final String EVENT_ERROR_MESSAGE = "You must specify a to and from timing for a pablo.task.Event " +
            "task using the \"/from\" and \"/to\" tags!";
    public static final String INDEX_ERROR_MESSAGE = "The specified task does not exist! Specify a number" +
            " corresponding to a task!";
    public static final String NUM_FORMAT_ERROR_MESSAGE = "You must specify an number corresponding to a task" +
            " to mark/unmark/delete!";
    public static final String COMMAND_ERROR_MESSAGE = "I don't understand that command!";

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
}
