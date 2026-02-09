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

    /**
     * Checks whether 2 ToDo tasks are the same. 2 ToDo tasks are the same if they have the same name and completed
     * status.
     *
     * @param obj   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ToDo)) {
            return false;
        }

        ToDo other = (ToDo) obj;

        return this.getName().equals(other.getName()) &&
                this.getDone() == other.getDone();
    }
}
