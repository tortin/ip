package pablo.task;

import java.time.LocalDateTime;

/**
 * Class representing a deadline task which consists of a deadline, and a name.
 */
public class Deadline extends Task {
    private LocalDateTime by;

    public Deadline(String name, boolean isDone, LocalDateTime by) {
        super(name, isDone);
        this.by = by;
    }

    public LocalDateTime getBy() {
        return this.by;
    }

    public String describe() {
        return String.format("[D][%s] %s (by: %s)", this.getDone() ? "X" : " ",
                this.getName(), this.by.format(DATE_FORMATTER));
    }

    @Override
    public String toString() {
        return String.format("D | %s | %s | %s", this.getDone() ? "1" : "0",
                this.getName(), this.by.format(DATE_FORMATTER));
    }

    /**
     * Checks where 2 deadline tasks are the same. 2 deadline tasks are the same if they have the same name,
     * the same by dateTime, and the same completed status.
     *
     * @param obj   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Deadline)) {
            return false;
        }

        Deadline other = (Deadline) obj;

        return this.getName().equals(other.getName()) &&
                this.getDone() == other.getDone() &&
                this.by.equals(other.by);
    }
}
