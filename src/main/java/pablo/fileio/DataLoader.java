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
        assert fileName != null : "File name should not be null!";
        assert !fileName.equals("") : "File name should not be empty!";

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
            assert task_arr.length <= 5 : "Invalid format found in file!";
            char task_type = task_arr[0].charAt(0);
            assert task_type == 'T' || task_type == 'D' || task_type == 'E' : "Unknown task type in file!";
            assert task_arr[1].equals("1") || task_arr[1].equals("0") : "Unknown completed status in file!";
            boolean isDone = task_arr[1].equals("1");

            switch (task_type) {
            case 'T':
                assert task_arr.length == 3 : "ToDo task must have 3 fields only!";
                tasks.addTask(new ToDo(task_arr[2], isDone));
                break;
            case 'D':
                assert task_arr.length == 4 : "Deadline task must have 4 fields only!";
                tasks.addTask(new Deadline(task_arr[2], isDone, LocalDateTime.parse(task_arr[3], Task.DATE_FORMATTER)));
                break;
            case 'E':
                assert task_arr.length == 5: "Event task must have 5 fields only!";
                tasks.addTask(new Event(task_arr[2], isDone, LocalDateTime.parse(task_arr[3], Task.DATE_FORMATTER),
                        LocalDateTime.parse(task_arr[4], Task.DATE_FORMATTER)));
                break;
            default:
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
