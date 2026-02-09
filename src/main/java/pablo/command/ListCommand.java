package pablo.command;

import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.TaskList;

/**
 * The command to list all tasks currently.
 */
public class ListCommand extends Command {

    /**
     * Lists all tasks in the task list.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        return new CommandResult(MessageFormatter.listTasks(tasks));
    }
}
