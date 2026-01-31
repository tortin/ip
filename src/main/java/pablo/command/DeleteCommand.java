package pablo.command;

import pablo.task.Task;
import pablo.task.TaskList;
import pablo.ui.Ui;

/**
 * The command which deletes a task from the task list.
 */
public class DeleteCommand extends Command {
    private int idxToDelete;

    public DeleteCommand(int idxToDelete) {
        this.idxToDelete = idxToDelete;
    }

    /**
     * Deletes the task corresponding to idxToDelete from tasks.
     * @param tasks
     * @param ui
     */
    public void execute(TaskList tasks, Ui ui) {
        try {
            Task task = tasks.getTask(idxToDelete);
            tasks.deleteTask(this.idxToDelete);
            ui.showResponse(String.format("Noted. I've removed this task:\n    %s\n " +
                    "   Now you have %d tasks in the list.", task.describe(), tasks.size()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task specified doesn't exist!");
        }
    }
}
