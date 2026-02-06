package pablo.command;

import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.TaskList;

/**
 * The command which signifies exiting Pablo.
 */
public class ExitCommand extends Command {

    public ExitCommand() {

    }

    /**
     * Does nothing.
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        return new CommandResult(MessageFormatter.goodbyeMessage());
    }

    /**
     * Returns true to indicate exiting Pablo.
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
