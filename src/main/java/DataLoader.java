import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class DataLoader {
    private String fileName;

    public DataLoader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Task> readFile() throws FileNotFoundException {
        File file = new File(this.fileName);
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            // Split string by | and leading + trailing spaces
            String[] task_arr = s.nextLine().split("\\s*\\|\\s*");
            char task_type = task_arr[0].charAt(0);
            boolean isDone = task_arr[1].equals("1");

            switch (task_type) {
                case 'T':
                    tasks.add(new ToDo(task_arr[2], isDone));
                    break;
                case 'D':
                    tasks.add(new Deadline(task_arr[2], isDone, task_arr[3]));
                    break;
                case 'E':
                    tasks.add(new Event(task_arr[2], isDone, task_arr[3], task_arr[4]));
                    break;
            }
        }

        return tasks;
    }

    public void writeFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(this.fileName);
        for (Task task : taskList) {
            fw.write(task.toString());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
}
