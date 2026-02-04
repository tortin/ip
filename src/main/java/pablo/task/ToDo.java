package pablo.task;

/**
 * Class representing a ToDo task, containing a name only.
 */
public class ToDo extends Task {
    public ToDo(String name, boolean isDone) {
        super(name, isDone);
    }

    public String describe() {
        return String.format("[T][%s] %s", this.getDone() ? "X" : " ", this.getName());
    }

    @Override
    public String toString() {
        return String.format("T | %s | %s", this.getDone() ? "1" : "0", this.getName());
    }
}
