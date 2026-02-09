package pablo.command;

/**
 * CommandResult saves the results from executing a command.
 */
public class CommandResult {
    private String pabloResponse;
    private boolean isExit;

    public CommandResult(String pabloResponse) {
        assert !pabloResponse.equals("") : "Response should not be empty!";
        assert pabloResponse != null : "Response should not be null!";
        this.pabloResponse = pabloResponse;
        this.isExit = false;
    }

    public CommandResult(String pabloResponse, boolean isExit) {
        this(pabloResponse);
        this.isExit = true;
    }

    public String getResponse() {
        return this.pabloResponse;
    }

    public boolean getIsExit() {
        return this.isExit;
    }
}
