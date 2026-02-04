package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command to filter the task list by a keyword and print them.
 */
public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Finds the tasks whose names contains the keyword and lists them.
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {
        ui.listTasks(tasks.findTasks(this.keyword));
    }
}
