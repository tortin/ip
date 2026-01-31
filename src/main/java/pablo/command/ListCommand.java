package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command to list all tasks currently.
 */
public class ListCommand extends Command{

    public ListCommand() {

    }

    /**
     * Lists all tasks in the task list.
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {
        ui.listTasks(tasks);
    }
}
