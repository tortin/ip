package pablo.command;

import pablo.task.TaskList;
import pablo.ui.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui) {
        ui.listTasks(tasks.findTasks(this.keyword));
    }
}
