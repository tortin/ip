package pablo.task;

import java.time.LocalDateTime;

/**
 * Class representing an event task, which consists of a from and to dateTime, and a name.
 */
public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Creates a new Event object
     * @param name The name of the task.
     * @param done Whether the task is completed.
     * @param from The start date and time of the event.
     * @param to The end date and time of the event.
     */
    public Event(String name, boolean done, LocalDateTime from, LocalDateTime to) {
        super(name, done);
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return this.from;
    }

    public LocalDateTime getTo() {
        return this.to;
    }

    @Override
    public String describe() {
        return String.format("[E][%s] %s (from: %s to: %s)", this.getDone() ? "X" : " ", this.getName(),
                this.from.format(DATE_FORMATTER), this.to.format(DATE_FORMATTER));
    }

    @Override
    public String toString() {
        return String.format("E | %s | %s | %s | %s", this.getDone() ? "1" : "0", this.getName(),
                this.from.format(DATE_FORMATTER), this.to.format(DATE_FORMATTER));
    }

    /**
     * Checks whether 2 events are the same. 2 events are the same if they have the same name, same to and from
     * dateTimes, and the same completed status.
     *
     * @param obj   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Event)) {
            return false;
        }

        Event other = (Event) obj;

        return this.getName().equals(other.getName())
                && this.getDone() == other.getDone()
                && this.from.equals(other.from)
                && this.to.equals(other.to);
    }
}
