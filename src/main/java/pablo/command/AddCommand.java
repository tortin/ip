package pablo.command;

import pablo.task.Task;
import pablo.task.TaskList;
import pablo.ui.Ui;

public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    public void execute(TaskList tasks, Ui ui) {
        tasks.addTask(task);
        ui.showResponse(String.format("Got it. I've added this task:\n    %s\n    Now you have %d tasks in the list.",
                task.describe(), tasks.size()));
    }

    public Task getTask() {
        return this.task;
    }
}
