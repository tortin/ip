package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;

/**
 * Represents a type of command to execute.
 */
public abstract class Command {

    /**
     * Executes the command by modifying the tasklist and providing a response to the user based
     * on the command completed/error caught.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    public abstract CommandResult execute(TaskList tasks, DataLoader storage);
}
