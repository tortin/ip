package pablo.command;

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
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {
        try {
            tasks.markTask(markIdx);
            ui.showResponse(String.format("Nice! I've marked this task as done:\n    %s",
                    tasks.getTask(markIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            ui.showIndexError();
        }
    }
}
