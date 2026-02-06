package pablo.command;

/**
 * CommandResult saves the results from executing a command.
 */
public class CommandResult {
    private String pabloResponse;

    public CommandResult(String pabloResponse) {
        this.pabloResponse = pabloResponse;
    }

    public String getResponse() {
        return this.pabloResponse;
    }
}
