package pablo.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import pablo.command.AddCommand;
import pablo.command.Command;
import pablo.command.DeleteCommand;
import pablo.command.ExitCommand;
import pablo.command.ListCommand;
import pablo.command.MarkCommand;
import pablo.command.NullCommand;
import pablo.command.UnmarkCommand;
import pablo.task.Deadline;
import pablo.task.Event;
import pablo.task.Task;
import pablo.task.ToDo;
import pablo.ui.Ui;

public class Parser {

    private static Ui ui = new Ui();

    public Parser() {

    }

    public static Command parse(String rawCommand) {
        String action = rawCommand.split(" ")[0];

        if (action.equals("list")) {
            return new ListCommand();
        } else if (action.equals("todo")) {
            return new AddCommand(new ToDo(rawCommand.substring("todo ".length()), false));
        } else if (action.equals("deadline")) {
            String[] parts = rawCommand.split(" /by ", 2);
            String task = parts[0].substring("deadline ".length());
            try {
                LocalDateTime deadline = LocalDateTime.parse(parts[1], Task.DATE_FORMATTER);
                return new AddCommand(new Deadline(task, false, deadline));
            } catch (IndexOutOfBoundsException e) {
                ui.showDeadlineError();
            } catch (DateTimeParseException e) {
                ui.showDateTimeFormatError();
            }
        } else if (action.equals("event")) {
            String[] parts = rawCommand.split(" /from | /to ", 3);
            try {
                String name = parts[0];
                LocalDateTime from = LocalDateTime.parse(parts[1], Task.DATE_FORMATTER);
                LocalDateTime to = LocalDateTime.parse(parts[2], Task.DATE_FORMATTER);
                return new AddCommand(new Event(name, false, from, to));
            } catch (IndexOutOfBoundsException e) {
                ui.showEventError();
            } catch (DateTimeParseException e) {
                ui.showDateTimeFormatError();
            }
        } else if (action.equals("mark")) {
            try {
                int markIdx = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
                return new MarkCommand(markIdx);
            } catch (NumberFormatException e) {
                ui.showNumFormatError();
            }
        } else if (action.equals("unmark")) {
            try {
                int unmarkIdx = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
                return new UnmarkCommand(unmarkIdx);
            } catch (NumberFormatException e) {
                ui.showNumFormatError();
            }
        } else if (action.equals("delete")) {
            try {
                int idxToDelete = Integer.parseInt(rawCommand.split(" ")[1]) - 1;
                return new DeleteCommand(idxToDelete);
            } catch (NumberFormatException e) {
                ui.showNumFormatError();
            }
        } else if (action.equals("bye")) {
            return new ExitCommand();
        } else {
            ui.showCommandError();
        }
        return new NullCommand();
    }
}
