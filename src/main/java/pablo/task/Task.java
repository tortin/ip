package pablo.task;

import java.time.format.DateTimeFormatter;

/**
 * Class representing a type of task. A task has a name, can be complete/incomplete, and optionally contains
 * dateTimes representing the start/end timings.
 */
public abstract class Task {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm");
    private String name;
    private boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    /**
     * Marks a task as complete.
     */
    public void markTask() {
        this.isDone = true;
    }

    /**
     * Marks a task as incomplete.
     */
    public void unmarkTask() {
        this.isDone = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean getDone() {
        return this.isDone;
    }

    /**
     * Returns a string describing the task in the format to be printed by the ui.
     *
     * @return String
     */
    public abstract String describe();
}
