package pablo.task;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskListTest {

    @Test
    public void addTaskSuccess() {
        TaskList tasks = new TaskList();
        tasks.addTask(new ToDo("submit report", false));
        tasks.addTask(new Deadline("submit report", false, LocalDateTime.of(2000, 1, 1, 0, 0)));
        tasks.addTask(new Event("class", false, LocalDateTime.of(2000, 1, 1, 0, 0),
                LocalDateTime.of(2000, 1, 1, 2, 0)));
    }

    @Test
    public void deleteTaskSuccess() {
        TaskList tasks = new TaskList();
        tasks.addTask(new ToDo("submit report", false));
        tasks.addTask(new Deadline("submit report", false, LocalDateTime.of(2000, 1, 1, 0, 0)));
        tasks.addTask(new Event("class", false, LocalDateTime.of(2000, 1, 1, 0, 0),
                LocalDateTime.of(2000, 1, 1, 2, 0)));
        tasks.deleteTask(2);
        tasks.deleteTask(1);
        tasks.deleteTask(0);
    }

    @Test
    public void deleteTask_indexOutOfBounds_throwsException() {
        TaskList tasks = new TaskList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.deleteTask(0);
        });
    }
}
