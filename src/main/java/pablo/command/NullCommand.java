package pablo.command;

import pablo.fileio.DataLoader;
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
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {

    }
}
