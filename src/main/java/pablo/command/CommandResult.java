package pablo.command;

/**
 * CommandResult saves the results from executing a command.
 */
public class CommandResult {
    private String pabloResponse;

    public CommandResult(String pabloResponse) {
        assert !pabloResponse.equals("") : "Response should not be empty!";
        assert pabloResponse != null : "Response should not be null!";
        this.pabloResponse = pabloResponse;
    }

    public String getResponse() {
        return this.pabloResponse;
    }
}
