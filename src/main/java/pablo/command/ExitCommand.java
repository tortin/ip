package pablo.command;

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
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {

    }

    /**
     * Returns true to indicate exiting Pablo.
     * @return
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
