package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command to unmark a task.
 */
public class UnmarkCommand extends Command {
    private int unmarkIdx;

    public UnmarkCommand(int unmarkIdx) {
        this.unmarkIdx = unmarkIdx;
    }

    /**
     * Unmarks the task corresponding to unmarkIdx.
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {
        try {
            tasks.unmarkTask(unmarkIdx);
            ui.showResponse(String.format("Nice! I've marked this task as undone:\n    %s",
                    tasks.getTask(unmarkIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            ui.showIndexError();
        }
    }
}
