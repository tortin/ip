package pablo;

import pablo.command.CommandResult;
import pablo.fileio.DataLoader;
import pablo.parser.Parser;
import pablo.task.TaskList;

/**
 * The class for a Pablo chatbot.
 */
public class Pablo {

    private DataLoader storage;
    private TaskList tasks;

    /**
     * Creates a new Pablo object linked to the path fileName.
     * @param fileName The path to the data file.
     */
    public Pablo(String fileName) {
        storage = new DataLoader(fileName);
        try {
            tasks = storage.readFile();
        } catch (Exception e) {
            tasks = new TaskList();
        }
    }

    /**
     * Takes a string as raw input, parses and executes the command, returns a CommandResult.
     *
     * @param rawCommand The command in a string to execute.
     * @return A CommandResult.
     */
    public CommandResult parseAndExecute(String rawCommand) {
        return Parser.parse(rawCommand).execute(tasks, storage);
    }
}
