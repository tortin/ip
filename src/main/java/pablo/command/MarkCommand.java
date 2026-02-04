package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command to mark a task as done.
 */
public class MarkCommand extends Command {

    private int markIdx;

    public MarkCommand(int markIdx) {
        this.markIdx = markIdx;
    }

    /**
     * Marks the task corresponding to markIdx as done.
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {
        try {
            tasks.markTask(markIdx);
            ui.showResponse(String.format("Nice! I've marked this task as done:\n    %s",
                    tasks.getTask(markIdx).describe()));
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
