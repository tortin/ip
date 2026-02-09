package pablo.command;

import java.io.IOException;

import pablo.fileio.DataLoader;
import pablo.messages.MessageFormatter;
import pablo.task.TaskList;

/**
 * The command to mark a task as done.
 */
public class MarkCommand extends Command {

    private int markIdx;

    public MarkCommand(int markIdx) {
        this.markIdx = markIdx;
    }

    /**
     * Marks the task corresponding to markIdx as done.
     *
     * @param tasks The current task list.
     * @param storage The dataloader object to read/write tasks.
     */
    @Override
    public CommandResult execute(TaskList tasks, DataLoader storage) {
        try {
            tasks.markTask(markIdx);
            assert tasks.getTask(markIdx).getDone() : "Task was not marked successfully!";
            storage.writeFile(tasks);
            return new CommandResult(String.format("Nice! I've marked this task as done:\n    %s",
                    tasks.getTask(markIdx).describe()));
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(MessageFormatter.INDEX_ERROR_MESSAGE);
        } catch (IOException e) {
            return new CommandResult(MessageFormatter.WRITE_ERROR_MESSAGE);
        }
    }
}
