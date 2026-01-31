package pablo;

import java.io.FileNotFoundException;
import java.io.IOException;

import pablo.command.Command;
import pablo.fileio.DataLoader;
import pablo.parser.Parser;
import pablo.task.TaskList;
import pablo.ui.Ui;

public class Pablo {

    private DataLoader dl;
    private TaskList tasks;
    private Ui ui;

    public Pablo(String fileName) {
        ui = new Ui();
        dl = new DataLoader(fileName);
        try {
            tasks = dl.readFile();
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() throws IOException {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String rawCommand = ui.readCommand();
            Command command = Parser.parse(rawCommand);
            command.execute(tasks, ui);
            isExit = command.isExit();
        }
        try {
            dl.writeFile(tasks);
        } catch (IOException e) {
            ui.showWriteError();
        }

        ui.showGoodbye();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Pablo("./data/pablo.txt").run();
    }
}
