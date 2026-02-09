package pablo.command;

import java.io.IOException;
import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.TaskList;

/**
 * The command to unmark a task.
 */
public class UnmarkCommand extends Command {
    private int unmarkIdx;

    public UnmarkCommand(int unmarkIdx) {
        this.unmarkIdx = unmarkIdx;
    }

    /**
     * Unmarks the task corresponding to unmarkIdx.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        try {
            tasks.unmarkTask(unmarkIdx);
            storage.writeFile(tasks);
            return new CommandResult(String.format("Nice! I've marked this task as undone:\n    %s",
                    tasks.getTask(unmarkIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(MessageFormatter.INDEX_ERROR_MESSAGE);
        } catch (IOException e) {
            return new CommandResult(MessageFormatter.WRITE_ERROR_MESSAGE);
        }
    }
}
