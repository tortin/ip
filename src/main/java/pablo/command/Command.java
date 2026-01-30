package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui);

    public boolean isExit() {
        return false;
    }
}
