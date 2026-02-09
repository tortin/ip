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

    /**
     * Creates a new DataLoader object.
     * @param fileName The path to the data file.
     */
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
            String[] taskArr = s.nextLine().split("\\s*\\|\\s*");
            assert taskArr.length <= 5 : "Invalid format found in file!";
            char taskType = taskArr[0].charAt(0);
            assert taskType == 'T' || taskType == 'D' || taskType == 'E' : "Unknown task type in file!";
            assert taskArr[1].equals("1") || taskArr[1].equals("0") : "Unknown completed status in file!";
            boolean isDone = taskArr[1].equals("1");

            switch (taskType) {
            case 'T':
                assert taskArr.length == 3 : "ToDo task must have 3 fields only!";
                tasks.addTask(new ToDo(taskArr[2], isDone));
                break;
            case 'D':
                assert taskArr.length == 4 : "Deadline task must have 4 fields only!";
                tasks.addTask(new Deadline(taskArr[2], isDone, LocalDateTime.parse(taskArr[3], Task.DATE_FORMATTER)));
                break;
            case 'E':
                assert taskArr.length == 5 : "Event task must have 5 fields only!";
                tasks.addTask(new Event(taskArr[2], isDone, LocalDateTime.parse(taskArr[3], Task.DATE_FORMATTER),
                        LocalDateTime.parse(taskArr[4], Task.DATE_FORMATTER)));
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
