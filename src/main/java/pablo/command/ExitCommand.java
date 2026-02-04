package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command which signifies exiting Pablo.
 */
public class ExitCommand extends Command {

    public ExitCommand() {

    }

    /**
     * Does nothing.
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {

    }

    /**
     * Returns true to indicate exiting Pablo.
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
