package pablo.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public int size() {
        return taskList.size();
    }

    public Task getTask(int idx) {
        return taskList.get(idx);
    }

    public void deleteTask(int idx) {
        Task task = this.taskList.get(idx);
        this.taskList.remove(idx);
    }

    public void markTask(int idx) {
        this.taskList.get(idx).markTask();
    }

    public void unmarkTask(int idx) {
        this.taskList.get(idx).unmarkTask();
    }

    public String writeFormat() {
        StringBuilder output = new StringBuilder();
        for (Task task : this.taskList) {
            output.append(task.toString());
            output.append("\n");
        }
        return output.toString();
    }
}
