package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.Task;
import pablo.task.TaskList;

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
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        try {
            tasks.addTask(task);
            storage.writeFile(tasks);
            return new CommandResult(String.format("Got it. I've added this task:\n    %s\n    " +
                    "Now you have %d tasks in the list.", task.describe(), tasks.size()));
        } catch (IOException e) {
            return new CommandResult(MessageFormatter.WRITE_ERROR_MESSAGE);
        }
    }

    public Task getTask() {
        return this.task;
    }
}
