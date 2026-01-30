public class ListCommand extends Command{

    public ListCommand() {

    }

    public void execute(TaskList tasks, Ui ui) {
        ui.listTasks(tasks);
    }
}
