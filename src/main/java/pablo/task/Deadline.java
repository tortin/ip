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
}
