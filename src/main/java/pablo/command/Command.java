package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * Represents a type of command to execute.
 */
public abstract class Command {

    /**
     * Executes the command by modifying the tasklist and providing a response to the user based
     * on the command completed/error caught.
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public abstract void execute(TaskList tasks, Ui ui, DataLoader storage);

    public boolean isExit() {
        return false;
    }
}
