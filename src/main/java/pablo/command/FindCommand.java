package pablo.command;

import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.TaskList;

/**
 * The command to filter the task list by a keyword and print them.
 */
public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Finds the tasks whose names contains the keyword and lists them.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        return new CommandResult(MessageFormatter.listTasks(tasks.findTasks(this.keyword)));
    }
}
