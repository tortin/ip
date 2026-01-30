package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

public class UnmarkCommand extends Command {
    private int unmarkIdx;

    public UnmarkCommand(int unmarkIdx) {
        this.unmarkIdx = unmarkIdx;
    }

    public void execute(TaskList tasks, Ui ui) {
        try {
            tasks.unmarkTask(unmarkIdx);
            ui.showResponse(String.format("Nice! I've marked this task as undone:\n    %s", tasks.getTask(unmarkIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            ui.showIndexError();
        }
    }
}
