package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {

    }

    public void execute(TaskList tasks, Ui ui) {

    }

    @Override
    public boolean isExit() {
        return true;
    }
}
