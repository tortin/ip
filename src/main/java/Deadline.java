public class Deadline extends Task {
    private String by;

    public Deadline(String name, boolean isDone, String by) {
        super(name, isDone);
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

    @Override
    public String toString() {
        return String.format("D | %s | %s | %s", this.getDone() ? "1" : "0", this.getName(), this.by);
    }
}
