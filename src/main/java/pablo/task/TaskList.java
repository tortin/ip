package pablo.task;

import java.util.ArrayList;

/**
 * Class representing a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Creates a new empty TaskList.
     */
    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    /**
     * Adds a task to the task list.
     * @param task
     */
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    /**
     * Returns the size of the task list.
     * @return
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Returns the task at idx.
     * @param idx
     * @return The task at idx.
     */
    public Task getTask(int idx) {
        return taskList.get(idx);
    }

    /**
     * Deletes the task at idx.
     * @param idx
     */
    public void deleteTask(int idx) {
        this.taskList.remove(idx);
    }

    /**
     * Marks the task at idx as completed.
     * @param idx
     */
    public void markTask(int idx) {
        this.taskList.get(idx).markTask();
    }

    /**
     * Marks the task at idx as incomplete.
     * @param idx
     */
    public void unmarkTask(int idx) {
        this.taskList.get(idx).unmarkTask();
    }

    /**
     * Returns a string corresponding to the storage format in the txt file.
     * @return
     */
    public String writeFormat() {
        StringBuilder output = new StringBuilder();
        for (Task task : this.taskList) {
            output.append(task.toString());
            output.append("\n");
        }
        return output.toString();
    }

    /**
     * Filters the task list by the keyword.
     * @param keyword The keyword to search by.
     * @return A tasklist in which the name contains the keyword.
     */
    public TaskList findTasks(String keyword) {
        TaskList filtered = new TaskList();
        for (Task task : this.taskList) {
            if (task.getName().contains(keyword)) {
                filtered.addTask(task);
            }
        }
        return filtered;
    }

    /**
     * Checks if the task list contains a given task
     * @param checkTask The task to check against.
     * @return True if the task list contains the task, false otherwise.
     */
    public boolean containsTask(Task checkTask) {
        for (Task task : taskList) {
            if (checkTask.equals(task)) {
                return true;
            }
        }
        return false;
    }
}
