public class ToDo extends Task{
    public ToDo(String name, boolean done) {
        super(name, done);
    }

    public String getType() {
        return "T";
    }

    public String describe() {
        return String.format("[T][%s] %s", this.getDone() ? "X" : " ", this.getName());
    }
}
