package pablo.task;

import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String name, boolean done, LocalDateTime from, LocalDateTime to) {
        super(name, done);
        this.from = from;
        this.to = to;
    }

    public String getType() {
        return "E";
    }

    public LocalDateTime getFrom() {
        return this.from;
    }

    public LocalDateTime getTo() {
        return this.to;
    }

    public String describe() {
        return String.format("[E][%s] %s (from: %s to: %s)", this.getDone() ? "X" : " ", this.getName(),
                this.from.format(DATE_FORMATTER), this.to.format(DATE_FORMATTER));
    }

    @Override
    public String toString() {
        return String.format("E | %s | %s | %s | %s", this.getDone() ? "1" : "0", this.getName(),
                this.from.format(DATE_FORMATTER), this.to.format(DATE_FORMATTER));
    }
}
