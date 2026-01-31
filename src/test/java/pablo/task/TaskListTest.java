package pablo.task;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    public void addTaskSuccess() {
        TaskList tasks = new TaskList();
        tasks.addTask(new ToDo("submit report", false));
        tasks.addTask(new Deadline("submit report", false, LocalDateTime.of(2000, 1, 1, 0, 0)));
        tasks.addTask(new Event("class", false, LocalDateTime.of(2000, 1, 1, 0, 0),
                LocalDateTime.of(2000, 1, 1, 2, 0)));
    }
}
