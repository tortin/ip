package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * Represents a type of command to execute.
 */
public abstract class Command {

    /**
     * Executes the command by modifying the tasklist and providing a response to the user based
     * on the command completed/error caught.
     * @param tasks
     * @param ui
     */
    public abstract void execute(TaskList tasks, Ui ui);

    public boolean isExit() {
        return false;
    }
}
