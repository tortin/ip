package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
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
     *
     * @param tasks The current task list.
     * @param ui The ui object.
     * @param storage The dataloader object to read/write tasks.
     */
    public void execute(TaskList tasks, Ui ui, DataLoader storage) {
        try {
            Task task = tasks.getTask(idxToDelete);
            tasks.deleteTask(this.idxToDelete);
            ui.showResponse(String.format("Noted. I've removed this task:\n    %s\n " +
                    "   Now you have %d tasks in the list.", task.describe(), tasks.size()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The task specified doesn't exist!");
        }
        try {
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showWriteError();
        }
    }
}
