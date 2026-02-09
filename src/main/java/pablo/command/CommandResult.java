package pablo.command;

/**
 * CommandResult saves the results from executing a command, and allows other classes to know when to
 * terminate the program.
 *
 */
public class CommandResult {
    private String pabloResponse;
    private boolean isExit;

    /**
     * Creates a new CommandResult, isExit is defaulted to false. This constructor is used by all commands other than
     * ExitCommand.
     * @param pabloResponse The message for Pablo to display.
     */
    public CommandResult(String pabloResponse) {
        assert !pabloResponse.equals("") : "Response should not be empty!";
        assert pabloResponse != null : "Response should not be null!";
        this.pabloResponse = pabloResponse;
        this.isExit = false;
    }

    /**
     * Creates a new CommandResult with isExit specified. Use this for ExitCommand.
     * @param pabloResponse The message for Pablo to display.
     * @param isExit Indicates whether the program should terminate.
     */
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
