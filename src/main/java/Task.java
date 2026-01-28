public abstract class Task {
    private String name;
    private boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public void markTask() {
        this.isDone = true;
    }

    public void unmarkTask() {
        this.isDone = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean getDone() {
        return this.isDone;
    }

    public abstract String getType();

    public abstract String describe();
}
