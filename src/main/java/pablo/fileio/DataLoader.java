package pablo.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import pablo.task.Deadline;
import pablo.task.Event;
import pablo.task.Task;
import pablo.task.TaskList;
import pablo.task.ToDo;

/**
 * Class for reading/writing a list of tasks.
 */
public class DataLoader {
    private String fileName;

    public DataLoader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads a .txt file and returns a pablo.task.TaskList.
     *
     * @return taskList
     * @throws FileNotFoundException if the file does not exist.
     */
    public TaskList readFile() throws FileNotFoundException {
        File file = new File(this.fileName);
        TaskList tasks = new TaskList();
        Scanner s = new Scanner(file);

        while (s.hasNext()) {
            // Split string by | and leading + trailing spaces
            String[] task_arr = s.nextLine().split("\\s*\\|\\s*");
            char task_type = task_arr[0].charAt(0);
            boolean isDone = task_arr[1].equals("1");

            switch (task_type) {
            case 'T':
                tasks.addTask(new ToDo(task_arr[2], isDone));
                break;
            case 'D':
                tasks.addTask(new Deadline(task_arr[2], isDone, LocalDateTime.parse(task_arr[3], Task.DATE_FORMATTER)));
                break;
            case 'E':
                tasks.addTask(new Event(task_arr[2], isDone, LocalDateTime.parse(task_arr[3], Task.DATE_FORMATTER),
                        LocalDateTime.parse(task_arr[4], Task.DATE_FORMATTER)));
                break;
            }
        }
        return tasks;
    }

    /**
     * Writes the task list to the file.
     *
     * @param tasks The task list to write.
     * @throws IOException if there is an error in IO.
     */
    public void writeFile(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(this.fileName);
        fw.write(tasks.writeFormat());
        fw.close();
    }
}
