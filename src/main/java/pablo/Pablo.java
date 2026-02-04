package pablo;

import java.io.FileNotFoundException;
import java.io.IOException;

import pablo.command.Command;
import pablo.fileio.DataLoader;
import pablo.parser.Parser;
import pablo.task.TaskList;
import pablo.ui.Ui;

public class Pablo {

    private DataLoader storage;
    private TaskList tasks;
    private Ui ui;

    public Pablo(String fileName) {
        ui = new Ui();
        storage = new DataLoader(fileName);
        try {
            tasks = storage.readFile();
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the Pablo chatbot, terminated when the user enters "bye"
     *
     * @throws IOException
     */
    public void run() throws IOException {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String rawCommand = ui.readCommand();
            Command command = Parser.parse(rawCommand);
            command.execute(tasks, ui, storage);
            isExit = command.isExit();
        }
        try {
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showWriteError();
        }

        ui.showGoodbye();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Pablo("./data/pablo.txt").run();
    }
}
