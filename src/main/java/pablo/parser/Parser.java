package pablo.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import pablo.command.AddCommand;
import pablo.command.Command;
import pablo.command.DeleteCommand;
import pablo.command.ExitCommand;
import pablo.command.FindCommand;
import pablo.command.ListCommand;
import pablo.command.MarkCommand;
import pablo.command.NullCommand;
import pablo.command.UnmarkCommand;
import pablo.messages.MessageFormatter;
import pablo.task.Deadline;
import pablo.task.Event;
import pablo.task.Task;
import pablo.task.ToDo;

/**
 * Class to parse user input into the corresponding commands and parameters.
 */
public class Parser {

    public Parser() {

    }
    public static Command parseFind(String rawCommand) {
        String keyword = rawCommand.substring("find ".length());
        return new FindCommand(keyword);
    }

    /**
     * Parses a deadline, in the format "deadline &lttask name&gt /by &ltdateTime&gt"
     *
     * @param rawCommand A string representing the command
     * @return An add command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parseDeadline(String rawCommand) {
        String[] parts = rawCommand.split(" /by ", 2);
        String task = parts[0].substring("deadline ".length());
        try {
            LocalDateTime deadline = LocalDateTime.parse(parts[1], Task.DATE_FORMATTER);
            return new AddCommand(new Deadline(task, false, deadline));
        } catch (IndexOutOfBoundsException e) {
            return new NullCommand(MessageFormatter.deadlineErrorMessage());
        } catch (DateTimeParseException e) {
            return new NullCommand(MessageFormatter.dateTimeFormatErrorMessage());
        }
    }

    /**
     * Parses a event, in the format "deadline &lttask name&gt /from &ltfromDateTime&gt /to &lttoDateTime&gt"
     *
     * @param rawCommand A string representing the command
     * @return An add command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parseEvent(String rawCommand) {
        String[] parts = rawCommand.split(" /from | /to ", 3);
        try {
            String name = parts[0];
            LocalDateTime from = LocalDateTime.parse(parts[1], Task.DATE_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(parts[2], Task.DATE_FORMATTER);
            return new AddCommand(new Event(name, false, from, to));
        } catch (IndexOutOfBoundsException e) {
            return new NullCommand(MessageFormatter.eventErrorMessage());
        } catch (DateTimeParseException e) {
            return new NullCommand(MessageFormatter.dateTimeFormatErrorMessage());
        }
    }

    /**
     * Parses a mark command, in the format "mark &ltidxToMark&gt"
     *
     * @param rawCommand A string representing the command
     * @return A mark command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parseMark(String rawCommand) {
        try {
            int markIdx = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
            return new MarkCommand(markIdx);
        } catch (NumberFormatException e) {
            return new NullCommand(MessageFormatter.numFormatErrorMessage());
        }
    }

    /**
     * Parses an ummark command, in the format "unmark &ltidxToUnmark&gt"
     *
     * @param rawCommand A string representing the command
     * @return An unmark command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parseUnmark(String rawCommand) {
        try {
            int unmarkIdx = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
            return new UnmarkCommand(unmarkIdx);
        } catch (NumberFormatException e) {
            return new NullCommand(MessageFormatter.numFormatErrorMessage());
        }
    }

    /**
     * Parses a delete command, in the format "unmark &ltidxToDelete&gt"
     *
     * @param rawCommand A string representing the command
     * @return A delete command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parseDelete(String rawCommand) {
        try {
            int idxToDelete = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
            return new DeleteCommand(idxToDelete);
        } catch (NumberFormatException e) {
            return new NullCommand(MessageFormatter.numFormatErrorMessage());
        }
    }

    /**
     * Parses a string based on the first token by space separation.
     *
     * @param rawCommand A string representing the command
     * @return A corresponding command if successful/A Null command if parsing is unsuccessful.
     */
    public static Command parse(String rawCommand) {
        String action = rawCommand.split(" ")[0];

        if (action.equals("list")) {
            return new ListCommand();
        } else if (action.equals("todo")) {
            return new AddCommand(new ToDo(rawCommand.substring("todo ".length()), false));
        } else if (action.equals("deadline")) {
            return parseDeadline(rawCommand);
        } else if (action.equals("event")) {
            return parseEvent(rawCommand);
        } else if (action.equals("mark")) {
            return parseMark(rawCommand);
        } else if (action.equals("unmark")) {
            return parseUnmark(rawCommand);
        } else if (action.equals("delete")) {
            return parseDelete(rawCommand);
        } else if (action.equals("bye")) {
            return new ExitCommand();
        } else if (action.equals("find")) {
            return parseFind(rawCommand);
        } else {
            return new NullCommand(MessageFormatter.commandErrorMessage());
        }

    }
}
