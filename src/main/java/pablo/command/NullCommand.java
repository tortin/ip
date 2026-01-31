package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * A command which does nothing, used when the parser runs into an error and is unable to find the corresponding
 * command.
 */
public class NullCommand extends Command {

    public NullCommand() {

    }

    /**
     * Does nothing.
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {

    }
}
