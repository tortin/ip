package pablo.parser;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import pablo.command.AddCommand;
import pablo.command.Command;
import pablo.command.CommandResult;
import pablo.command.NullCommand;
import pablo.fileio.DataLoader;
import pablo.task.Deadline;
import pablo.task.TaskList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static pablo.parser.Parser.parseDeadline;

public class ParserTest {

    private TaskList dummyTaskList = new TaskList();
    private DataLoader dummyStorage = new DataLoader("./data/dummy_data.txt");

    @Test
    public void deadlineParser_success(){
        Command c = parseDeadline("deadline return book /by 06-06-2026_12:00");
        AddCommand add = (AddCommand) c;
        Deadline d = (Deadline) add.getTask();
        assertEquals(new Deadline("return book", false, LocalDateTime.of(2026, 6, 6, 12, 0)), d);
    }

    @Test
    public void deadlineParser_dateFormatError_caught() {
        Command c = Parser.parse("deadline submit report /by nonsense");
        assertInstanceOf(NullCommand.class, c);
        CommandResult cr = c.execute(dummyTaskList, dummyStorage);
        assertEquals("Date and time information must be specified using dd-mm-yyyy_hh:mm",
                cr.getResponse());
    }

    @Test
    public void deadlineParser_indexOutOfBounds_caught() {
        Command c = Parser.parse("deadline submit");
        assertInstanceOf(NullCommand.class, c);
        CommandResult cr = c.execute(dummyTaskList, dummyStorage);
        assertEquals("You must specify a complete by timing for a deadline task using the \"by\" tag!",
                cr.getResponse());
    }
}
