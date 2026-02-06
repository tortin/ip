package pablo.command;

import pablo.fileio.DataLoader;
import pablo.task.TaskList;

/**
 * A command which does nothing, used when the parser runs into an error and is unable to find the corresponding
 * command.
 */
public class NullCommand extends Command {

    private String errorMessage;

    public NullCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Does nothing.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        return new CommandResult(errorMessage);
    }
}
