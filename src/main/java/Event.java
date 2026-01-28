public class Event extends Task{
    private String from;
    private String to;

    public Event(String name, boolean done, String from, String to) {
        super(name, done);
        this.from = from;
        this.to = to;
    }

    public String getType() {
        return "E";
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String describe() {
        return String.format("[E][%s] %s (from: %s to: %s)", this.getDone() ? "X" : " ", this.getName(), this.from, this.to);
    }

    @Override
    public String toString() {
        return String.format("E | %s | %s | %s | %s", this.getDone() ? "1" : "0", this.getName(), this.from, this.to);
    }
}
