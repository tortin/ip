package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.Task;
import pablo.task.TaskList;

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
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        try {
            Task task = tasks.getTask(idxToDelete);
            tasks.deleteTask(this.idxToDelete);
            storage.writeFile(tasks);
            return new CommandResult(String.format("Noted. I've removed this task:\n    %s\n " +
                    "   Now you have %d tasks in the list.", task.describe(), tasks.size()));
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult("The task specified doesn't exist!");
        } catch (IOException e) {
            return new CommandResult(MessageFormatter.writeErrorMessage());
        }
    }
}
