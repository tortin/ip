package pablo.command;

import pablo.task.Task;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command which adds the task to the task list.
 */
public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Adds the task to the task list.
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {
        tasks.addTask(task);
        ui.showResponse(String.format("Got it. I've added this task:\n    %s\n    Now you have %d tasks in the list.",
                task.describe(), tasks.size()));
    }

    public Task getTask() {
        return this.task;
    }
}