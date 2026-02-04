package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
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
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {
        try {
            tasks.unmarkTask(unmarkIdx);
            ui.showResponse(String.format("Nice! I've marked this task as undone:\n    %s",
                    tasks.getTask(unmarkIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            ui.showIndexError();
        }
        try {
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showWriteError();
        }
    }
}
