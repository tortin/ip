package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command to list all tasks currently.
 */
public class ListCommand extends Command {

    public ListCommand() {

    }

    /**
     * Lists all tasks in the task list.
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {
        ui.listTasks(tasks);
    }
}
