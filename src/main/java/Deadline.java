public class Deadline extends Task {
    private String by;

    public Deadline(String name, boolean done, String by) {
        super(name, done);
        this.by = by;
    }

    public String getType() {
        return "D";
    }

    public String getBy() {
        return this.by;
    }

    public String describe() {
        return String.format("[D][%s] %s (by: %s)", this.getDone() ? "X" : " ", this.getName(), this.by);
    }
}
